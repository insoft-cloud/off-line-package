pipeline {
    environment {
        
        registry = "spring-admin"
        registryServer = 'registry.test.paas:5000'
        registryCredential = 'private-docker-reg'
        deploymentFile = 'sample_admin_deployment.yaml'
        kubeConfig = '/home/ubuntu/.kube/config'
    }
    agent any
    stages {
        stage('Environment') {
            parallel {
                stage('docker login') {
                    steps {
                        sh 'sudo docker login $registryServer'
                    }
                }
                stage('docker image lists') {
                    steps {
                        sh 'sudo docker images'
                    }
                }
                
                stage('kubectl check') {
                    steps {
                        sh 'kubectl --kubeconfig=$kubeConfig get nodes'
                    }
                }
            }
        }
        stage('Build Jar') {
            steps {
                sh 'mvn clean install'
            }
        }
        
        stage('Build docker image') {
            steps {
                sh 'sudo docker build -t $registry:latest .'
            }
        }
        stage('Tag private docker repository image') {
            steps {
                sh "sudo docker rmi $registryServer/$registry:latest -f"
                sh 'sudo docker tag $registry:latest $registryServer/$registry:latest'
            }
        }
        stage('Clean docker image') {
            steps{
                sh "sudo docker rmi $registry -f"
            }
        }
        
        stage('Push docker image') {
            steps{
                sh "sudo docker push $registryServer/$registry"
            }
        }
        
        stage('Deploy eureka application on Kubernetes') {
            steps{
            	sh "kubectl --kubeconfig=$kubeConfig apply -f $deploymentFile"
            }
        }
    }
    
}
