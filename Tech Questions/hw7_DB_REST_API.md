

### GET APIs with different response type
```
GET https://jsonplaceholder.typicode.com/posts

Response 200
[
  {
    "userId": 1,
    "id": 1,
    "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
    "body": "quia et suscipit suscipit recusandae consequuntur expedita et cum"
  },
]

Response 404
GET https://jsonplaceholder.typicode.com/invalid-endpoint
{
  "error": "Not Found"
}

Response 200
GET https://catfact.ninja/fact
{
  "fact": "Cats have five toes on their front paws, but only four toes on their back paws.",
  "length": 74
}

Response 200
GET https://api.ipify.org
198.51.100.42

Response 200
GET https://httpbin.org/headers
{
  "headers": {
    "Accept": "*/*",
    "Host": "httpbin.org",
    "User-Agent": "curl/7.68.0"
  }
}
```

### Post API with json request body, please also paste the response here
```
POST https://jsonplaceholder.typicode.com/posts
Content-Type: application/json

{
  "title": "foo",
  "body": "bar",
  "userId": 1
}
Response (201 Created):
{
  "id": 101,
  "title": "foo",
  "body": "bar",
  "userId": 1
}


POST https://httpbin.org/post
Content-Type: application/json
{
  "name": "John",
  "age": 30
}

{
  "data": "{\"name\": \"John\", \"age\": 30}",
  "json": {
    "name": "John",
    "age": 30
  },

}

400
POST https://catfact.ninja/fact
{
  "error": "This endpoint does not support POST requests"
}

401
POST https://api.example.com/secure-endpoint
Authorization: Bearer invalid_token
{
  "message": "Invalid API key"
}

500
POST https://httpbin.org/status/500
Internal Server Error

```

### PUT API with json request body, please also paste the response here
```
PUT https://jsonplaceholder.typicode.com/posts/1
Content-Type: application/json
{
  "id": 1,
  "title": "updated title",
  "body": "updated body",
  "userId": 1
}

200
PUT https://httpbin.org/put
Content-Type: application/json
{
  "key": "value"
}
{
  "data": "{\"key\": \"value\"}",
  "json": {
    "key": "value"
  }
}

404
PUT https://jsonplaceholder.typicode.com/invalid-endpoint
{
  "error": "Not Found"
}

```

### DELETE API
```
DELETE https://jsonplaceholder.typicode.com/posts/1
DELETE https://httpbin.org/status/500
```

### Each example with 404, 401,500 and any http status codes you know
```
200:The request was successful and returned data.
400:Bad Request	Invalid request payload
401:Unauthorized
404:Not Found
500:Internal Server Error
```
