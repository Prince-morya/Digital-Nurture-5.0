# spring-learn

Spring Boot 3 / Java 17 project covering the mandatory hands-on exercises for
**Spring REST using Spring Boot 3**.

## Opening in IntelliJ

1. Unzip this folder anywhere on disk.
2. IntelliJ → `File > Open` → select the `spring-rest-handson` folder (the one
   containing `pom.xml`). IntelliJ will detect it as a Maven project and
   import dependencies automatically.
3. Run `SpringLearnApplication` (right-click → Run). The app starts on
   `http://localhost:8090`.

If you're behind a corporate proxy, add the proxy flags when building from
the command line, e.g.

```
mvn clean package -Dhttp.proxyHost=<host> -Dhttp.proxyPort=<port>
```

## In-memory users

| Username | Password | Role  |
|----------|----------|-------|
| user     | pwd      | USER  |
| admin    | pwd      | ADMIN |

## Endpoints and where each hands-on lives

| Exercise | Endpoint | Class |
|---|---|---|
| Create a Spring Web Project using Maven | — | `pom.xml`, `SpringLearnApplication` |
| Spring Core – Load Country from Spring Configuration XML | — | `country.xml`, `SpringLearnApplication#displayCountry` |
| Hello World RESTful Web Service | `GET /hello` | `HelloController` |
| REST - Country Web Service | `GET /country` | `CountryController#getCountryIndia` |
| REST - Get all countries | `GET /countries` | `CountryController#getAllCountries` |
| REST - Get country based on country code | `GET /countries/{code}` | `CountryController#getCountry` |
| REST - Get country exceptional scenario | `GET /countries/{code}` (unknown code) | `CountryNotFoundException` |
| MockMVC - Test get country service | — | `SpringLearnApplicationTests` |
| Create RESTful Web Service to handle POST request of Country | `POST /countries` | `CountryController#addCountry` |
| Validating country code / global exception handler | `POST /countries` (invalid payload) | `GlobalExceptionHandler` |
| Implement REST service for updating an employee | `PUT /employees` | `EmployeeController#updateEmployee` |
| Implement REST DELETE Service | `DELETE /employees/{id}` | `EmployeeController#deleteEmployee` |
| REST service for departments | `GET /departments` | `DepartmentController` |
| Create authentication service that returns JWT | `GET /authenticate` (Basic auth) | `AuthenticationController` |
| Authorize based on JWT | any endpoint, `Authorization: Bearer <token>` | `JwtAuthorizationFilter`, `SecurityConfig` |

## Trying it with curl

```bash
# Hello world - no auth required
curl -s http://localhost:8090/hello

# Get a JWT
curl -s -u user:pwd http://localhost:8090/authenticate

# Call a protected endpoint with the token from above
curl -s -H "Authorization: Bearer <token>" http://localhost:8090/countries

# Create a country (validation kicks in if "code" isn't exactly 2 characters)
curl -s -H "Content-Type: application/json" -H "Authorization: Bearer <token>" \
  -X POST -d '{"code":"IN","name":"India"}' http://localhost:8090/countries
```

## Notes

- `country.xml` and `employee.xml` hold the sample data as Spring bean
  definitions, loaded through `ClassPathXmlApplicationContext`, exactly as
  described in the Spring Core hands-on.
- The JWT secret in `JwtSupport` is hard-coded for the training exercise only;
  in a real project it belongs in a vault/secret manager, not source control.
- `EmployeeDao` keeps its list in memory per application run - restarting the
  app resets any updates/deletes made through the REST API.
