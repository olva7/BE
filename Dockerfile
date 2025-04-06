FROM openjdk:17-alpine

VOLUME /tmp
COPY /target/MI_Project-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/app.war
RUN sh -c 'touch /usr/local/tomcat/webapps/app.war'
EXPOSE 8083

ENTRYPOINT ["sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar /usr/local/tomcat/webapps/app.war --server.port=8083"]

