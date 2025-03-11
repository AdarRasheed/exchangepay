# ExchangePay

**ExchangePay** is a Java-based assignment project designed to demonstrate technical competence in currency exchange and billing calculations.

Note:- An export of the postman collection has also been provided alongside the sourcecode, it demonstrates how to authenticate and hit the request properly

## Things Accomplished So Far:

- **Clean code principles** followed with **meaningful names** and **consistent formatting**
- **SOLID Principles** idealized and **Design Patterns** such as **`Builder`** and **`Transformer`** utilized
- **N-Tier Architectural Pattern** implemented
- **Java best practices** followed, avoiding **`null`** values, handling **exceptions**, and **encapsulating data**
- **Spring Boot best practices** followed with **smart dependency injection**, **configuration management**, and **API design**
- **Maven** utilized for **structured package organization**, **project dependencies management**, and **builds**
- **Decoupled components** setup, with **no hardcoded dependencies or passwords**, ensuring **scalability and security**
- **Proper branching and tracking** best practices followed for **individual features delivery**
- **Test cases** established for API (**further and extensive coverage is possible and much recommended**)
- **Smart discount feature** introduced utilizing **`Strategy` Design Pattern**
- **Swagger integrated** for **thorough API and models documentation**

## Prerequisites

### Java Version
- Java **21** is required to run this project.

### Exchange API Setup
To enable currency conversion, you must obtain an **Exchange API Key** and configure it in the `application.properties` file.

#### Sign Up for an API Key
1. Visit [ExchangeRate API](https://app.exchangerate-api.com/) and create an account.
2. Obtain your API key from the dashboard.
3. Add the key to your `application.properties` file:

   ```properties
   exchange.api.key=YOUR_API_KEY_HERE

Project Setup
1. Clone the Repository

git clone https://github.com/your-repository/exchangepay.git
cd exchangepay

2. Build the Project

mvn clean install

3. Run the Application

mvn spring-boot:run

4. Testing the API

curl -X POST http://localhost:8080/api/bill/calculate \
-H "Content-Type: application/json" \
-d '{
"userId": "12345",
"userType": "REGULAR",
"itemDTOs": [
{
"id": "item-001",
"category": "ELECTRONICS",
"price": 199.99
}
],
"customerSince": "2020-05-15",
"originalCurrency": "USD",
"targetCurrency": "EUR"
}'

Expected Response:

{
"currency": "EUR",
"totalAmount": 185.00,
"discountApplied": 10.00,
"finalAmount": 175.00
}
