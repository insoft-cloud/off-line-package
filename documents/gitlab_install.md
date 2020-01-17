## Table of Contents
1. [문서 개요](#1-문서-개요)
    *  [1.1 목적](#11-목적)
    
2. [GITLAB 설치](#2-설치전-준비사항)
    *  [2.1 설치전 준비사항](#21-설치전-준비사항)
    *  [2.2 GIT 설치](#21-GIT-설치)
    *  [2.3 GITLAB 설치](#22-GITLAB-설치)

    
# 1. 문서 개요
### 1.1. 목적

본 문서 오프라인 환경에서 GITLAB을 설치 하는 방법을 기술하였다.

# 2. GITLAB 설치

### 2.1. 설치전 준비사항

본 설치 가이드는 CentOS7, Red Hat Linux 환경에서 GitLab CE: for official Community Edition releases 설치하는 것을 기준으로 하였다.

### 2.2. GIT 설치

-	GIT 소스 컴파일 후 설치

- **GIT 설치 과정**

		$ tar -zxf git-2.23.1.tar.gz
		$ cd git-2.23.1
		$ make configure
		$ ./configure --prefix=/usr
		$ sudo make install

### 2.3. GITLAB 설치

-	packages 폴더 안에 있는 분할된 압축파일 gitlab-ce-12.7.7.tar.gz*  을 분할압축 해지를 한다.
		$ cat gitlab-ce-12.7.7.tar.gz* | tar xvfz -

-	GITLAB 설치

		$ sudo EXTERNAL_URL="http://localhost:9091" rpm -i gitlab.rpm
		$ https://wikidocs.net/16279
		$ https://medium.com/@jjeaby/gitlab-%EC%84%A4%EC%A0%95-%EB%B3%80%EA%B2%BD-f3e0918adac1
		

