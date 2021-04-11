# modules
- customer-service
- order-service
- inventory-service
- 

# Tech stack
springboot-starter 2.4.4 , java 11,mongo:4.4.5

### maven build command
- spring-boot:build-image -DskipTests

## customer-service
### urls

|Method | URL|
| :--------------|:-------------|
|GET(single customer)| http://localhost:8000/customer-service/customer/{id} |
|POST (create single customer) | http://localhost:8000/customer-service/customer |
|PUT (edit single customer)| http://localhost:8000/customer-service/customer/{id} |
|DELETE(single customer) | http://localhost:8000/customer-service/customer/{id} |
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
|GET(single order)| http://localhost:8000/order-service/order/{id} |
|POST (create single order) | http://localhost:8000/order-service/order |
|PUT (edit single order)| http://localhost:8000/order-service/order/{id} |
|DELETE(single order) | http://localhost:8000/order-service/order/{id} |
-  POST json {
   "itemNumber":"2144",
   "quantity":"4"
   }
- 