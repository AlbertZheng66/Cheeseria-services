FROM maven:3.8.2-openjdk-11 as target

COPY pom.xml pom.xml
RUN mvn dependency:go-offline

COPY src/ src/
RUN mvn package -DskipTests=true


FROM openjdk:11

EXPOSE 8080
COPY --from=target /target/cheeseria.jar /target/cheeseria.jar
ENTRYPOINT ["java", "-jar", "/target/cheeseria"]

