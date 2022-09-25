FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY target/crypto-currency-tracker-0.0.1-SNAPSHOT.jar crypto-currency-tracker.jar
ADD src/main/resources/data.sql data.sql
ENTRYPOINT ["java","-jar","/crypto-currency-tracker.jar"]