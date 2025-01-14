## Practice with below examples (You can find any Open APIs on the internet):

### 5 GET APIs with different response type

```
GET https://api.coingecko.com/api/v3/simple/price?ids=bitcoin&vs_currencies=usd
Response (200 OK):
{
    "bitcoin": {
        "usd": 43000
    }
}
```

```
GET https://api.api-ninjas.com/v1/city?name=New York
Response (200 OK):
[
    {
        "name": "New York",
        "country": "United States",
        "population": 8419600
    }
]

```

```
GET https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key={API_KEY}
Response (200 OK):
{
    "photos": [
        {
            "id": 102693,
            "img_src": "https://mars.nasa.gov/msl-raw-images/proj/msl/"
        }
    ]
}
```

```
GET https://restcountries.com/v3.1/name/france
Response (200 OK):
[
    {
        "name": {
            "common": "France",
            "official": "French Republic"
        },
        "capital": ["Paris"]
    }
]
```

### 5 Post API with json request body, please also paste the response here
```
POST https://api.example.com/register
Request:
{
    "username": "johndoe",
    "password": "securePass123"
}
Response (201 Created):
{
    "user_id": "user_456",
    "username": "johndoe"
}

```
```
POST https://api.example.com/products
Request:
{
    "name": "Smartphone",
    "price": 699.99
}
Response (201 Created):
{
    "product_id": "prod_789",
    "name": "Smartphone",
    "price": 699.99
}
```

```
POST https://api.example.com/feedback
Request:
{
    "user_id": "user_456",
    "message": "Great service!"
}
Response (201 Created):
{
    "feedback_id": "fb_123",
    "status": "received"
}

```

```
POST https://api.example.com/reservations
Request:
{
    "name": "Alice",
    "date": "2025-02-10",
    "time": "19:00"
}
Response (201 Created):
{
    "reservation_id": "res_567",
    "status": "confirmed"
}
```

```
POST https://api.example.com/auth/signin
Request:
{
    "email": "alice@example.com",
    "password": "password123"
}
Response (200 OK):
{
    "token": "eyJhbGciOiJIUzI1Ni...",
    "user_id": "user_789"
}
```
### 3 PUT API with json request body, please also paste the response here


```
PUT https://api.example.com/users/user_456
Request:
{
    "username": "john_updated",
    "email": "john_updated@example.com"
}
Response (200 OK):
{
    "user_id": "user_456",
    "username": "john_updated",
    "email": "john_updated@example.com"
}
```


```
PUT https://api.example.com/products/prod_789
Request:
{
    "name": "Smartphone Pro",
    "price": 799.99
}
Response (200 OK):
{
    "product_id": "prod_789",
    "name": "Smartphone Pro",
    "price": 799.99
}
```

```
PUT https://api.example.com/reservations/res_567
Request:
{
    "date": "2025-02-12",
    "time": "20:00"
}
Response (200 OK):
{
    "reservation_id": "res_567",
    "status": "updated"
}

```
### 2 DELETE API
```
DELETE https://api.example.com/users/123
Response (204 No Content)
```

```
DELETE https://api.example.com/posts/456
Response (200 OK):
{
    "message": "Post successfully deleted"
}
```

### Each example with 404, 401,500 and any http status codes you know

- 401 Unauthorized
```
{
    "error": "Authentication failed",
    "message": "Invalid credentials"
}

```

- 403 Forbidden
```
{
    "error": "Access denied",
    "message": "You do not have permission to perform this action"
}

```

- 404 Not Found
```
{
    "error": "Resource not found",
    "message": "The requested item does not exist"
}
```

- 400 Bad Request
```
{
    "error": "Invalid input",
    "message": "Missing required field 'email'"
}
```

- 500 Internal Server Error
```
{
    "error": "Unexpected server error",
    "message": "Please try again later"
}
```