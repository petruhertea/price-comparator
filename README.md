# Price Comparator - Market

![Java](https://img.shields.io/badge/java-17-blue)
![Spring Boot](https://img.shields.io/badge/spring--boot-3.x-brightgreen)
![Build](https://img.shields.io/badge/build-passing-brightgreen)

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
- `dao/` – Interfaces for database access using Spring Data JPA
- `dto/` - Data Transfer Objects for basket items and product history
- `entity/` – JPA entity models (Product, PriceAlert, etc.)
- `rest/` – REST API endpoints
- `scheduler/` – Scheduled tasks (e.g., hourly alert evaluation)
- `service/` – Business logic and alert checking
- `util/` – Utility classes (e.g., unit conversion)

---
## 🌐 Main endpoints
- `GET /api/v1/products` - overview of all products
- `GET /api/v1/discounts` - overview of all discounts
- `POST /api/v1/alerts` - create a new price alert
- `GET /api/v1/alerts/{userId}` - view active price alerts
- `DELETE /api/v1/alerts/{id}` - delete active price alerts
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
# If you need to work with environment variables, create an env.properties file in the same folder as application.properties
# spring.config.import=env.properties

spring.datasource.url=jdbc:mysql://localhost:3306/market
spring.datasource.username=your_username
spring.datasource.password=your_password

# Hibernate/JPA logging
# logging.level.org.hibernate.SQL=trace
# logging.level.org.hibernate.orm.jdbc.bind=trace
```
---
### 5. Run the application
```bash
./mvnw spring-boot:run
```
Once started, the application will be available at:
```
http://localhost:8080
```
---
## 🧪 6. Testing

### 📬 Testing the API with Postman
To test the API endpoints, you can use Postman. Follow these steps:
#### 1. Start the application:
```bash
./mvnw spring-boot:run
```

#### 2. Access the API locally (default port is 8080):
```
http://localhost:8080/
```

#### 3. Manually test endpoints, such as:
- `GET /api/v1/products` - List all products.
- `GET /api/v1/products/{productId}/history?store=lidl&category=lactate&brand=zuzu` - List a product's price history. Filters are optional and can be added to narrow down the result.
- `GET /api/v1/products/{productId}/recommendations` - List product recommendations based on their category, the best price and its id.
- `POST /api/v1/basket/best-deals` - Send basket consisting of the user's shopping list to get the best available deals across all stores for the given products.
- `GET /api/v1/discounts` - List all discounts.
- `GET /api/v1/discounts/best` - List best available discounts.
- `GET /api/v1/discounts/new` - List recently added discounts, in our code only the discounts added within 24 hours are shown.
- `GET /api/v1/alerts/{userId}` - List a user's active price alerts.
- `POST /api/v1/alerts` - Create a new price alert.
- `DELETE /api/v1/alerts/{alertId}` - Delete an active alert.

### 📝 Example Request Bodies (POST)
Here are sample request bodies you can use in Postman to test the main POST endpoints.

#### `POST /api/v1/basket/best-deals`

```json
[
    {
        "productId": "P009",
        "quantity": 2
    },
    {
        "productId": "P003",
        "quantity": 5
    }
]
```
Please note that **productId** starts from P001 and ends at P070 for my given data.

Response:

```json
[
    {
        "storeName": "Kaufland",
        "items": [
            {
                "productName": "brânză telemea",
                "brand": "Hochland",
                "storeName": "Kaufland",
                "category": "lactate",
                "originalPrice": 12.5,
                "discountedPrice": 11.25,
                "packageQuantity": 0.3,
                "packageUnit": "kg",
                "pricePerUnit": "37,50 RON/kg",
                "totalPrice": 22.5
            },
            {
                "productName": "iaurt grecesc",
                "brand": "Olympus",
                "storeName": "Kaufland",
                "category": "lactate",
                "originalPrice": 10.8,
                "discountedPrice": 10.8,
                "packageQuantity": 0.4,
                "packageUnit": "kg",
                "pricePerUnit": "27,00 RON/kg",
                "totalPrice": 54.0
            }
        ],
        "totalBasketPrice": 76.5
    }
]
```

#### `POST /api/v1/alerts`

```json
{
    "userId": "your-username",
    "productId": "P026",
    "targetPrice": 6
}
```

Response:

```json
{
    "id": 2,
    "userId": "your-username",
    "productId": "P026",
    "targetPrice": 6.0,
    "active": true
}
```

### ✅ Running Unit Tests
The project includes unit tests to validate core business logic and repository behavior.

To run the tests:
```bash
./mvnw test
```

After running the tests, a summary will appear in the terminal. You can also view detailed reports (e.g., in ```target/surefire-reports``` for Maven).
---
## Author
### Petruț Herțea
