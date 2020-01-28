FROM openjdk:8

ADD target/ROOT.war ROOT.war
ENV JAVA_OPTS=""
ENTRYPOINT ["java","-jar","/ROOT.war"]
