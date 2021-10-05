# wizeline-cloud-project
This project is made with the purpose of learning how to use Spring cloud and Mockito.

In this project i will do a simple API for inventory management where:
  - If you make a sale, the stock of the product is reduced.
  - If you bought a product, the stock is incremented.

And a second simple API for CRM where:
  - You can add new leads.
  - You can add an opportunity to a lead.

For Spring Cloud i will use:
  - Gateway: It will be our proxy to have only one port to access all our micro services.
  - Ribbon: It will be our load balancer.
  - Eureka server: It allows our micro services communicate with each other without hard-coding the hostname and port.
  - Hystrix: It will be our circuit breaker to avoid unnecesary failures.
  - Spring config: It gives us a centralized configuration for our services
![alt text](https://spring.io/images/cloud-diagram-dark-b902fd07e60945a9a8930ca01f86bdf3.svg)

