FROM frolvlad/alpine-oraclejre8:slim
#ARG JAR_FILE=target/*.jar
ARG JAR_FILE
#COPY ${JAR_FILE} app.jar
ADD ${JAR_FILE} /app.jar
EXPOSE 9999
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]