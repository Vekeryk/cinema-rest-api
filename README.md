# Cinema Room REST Service
<!-- ABOUT THE PROJECT -->
## About The Project
Simple Spring REST service that will help you manage a small movie theatre.
* Show the available seats
* Sell and refund tickets with UUID token
* Display the statistics of your venue
* Configure from properties

<!-- REST API RESOURCES -->
# REST API

## Information about the venue
`GET /api/v1/seats`
### Response
```
{
    "total_rows": 9,
    "total_columns": 9,
    "available_seats": [
        {
        "row": 1,
        "column": 2,
        "price": 50.0
        },
        ...
        {
        "row": 9,
        "column": 9,
        "price": 32.0
        }
    ]
}
```

## Book seat and get ticket
* Example 1: a correct `POST /api/v1/purchase`
### Request
```
{
    "row": 1,
    "column": 1
}
```
### Response
```
{
    "token": "ce813f85-629b-4b66-be88-9404f1e90de7",
    "ticket": {
        "row": 1,
        "column": 1,
        "price": 50.0
    }
}
```

* Example 2: `POST /api/v1/purchase` , but the ticket is already booked
### Request
```
{
    "row": 1,
    "column": 1
}
```
### Response
```
{
    "error": "The ticket has been already purchased!"
}
```

## Refund ticket
* Example 1: a correct `POST /api/v1/return`
### Request
```
{
    "token": "ce813f85-629b-4b66-be88-9404f1e90de7"
}
```
### Response
```
{
    "returned_ticket": {
        "row": 1,
        "column": 1,
        "price": 50.0
    }
}
```

* Example 2: `POST /api/v1/return` with an expired or invalid token
### Request
```
{
    "token": "ce813f85-629b-4b66-be88-9404f1e90de7"
}
```
### Response
```
{
    "error": "Wrong token!"
}
```

## Venue statistic
* Example 1: correct `GET /api/v1/stats?password=super_secret`
### Response
```
{
    "current_income": 100.0,
    "number_of_available_seats": 79,
    "number_of_purchased_tickets": 2
}
```

* Example 2: `GET /api/v1/stats?password=wrong_password`, but password is missing or wrong
### Response
```
{
    "error": "The password is wrong!"
}
```