FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY target/crypto-currency-tracker-0.0.1-SNAPSHOT.jar crypto-currency-tracker.jar
ENTRYPOINT ["java","-jar","/crypto-currency-tracker.jar"]