# Reward Portal Prototype

Prototype of a credit card web reward portal. Cloud enabled microservices using Spring Cloud Eureka stack. 

## Component: 

* Eureka Server
* Inventory Service
* Order Service 

## Public API 

*  /product/list
 * GET request to get available 

* /order/create
  * POST request to create order 
  * Sample Request Body:  
   ```
   Name: "John"
   OpenId: "12345"
   items: [{
      productId: "3300",
      productQuantity: 2
   }]
   ```


