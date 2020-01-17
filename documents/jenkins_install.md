## Table of Contents
1. [문서 개요](#1-문서-개요)
    *  [1.1 목적](#11-목적)
    
2. [GITLAB 설치](#2-설치전-준비사항)
    *  [2.1 설치전 준비사항](#21-설치전-준비사항)
    *  [2.2 jre8 설치](#22-설치전-준비사항)
    *  [2.3 설치전 준비사항](#23-설치전-준비사항)
    
# 1. 문서 개요
### 1.1. 목적

본 문서 오프라인 환경에서 Jenkins를 설치 하는 방법을 기술하였다.

# 2. Jenkins 설치

### 2.1. 설치전 준비사항

본 설치 가이드는 CentOS7, Red Hat Linux 환경에서 Jenkins 설치하는 것을 기준으로 하였다.

### 2.2. jre8 설치

-	Jenkins를 설치 하기 전에 Jenkins 를 구동하기 위해 jre8 를 설치 한다. 
- 	jre server 버전은 packages 폴더 안에서 다운로드 받음.

- **java 설치**

		$ tar -zxf server-jre-8u241-linux-x64.tar.gz
		$ sudo vi /etc/profile
		  맨아래 아래 내용 추가
                  #JAVA
			export JAVA_HOME=/home/tester/java/jdk1.8.0_241
			export PATH=$PATH:$JAVA_HOME/bin
			export CLASSPATH=.:$JAVA_HOME/lib/tools.jar
		$ source /etc/profile
		$ java -version

### 2.3. maven 설치

-	Jenkins에서 maven 빌드를 하기 위해 maven 3.6.1 설치 
- 	maven은 packages 폴더 안에서 다운로드 받음.

- **maven 설치**

		$ tar -zxf  apache-maven-3.6.1-bin.tar.gz
		$ sudo vi /etc/profile
		  맨아래 아래 내용 추가
                  #MAVEN
			export MAVEN_HOME=/home/tester/apache-maven-3.6.1
			export PATH=$PATH:$MAVEN_HOME/bin
			
		$ source /etc/profile
		$ mvn -version

