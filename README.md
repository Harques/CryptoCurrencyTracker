# Crpyto Currency Tracker
## Scenario
This project is a cryptocurrency tracker app which allows its users to create alerts to be notified when a price of a coin reaches the price user determines.

User can create multiple alerts and can track the alert status anytime (triggered or waiting).

There is also currency list page where all coins with their current prices are listed.

The admin user also manages the currencies that will be listed on the app.

## Tech stack
- [Spring Boot](https://spring.io/projects/spring-boot)
- Java 8+ or Kotlin
- Gradle or Maven
- Spring Data JPA
- Hibernate
- MySQL or PostgreSQL
- GIT for version control

## General Application Constraints
- Data should only be accepted from the registered users with their ownership rights.
- There are two types of users: Admin and User.
    - Both user types can create alerts.
    - Both users can query currencies.
    - Only admin can manage the currency types in the system.
