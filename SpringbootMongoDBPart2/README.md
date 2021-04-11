# modules
- customer-service
- order-service

# Tech stack
springboot-starter 2.4.4 , java 11,mongo:4.4.5

## customer-service
### urls

|Method | URL|
| :--------------|:-------------|
|GET(single customer)| http://localhost:8000/customer-service/customer/{id} |
|POST (create single customer) | http://localhost:8000/customer-service/customer |
|PUT (edit single customer)| http://localhost:8000/customer-service/customer/{id} |
|DELETE(single customer) | http://localhost:8000/customer-service/customer/{id} |
-  POST json {
    "firstname":"John",
    "lastname":"Mason"
   }
- 
