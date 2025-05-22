# Price Comparator - Market

## 📘 General Description
**Price Comparator - Market** is a backend application built with Java and Spring Boot that allows users to compare food product prices across various stores (e.g., Lidl, Kaufland, Profi). It tracks historical pricing data, provides the best daily deals, and notifies users when their desired products drop below a target price.

The goal is to help users make smarter, more cost-effective grocery shopping decisions.

---

## 🧩 Main Features
- Price comparison based on standard units (e.g., kg, L).
- Tracking of historical price changes.
- Best daily deals and smart shopping cart recommendations.
- User-defined price alerts (email/in-app).
- Product suggestions based on discounts and historical trends.

---

## 💻 Technologies Used
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL (as the primary relational database)
- Maven

---

## 🗂️ Application Structure
- `entity/` – JPA entity models (Product, PriceAlert, etc.)
- `repository/` – Interfaces for database access using Spring Data JPA
- `service/` – Business logic and alert checking
- `controller/` – REST API endpoints
- `util/` – Utility classes (e.g., unit conversion)
- `scheduler/` – Scheduled tasks (e.g., hourly alert evaluation)

---

## ▶️ How to Run Locally

### 1. Clone the repository
```bash
git clone https://github.com/petruhertea/price-comparator-market.git
cd price-comparator-market
```
### 2. Configure the database
Make sure you have MySQL installed and running locally.

You can create a new schema called market:
```sql
create schema market;
```

### 3. (Optional) Import sample data
A SQL backup file named market-sample-data.sql is provided in the /backup directory.

To import it into your database:
```bash
mysql -u username -p password < backup/market-sample-data.sql
```

### 4. Update application.properties
Open src/main/resources/application.properties and set your local database credentials:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/price_comparator_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 5. Run the application
```bash
./mvnw spring-boot:run
```
Once started, the application will be available at:
```
http://localhost:8080
```
