# 🎬 Videoclub MVC — Java Backend with MySQL
 
A Java backend application for managing a video club catalogue, built following the **MVC (Model-View-Controller)** pattern with full CRUD persistence via JDBC and MySQL.
 
---
 
## About the Project
 
This project was developed as a practical exercise to implement the **MVC architecture** in a real Java backend, connecting to a relational database using raw JDBC — no ORM.
 
The application allows users to:
- **Create** a new movie by entering its details through the terminal (Scanner)
- **Read** and display the full movie catalogue stored in the database
 
---
 
## Tech Stack
 
| Technology | Version |
|---|---|
| Java | OpenJDK 25 |
| MySQL | 8+ |
| JDBC Driver | mysql-connector-j 9.6.0 |
| Build Tool | Maven |
| IDE | IntelliJ IDEA |
| DB Client | DBeaver 26 |
 
---
 
## Project Structure
 
```
src/main/java/org/example/
├── config/
│   └── DBManager.java          # Database connection lifecycle
├── controller/
│   └── MovieController.java    # Bridges View and Repository
├── model/
│   └── Movie.java              # Domain entity
├── repository/
│   ├── MovieRepository.java    # Interface (contract)
│   └── MovieRepositoryImpl.java# JDBC implementation (Create + Read)
├── view/
│   └── MovieView.java          # Scanner input + console output
└── Main.java                   # Entry point
```
 
---
 
## MVC Flow
 
```
Main
 └── MovieView  (input / output)
      └── MovieController  (orchestration)
           └── MovieRepositoryImpl  (SQL via JDBC)
                └── DBManager  (MySQL connection)
```
 
---
 
## Database Setup
 
Run the following script in DBeaver or any MySQL client:
 
```sql
CREATE DATABASE IF NOT EXISTS the_omen;
 
USE the_omen;
 
CREATE TABLE IF NOT EXISTS movies (
    id       INT AUTO_INCREMENT PRIMARY KEY,
    titulo   VARCHAR(255)  NOT NULL,
    anio     INT           NOT NULL,
    rating   DECIMAL(3,1)  NOT NULL,
    poster   VARCHAR(500),
    sinopsis TEXT
);
```
 
---
 
## Installation & Setup
 
### 1. Clone the repository
 
```bash
git clone <your-repo-url>
cd videoclub-MVC-Backend
```
 
### 2. Add the MySQL driver to `pom.xml`
 
```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>9.6.0</version>
</dependency>
```
 
### 3. Configure database credentials
 
Edit `DBManager.java` if your credentials differ from the defaults:
 
```java
private static final String URL  = "jdbc:mysql://localhost:3306/the_omen";
private static final String USER = "root";
private static final String PASS = "root";
```
 
### 4. Run the application
 
Execute `Main.java` from IntelliJ or via Maven:
 
```bash
mvn compile exec:java -Dexec.mainClass="org.example.Main"
```
 
---
 
## Usage
 
When the application starts, it prompts for movie details via the terminal:
 
```
Escriba el título de la película
> Inception
Escriba el año de la película
> 2010
Escriba el rating de la película
> 8.8
Poner la URL del poster de la película
> https://example.com/inception.jpg
Escriba la sinopsis de la película
> Un ladrón que roba secretos a través de los sueños.
 
Conectado a BBDD con éxito!
Película creada
Conexión cerrada!
 
Conectado a BBDD con éxito!
Titulo: Inception | Año: 2010 | Rating: 8.8 | ...
Conexión cerrada!
```
 
> **Note:** use a dot (`.`) as the decimal separator for the rating field, e.g. `8.8`
 
---
 
## Layer Breakdown
 
### `Movie.java` — Model
Defines the `Movie` entity with fields: `id`, `titulo`, `anio`, `rating`, `poster`, `sinopsis`. Provides two constructors: one with `id` (for reads from DB) and one without (for user-created entries).
 
### `DBManager.java` — Config
Manages the MySQL connection. Exposes `initConnection()` and `closeConnection()` as static methods used by the repository.
 
### `MovieRepository.java` — Repository Interface
Defines the contract: `createMovie(Movie)` and `findAll()`. Follows the Dependency Inversion Principle.
 
### `MovieRepositoryImpl.java` — Repository Implementation
Implements all SQL operations using `PreparedStatement` — no string concatenation, no SQL injection risk.
 
### `MovieController.java` — Controller
Receives calls from the View and delegates to the Repository. Depends on the interface, not the implementation.
 
### `MovieView.java` — View
Handles all user interaction: Scanner for input, `System.out` for output. Isolated from business logic.
 
### `Main.java` — Entry Point
Wires all layers together via constructor injection and kicks off the Create → Read flow.
 
