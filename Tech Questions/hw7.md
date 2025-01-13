### Postman practice
### Practice with below examples (You can find any Open APIs on the internet):
### 5 GET APIs with different response type

- Get Users List
```
GET https://api.github.com/users
Response (200 OK):
[
  {
    "login": "mojombo",
    "id": 1,
    "type": "User"
  }
]
```
- Get Weather Data
```
GET https://api.openweathermap.org/data/2.5/weather?q=London&appid={key}
Response (200 OK):
{
    "main": {
        "temp": 280.15,
        "humidity": 81
    }
}
```
- Get Book Details
```
GET https://www.googleapis.com/books/v1/volumes?q=harry+potter
Response (200 OK):
{
    "items": [
        {
            "id": "wrOQLV6xB-wC",
            "volumeInfo": {
                "title": "Harry Potter"
            }
        }
    ]
}
```
- Get Country Info
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
- Get NASA APOD
```
GET https://api.nasa.gov/planetary/apod?api_key={key}
Response (200 OK):
{
    "title": "Astronomy Picture of the Day",
    "explanation": "Description here",
    "url": "image_url"
}
```
### 5 Post API with json request body, please also paste the response here
- Create User
```
POST https://api.example.com/users
Request:
{
    "name": "John Doe",
    "email": "john@example.com"
}
Response (201 Created):
{
    "id": "123",
    "name": "John Doe",
    "email": "john@example.com"
}
```
- Create Order
```
POST https://api.example.com/orders
Request:
{
    "product_id": "xyz",
    "quantity": 2
}
Response (201 Created):
{
    "order_id": "ord_123",
    "status": "confirmed"
}
```
- Create Post
```
POST https://api.example.com/posts
Request:
{
    "title": "My First Post",
    "content": "Hello World"
}
Response (201 Created):
{
    "id": "post_123",
    "title": "My First Post",
    "content": "Hello World",
    "created_at": "2024-01-12T10:00:00Z"
}
```
- Create Comment
```
POST https://api.example.com/comments
Request:
{
    "post_id": "post_123",
    "text": "Great post!"
}
Response (201 Created):
{
    "id": "comment_456",
    "text": "Great post!",
    "post_id": "post_123"
}
```
- Login
```
POST https://api.example.com/auth/login
Request:
{
    "username": "john_doe",
    "password": "secret123"
}
Response (200 OK):
{
    "token": "eyJhbGciOiJIUzI1NiIs...",
    "user_id": "user_123"
}
```
### 3 PUT API with json request body, please also paste the response here

- Update User Profile
```
PUT https://api.example.com/users/123
Request:
{
    "name": "John Smith",
    "email": "john.smith@example.com"
}
Response (200 OK):
{
    "id": "123",
    "name": "John Smith",
    "email": "john.smith@example.com",
    "updated_at": "2024-01-12T11:00:00Z"
}
```

- Update Post
```
PUT https://api.example.com/posts/456
Request:
{
    "title": "Updated Title",
    "content": "Updated content"
}
Response (200 OK):
{
    "id": "456",
    "title": "Updated Title",
    "content": "Updated content",
    "updated_at": "2024-01-12T12:00:00Z"
}
```

- Update Order Status
```
PUT https://api.example.com/orders/789
Request:
{
    "status": "shipped",
    "tracking_number": "1Z999AA1234567890"
}
Response (200 OK):
{
    "order_id": "789",
    "status": "shipped",
    "tracking_number": "1Z999AA1234567890"
}
```
### 2 DELETE API
- Delete User
```
DELETE https://api.example.com/users/123
Response (204 No Content)
```

- Delete Post
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
    "error": "Invalid or missing authentication token"
}
```

- 403 Forbidden
```
{
    "error": "You don't have permission to access this resource"
}
```

- 404 Not Found
```
{
    "error": "Resource not found",
    "message": "The requested user with ID 123 does not exist"
}
```

- 400 Bad Request
```
{
    "error": "Invalid request",
    "message": "Email format is invalid"
}
```

- 500 Internal Server Error
```
{
    "error": "Internal server error",
    "message": "An unexpected error occurred"
}
```