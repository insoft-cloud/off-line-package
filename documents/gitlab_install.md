## Table of Contents
1. [문서 개요](#1-문서-개요)
    *  [1.1 목적](#11-목적)
    
2. [GITLAB 설치](#2-설치전-준비사항)
    *  [2.1 설치전 준비사항](#21-설치전-준비사항)
    
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


