# Shashank Singh Chauhan

## Video Demo Link: https://youtu.be/881ekuJlFWk

## H2 database URL
1. http://localhost:8080/h2-console/
2. jdbc url -  jdbc:h2:mem:order_management

## Note: For creating resources, i have used getRequest instead of post (because without postman we can test using simple browser)
## Example Endpoints
1. http://localhost:8080/api/v1/add-customer/username/shashank - Create user by giving name ("Shashank")
2. http://localhost:8080/api/v1/customers/discountDetail - Get All Discount Information of Customers
3. http://localhost:8080/api/v1/customers/id/1 - Find Customer By ID
4. http://localhost:8080/api/v1/customers - Find All Customers
5. http://localhost:8080/api/v1/create-order/cust-id/1/amount/100 - Create Order
6. http://localhost:8080/api/v1/order/id/1 - Find Order By Id
7. http://localhost:8080/api/v1/orders - Final All Orders

## Technologies Used
1. Spring Boot
2. H2 Database
3. Spring Data
4. MVC Architecture

## Important Points to Note
1. Extract the file and import in the intellij idea
2. No, need to import database, I have used in-memory database (H2 database)
3. h2 console datasource: jdbc:h2:mem:order_management
4. Default username and no password for h2 database
5. Testcases are present under test folder (src/main/test)

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.1/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.1/reference/htmlsingle/#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.0.1/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.0.1/reference/htmlsingle/#using.devtools)
