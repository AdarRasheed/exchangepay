# ExchangePay

**ExchangePay** is a Java-based assignment project designed to demonstrate technical competence in currency exchange and billing calculations.

Note:- An export of the postman collection has also been provided alongside the sourcecode, it demonstrates how to authenticate and hit the request properly

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
