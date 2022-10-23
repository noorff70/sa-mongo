#create a package first
#mvn package -Dmaven.test.skip

# For Java 11, try this
FROM adoptopenjdk/openjdk11:alpine-jre

# Refer to Maven build -> finalName
ARG JAR_FILE=target/displayvideo-0.0.1-SNAPSHOT.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/spring-boot-web.jar /opt/app/sa-mongo.jar
COPY ${JAR_FILE} sa-mongo.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","sa-mongo.jar"]

# Make docker file
# C:\dev\repos\studyaid\sa-gateway>docker build -t sa-mongo .

# Make docker file for dockerhub
# docker build -t faizulnoor/sa-mongo .

#run docker file
#C:\dev\repos\studyaid\sa-gateway>docker run -d -p 8080:8080 -t sa-mongo-image