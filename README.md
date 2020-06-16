# Reward Portal Prototype

Prototype of a credit card web reward portal. Cloud enabled microservices using Spring Cloud Eureka stack. 

## Component: 

* Eureka Server
* Inventory Service
* Order Service 
* Configuration Center
* Gateway

## Public API 
* /product/list
  * GET request to get availiable reward merchandise 
* /product/listForOrder
  * POST request to get Id specified merchandise, internal use for order service
  * Request body is list of String ("ProductId")
* /product/decreaseStock
  * POST trequest to decrease inventory based on order
  * Sample request body
  ```
  [{
	productId:"1",
	productQuantity:2
  }]
  
  ```

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


