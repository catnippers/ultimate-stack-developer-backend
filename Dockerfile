#
# Back End Build stage
#
FROM maven:3.6.3-jdk-8 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package
#
# Back End Package stage
#
FROM gcr.io/distroless/java
COPY --from=build /usr/src/app/target/*.jar /usr/app/app.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/usr/app/app.jar"]
