pipeline {
    environment {
        
        registry = "spring-webapp"
        registryCredential = 'private-docker-reg'
    }
    agent any
    stages {
        stage('Environment') {
            parallel {
                stage('docker login') {
                    steps {
                        sh 'sudo docker login dockerregistry:5000'
                    }
                }
                stage('docker image lists') {
                    steps {
                        sh 'sudo docker images'
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
        stage('Deploy docker image') {
            steps {
                withDockerRegistry([ credentialsId: registryCredential, url: "" ]) {
                    sh 'sudo docker push $registry:latest'
                }
            }
        }
        stage('Clean docker image') {
            steps{
                sh "sudo docker rmi $registry"
            }
        }
     }
    
}
