# Hospital Notification System

## Project Description
A Java application built using the Spring Framework to manage patient notifications through Email, SMS, and Emergency notification services.

## Technologies Used
- Java
- Spring Framework
- Maven
- IntelliJ IDEA
- Git and GitHub

## Features
- Email notifications for routine patient communication.
- SMS notifications for direct phone alerts.
- Emergency notifications for critical ICU alerts.
- Dependency Injection using `@Autowired`.
- Bean selection using `@Primary` and `@Qualifier`.
- Configuration management using `@Value`.
- Secure environment variable management.

## Spring Concepts
- **@Component:** Registers classes as Spring beans.
- **@Autowired:** Injects required dependencies.
- **@Primary:** Selects EmailNotificationService by default.
- **@Qualifier:** Selects the emergency notification service.
- **@Value:** Injects hospital configuration and API secrets.

## Setup Instructions
1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Configure Java and Maven.
4. Create a `.env` file using `.env.example` as a template.
5. Add your hospital configuration values.
6. Reload Maven dependencies.
7. Run the `main()` method in `PatientAlertProcessor.java`.

## Security
The `.env` file is excluded from Git using `.gitignore`. Never upload real API credentials to GitHub.

## Author
**Lena Abatoni**