FROM tomcat:8.5.47-jdk8-openjdk

WORKDIR /app

ARG WAR_FILE

COPY target/${WAR_FILE} /usr/local/tomcat/webapps/cadastro-pessoas.war

EXPOSE 8080

