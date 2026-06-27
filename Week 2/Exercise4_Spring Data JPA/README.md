# ORM Learn – Spring Data JPA with Spring Boot & Hibernate

A hands-on project covering ORM concepts from Hibernate XML/Annotation config
through to full Spring Data JPA CRUD, following SOLID and clean-code principles.

---

## Prerequisites

| Tool            | Version  |
|-----------------|----------|
| Java            | 11+      |
| Maven           | 3.6+     |
| MySQL Server    | 8.0      |
| MySQL Workbench | 8.x      |
| IntelliJ IDEA   | Any      |

---

## First-Time Setup

### 1. Database

Open MySQL Workbench (or the `mysql` CLI) and run:

```sql
source src/main/resources/db-setup.sql
```

This creates the `ormlearn` schema, the `country` table, and seeds all countries.

### 2. Credentials

Open `src/main/resources/application.properties` and update:

```properties
spring.datasource.username=root
spring.datasource.password=your_actual_password
```

### 3. Import into IntelliJ

File → Open → select the `orm-learn` folder → Trust project → wait for Maven import to finish.

---

## Project Structure

```
src/main/java/com/cognizant/ormlearn/
├── OrmLearnApplication.java          ← Entry point + test runner
├── model/
│   └── Country.java                  ← JPA entity (@Entity, @Table, @Id, @Column)
├── repository/
│   └── CountryRepository.java        ← Extends JpaRepository – zero boilerplate
└── service/
    ├── CountryService.java           ← All business logic with @Transactional
    └── exception/
        └── CountryNotFoundException.java
```

---

## Hands-On Exercises

| HO   | Feature                          | Method in CountryService          |
|------|----------------------------------|-----------------------------------|
| HO-1 | Get all countries                | `getAllCountries()`                |
| HO-5 | Search by partial name           | `searchCountriesByName(keyword)`  |
| HO-6 | Find by country code             | `findCountryByCode(code)`         |
| HO-7 | Add a new country                | `addCountry(country)`             |
| HO-8 | Update a country's name          | `updateCountry(code, newName)`    |
| HO-9 | Delete a country                 | `deleteCountry(code)`             |

Each exercise has a dedicated `testXxx()` method in `OrmLearnApplication.java`.
Comment/uncomment the call in `main()` to run only the exercise you want.

---

## Running the Application

```bash
# From the project root
mvn clean package
mvn spring-boot:run
```

Or in IntelliJ: right-click `OrmLearnApplication.java` → **Run**.

---

## Key Design Decisions

- **Constructor injection** over `@Autowired` on fields (SOLID – Dependency Inversion)
- **Checked exception** `CountryNotFoundException` so callers handle missing data explicitly
- **Repository derives queries from method names** (`findByNameContainingIgnoreCase`) – no manual SQL
- **`@Transactional` on service layer** – Spring manages session lifecycle, no Hibernate boilerplate
- **`ddl-auto=validate`** – safe for production; won't silently drop or alter tables
