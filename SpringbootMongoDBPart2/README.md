# modules
- customer-service
- order-service
- inventory-service
- pricing-service
- shipping-service

# Tech stack
springboot-starter 2.4.4 , java 15,mongo:4.4.5, spring-boot-starter-data-mongodb

### maven build command
- spring-boot:build-image -DskipTests

### docker command
- docker run -it --network project_network --name mongodb -p 27017:27017 mongo:4.4.5
- docker-compose up
- docker-compose run mongo

## customer-service
### urls

|Method | URL|
| :--------------|:-------------|
|GET(single customer)| http://localhost:8000/customer-service/customer/{id} |
|GET(List of customer)| http://localhost:8000/customer-service/customer |
|POST (create single customer) | http://localhost:8000/customer-service/customer |
|PUT (edit single customer)| http://localhost:8000/customer-service/customer/{id} |
|DELETE(single customer) | http://localhost:8000/customer-service/customer/{id} |
|Swagger| URL |
|swagger-api-docs| http://localhost:8080/v2/api-docs |
|HealthCheck| URL |
|check-MongoClient| http://localhost:8000/customer-service/health-check/check-MongoClient |
|showDatabases | http://localhost:8000/customer-service/health-check/showDatabases |
|check-CustomerDb | http://localhost:8000/customer-service/health-check/check-CustomerDb |
|create-CustomerDb | http://localhost:8000/customer-service/health-check/create-CustomerDb |
|create-CustomerCollection|http://localhost:8000/customer-service/health-check/create-CustomerCollection|
|get-CustomerCollection|http://localhost:8000/customer-service/health-check/get-CustomerCollection|

- GET json {
  "firstName":"John",
  "lastName":"Mason",
}
-  POST json {
    "firstName":"John",
    "lastName":"Mason",
     "address":{"shipping":[],"billing":[]
    }
   }
- 

## order-service
### urls

|Method | URL|
| :--------------|:-------------|
|GET(single order)| http://localhost:8200/order-service/order/{id} |
|POST (create single order) | http://localhost:8200/order-service/order |
|PUT (edit single order)| http://localhost:8200/order-service/order/{id} |
|DELETE(single order) | http://localhost:8200/order-service/order/{id} |
|Swagger| URL |
|swagger-api-docs| http://localhost:8080/v2/api-docs |
|HealthCheck| URL |
|check-MongoClient| http://localhost:8200/order-service/health-check/check-MongoClient |
|showDatabases | http://localhost:8200/order-service/health-check/showDatabases |
|check-OrderDb | http://localhost:8200/order-service/health-check/check-OrderDb |
|create-OrderDb | http://localhost:8200/order-service/health-check/create-OrderDb |
|create-OrderCollection|http://localhost:8200/order-service/health-check/create-OrderCollection|

-  POST json {
   "itemNumber":"2144",
   "quantity":"4"
   }
- 

## inventory-service
### urls

|Method | URL|
| :--------------|:-------------|
|GET(single inventory)| http://localhost:8100/inventory-service/inventory/{id} |
|POST (create single inventory) | http://localhost:8100/inventory-service/inventory |
|PUT (edit single inventory)| http://localhost:8100/inventory-service/inventory/{id} |
|DELETE(single inventory) | http://localhost:8100/inventory-service/inventory/{id} |
|Swagger| URL |
|swagger-api-docs| http://localhost:8080/v2/api-docs |
|HealthCheck| URL |
|check-MongoClient| http://localhost:8100/inventory-service/health-check/check-MongoClient |
|showDatabases | http://localhost:8100/inventory-service/health-check/showDatabases |
|check-InventoryDb | http://localhost:8100/inventory-service/health-check/check-InventoryDb |
|create-InventoryDb | http://localhost:8100/inventory-service/health-check/create-InvetoryDb |
|create-InventoryCollection|http://localhost:8100/inventory-service/health-check/create-InventoryCollection|

-  POST json {
   "itemNumber":"2144",
   "quantity":"4"
   }
- 

## pricing-service
### urls

|Method | URL|
| :--------------|:-------------|
|GET(single pricing)| http://localhost:8300/pricing-service/pricing/{id} |
|POST (create single pricing) | http://localhost:8300/pricing-service/pricing |
|PUT (edit single pricing)| http://localhost:8300/pricing-service/pricing/{id} |
|DELETE(single pricing) | http://localhost:8300/pricing-service/pricing/{id} |
|Swagger| URL |
|swagger-api-docs| http://localhost:8080/v2/api-docs |
|HealthCheck| URL |
|check-MongoClient| http://localhost:8300/pricing-service/health-check/check-MongoClient |
|showDatabases | http://localhost:8300/pricing-service/health-check/showDatabases |
|check-PricingDb | http://localhost:8300/pricing-service/health-check/check-PricingDb |
|create-PricingDb | http://localhost:8300/pricing-service/health-check/create-PricingDb |
|create-PricingCollection|http://localhost:8300/pricing-service/health-check/create-PricingCollection|

-  POST json {
   "itemNumber":"2144",
   "quantity":"4"
   }
-

## shipping-service
### urls

|Method | URL|
| :--------------|:-------------|
|GET(single pricing)| http://localhost:8400/shipping-service/shipping/{id} |
|POST (create single pricing) | http://localhost:8400/shipping-service/shipping |
|PUT (edit single pricing)| http://localhost:8400/shipping-service/shipping/{id} |
|DELETE(single pricing) | http://localhost:8400/shipping-service/shipping/{id} |
|Swagger| URL |
|swagger-api-docs| http://localhost:8080/v2/api-docs |
|HealthCheck| URL |
|check-MongoClient| http://localhost:8400/shipping-service/health-check/check-MongoClient |
|showDatabases | http://localhost:8400/shipping-service/health-check/showDatabases |
|check-ShippingDb | http://localhost:8400/shipping-service/health-check/check-ShippingDb |
|create-ShippingDb | http://localhost:8400/shipping-service/health-check/create-ShippingDb |
|create-ShippingCollection|http://localhost:8400/shipping-service/health-check/create-ShippingCollection|

-  POST json {
   "itemNumber":"2144",
   "quantity":"4"
   }
- 