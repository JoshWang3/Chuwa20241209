# HW6 - Database
## 1. GET
### 1. GET https://www.google.com
- Response Type: text/html
- Response:
```
<!doctype html>
<html itemscope="" itemtype="http://schema.org/WebPage" lang="zh-TW">
    <head>
        <meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
        <meta content="/images/branding/googleg/1x/googleg_standard_color_128dp.png" itemprop="image">
        <title>Google</title>
        ...
    </head>
    <body>
        ...
    </body>
</html>
```

### 2. GET https://httpbin.org/uuid
- Response Type: text/plain
- Response:
```
{
    "uuid": "92aec532-1e8f-400a-995a-0f308f291bc5"
}
```
### 3. GET https://jsonplaceholder.typicode.com/posts
- Response Type: application/json
- Response:
```
[
    {
        "userId": 1,
        "id": 1,
        "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
        "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
    },
    {
        "userId": 1,
        "id": 2,
        "title": "qui est esse",
        "body": "est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla"
    },
    ...
]
```
### 4. GET https://httpbin.org/bytes/10
- Response Type: application/octet-stream
- Response:
```
Random binary string of 10 bytes. ���m��!ԍ�
```
### 5. GET https://httpbin.org/image/png
- Response Type: image/png
- Response:
A pig face image.



## 2. POST
### 1. POST https://reqres.in/api/users
- Request body:
```
{
    "name": "A",
    "birthplace": "A land"
}
```
- Response:
```
{
    "name": "A",
    "birthplace": "A land",
    "id": "472",
    "createdAt": "2025-01-10T17:56:43.073Z"
}
```

### 2. POST https://httpbin.org/post
- Request body:
```
{
    "id": "abcde",
    "password": "12345"
}
```
- Response:
```
{
    "args": {},
    "data": "{\n    \"id\": \"abcde\",\n    \"password\": \"12345\"\n}",
    "files": {},
    "form": {},
    "headers": {
        "Accept": "*/*",
        "Accept-Encoding": "gzip, deflate, br",
        "Content-Length": "46",
        "Content-Type": "application/json",
        "Host": "httpbin.org",
        "Postman-Token": "e23e4b24-710f-4301-b9dc-fc612f380473",
        "User-Agent": "PostmanRuntime/7.43.0",
        "X-Amzn-Trace-Id": "Root=1-67815fba-6fb6af4f17aefb9e229a9c8c"
    },
    "json": {
        "id": "abcde",
        "password": "12345"
    },
    "origin": "111.241.2.40",
    "url": "https://httpbin.org/post"
}
```
### 3. POST https://httpbin.org/post

- Request body:
```
{
    "email": "eve.holt@reqres.in",
    "password": "abababa"
}
```
- Response:
```
{
    "token": "QpwL5tke4Pnpja7X4"
}
```
### 4. POST https://jsonplaceholder.typicode.com/posts
- Request body:
```
{
    "time": "2021",
    "word": "new post"
}
```
- Response:
```
{
    "time": "2021",
    "word": "new post",
    "id": 101
}
```
### 5. POST https://fakerestapi.azurewebsites.net/api/v1/Books
- Request body:
```
{
    "name": "test",
    "title": "1111",
    "age": "22",
    "pageCount": 500
}
```
- Response:
```
{
    "id": 0,
    "title": "1111",
    "description": null,
    "pageCount": 500,
    "excerpt": null,
    "publishDate": "0001-01-01T00:00:00"
}
```

## 3. PUT
### 1. PUT https://reqres.in/api/users/2
- Request Body:
```
{
    "name": "putting",
    "phone": "1111-111-111",
    "age": "82",
    "addr": "vegan street"
}
```
- Response:
```
{
    "name": "putting",
    "phone": "1111-111-111",
    "age": "82",
    "addr": "vegan street",
    "updatedAt": "2025-01-10T18:08:05.595Z"
}
```

### 2. PUT https://jsonplaceholder.typicode.com/posts/2
- Request Body:
```
{
    "height": 5,
    "task": "trim",
    "time": "1882",
    "addr": "meat street"
}
```
- Response:
```
{
    "height": 5,
    "task": "trim",
    "time": "1882",
    "addr": "meat street",
    "id": 2
}
```
### 3. PUT https://fakestoreapi.com/products/4
- Request Body:
```
{
    "height": 5,
    "task": "trim",
    "price": 99.99,
    "addr": "meat street"
}
```
- Response:
```
{
    "id": 4,
    "price": 99.99
}
```

## 4. DELETE
### 1. DELETE https://jsonplaceholder.typicode.com/posts/3
- Response Type: empty {}, status:200
- Response:
```
{}
```

### 2. DELETE https://reqres.in/api/users/2
- Response Type: status:204 no content
- Response:
```
{}
```

## 5.

400 Bad Request
POST https://fakerestapi.azurewebsites.net/api/v1/Books
Body:
```
{
    "id": "no_such_id",
    "title": "Title",
    "description": "Description of the book",
    "pageCount": "It's a string",
    "publishDate": "Noooooo"
}
```

Response:
```
{
    "type": "https://tools.ietf.org/html/rfc7231#section-6.5.1",
    "title": "One or more validation errors occurred.",
    "status": 400,
    "traceId": "00-367ce5ddf658cc4a9d58a1b7846d2225-3d16802b99517647-00",
    "errors": {
        "$.id": [
            "The JSON value could not be converted to System.Int32. Path: $.id | LineNumber: 1 | BytePositionInLine: 22."
        ]
    }
}
```

401 Unauthorized
GET https://api.spotify.com/v1/me/player/play
```
{
    "error": {
        "status": 401,
        "message": "No token provided"
    }
}
```

403 Forbidden
GET https://httpbin.org/status/403
Empty response

404 not found
GET https://jsonplaceholder.typicode.com/nonexistent
```
{
    "error": "Not Found"
}
```

500 Internal Server Error
POST https://httpbin.org/status/500
Empty response