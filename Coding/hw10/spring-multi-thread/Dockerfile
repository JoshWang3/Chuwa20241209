FROM tomcat:10.1-jdk17-openjdk

ADD ./target/spring-multi-thread-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/

EXPOSE 8080
CMD ["catalina.sh", "run"]