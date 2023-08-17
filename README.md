# poc-of-order-management

## Detailed descriptions of sample applications are available here
## https://medium.com/@dev.fethi/poc-of-order-management-system-77a8c102d1c7

## Tech Stack

* Java 17
* Spring Boot 3.1.0
* Spring Data JPA
* Hibernate
* postgresql
* MongDB
* RabbitMQ


## Installation & Run


## API Root Endpoint
`http://localhost:8080/api/orders/55555555`

```
[
    {
        "quantity":2,
        "price":14.5,
        "productId":1
    },
    {
        "quantity":2,
        "price":85.5,
        "productId":2
    }
]
```
`http://localhost:8083/api/order/allWithPagination?pageNo=1&pageSize=10`

`http://localhost:8083/api/orderItem/order/64de12bbcbaa0f61a615bd5f?pageNo=1&pageSize=10`
