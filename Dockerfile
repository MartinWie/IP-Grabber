FROM maven:3.8.6-amazoncorretto-11 as build
COPY pom.xml ./
RUN mvn verify clean
COPY . .
RUN mvn package

FROM amazoncorretto:11-al2-jdk as main
WORKDIR /root/
COPY --from=0 /target/*-SNAPSHOT.jar app.jar
CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","./app.jar"]