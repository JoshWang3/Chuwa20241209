## GET APIs with different response type
```
https://fakerapi.it/api/v2/creditCards?_quantity=1
{
    "status": "OK",
    "code": 200,
    "locale": "en_US",
    "seed": null,
    "total": 1,
    "data": [
        {
            "type": "MasterCard",
            "number": "5554441954391749",
            "expiration": "10/25",
            "owner": "Lela Barrows"
        }
    ]
}

https://fakerapi.it/api/v2/books?_quantity=1
{
    "status": "OK",
    "code": 200,
    "locale": "en_US",
    "seed": null,
    "total": 1,
    "data": [
        {
            "id": 1,
            "title": "Queen was in the.",
            "author": "German Bergstrom",
            "genre": "Sed",
            "description": "I chose,' the Duchess was sitting on a little girl or a watch to take MORE than nothing.' 'Nobody asked YOUR opinion,' said Alice. 'Well, then,' the Gryphon went on in the middle, being held up by a.",
            "isbn": "9781130719581",
            "image": "http://placeimg.com/480/640/any",
            "published": "1998-08-01",
            "publisher": "Et Saepe"
        }
    ]
}

https://fakerapi.it/api/v2/places?_quantity=1
{
    "status": "OK",
    "code": 200,
    "locale": "en_US",
    "seed": null,
    "total": 1,
    "data": [
        {
            "latitude": 54.930006,
            "longitude": -78.265979
        }
    ]
}

https://fakerapi.it/api/v2/address123
{
    "message": "Resource not found"
}
404 Not Found

https://fakerapi.it/api/{version}/companies?_seed=12456
{
    "message": "Version {version} not supported"
}
400 Bad Request
```
## Post API with json request body
```
https://jsonplaceholder.typicode.com/posts
{
  "title": "foo",
  "body": "bar",
  "userId": 1
}
201 Created
{
    "title": "foo",
    "body": "bar",
    "userId": 1,
    "id": 101
}

https://httpbin.org/post
{
  "name": "user1",
  "gender": "M"
}
200 OK
{
    "args": {},
    "data": "{\r\n  \"name\": \"user1\",\r\n  \"gender\": \"M\"\r\n}",
    "files": {},
    "form": {},
    "headers": {
        "Accept": "*/*",
        "Accept-Encoding": "gzip, deflate, br",
        "Cache-Control": "no-cache",
        "Content-Length": "41",
        "Content-Type": "application/json",
        "Host": "httpbin.org",
        "Postman-Token": "44ed4401-9724-46be-ba94-89c6626e14ab",
        "User-Agent": "PostmanRuntime/7.43.0",
        "X-Amzn-Trace-Id": "Root=1-67816dff-44fc416b70ec50c82f43f699"
    },
    "json": {
        "gender": "M",
        "name": "user1"
    },
    "origin": "24.17.113.109",
    "url": "https://httpbin.org/post"
}

https://www.uuidtools.com/api/generate/v4
405 METHOD NOT ALLOWED

https://dummyjson.com/posts/add
400 Bad Request
{
    "message": "User id is required"
}

https://dummyjson.com/posts/add
{
    "title": "lol",
    "userId": 5
}
201 Created
{
    "id": 252,
    "title": "lol",
    "userId": 5
}
```
## PUT API with json request body
```
https://jsonplaceholder.typicode.com/posts/123
{
  "title": "test999",
  "body": "testbody",
  "userId": 12
}
500 Internal Server Error
TypeError: Cannot read properties of undefined (reading 'id')

https://jsonplaceholder.typicode.com/posts/1
{
  "title": "test999",
  "body": "testbody"
}
200 OK
{
    "title": "test999",
    "body": "testbody",
    "id": 1
}

https://dummyjson.com/posts/1
{
    "title": "lol",
    "userId": 5
}
200 OK
{
    "id": 1,
    "title": "lol",
    "body": "His mother had always taught him not to ever think of himself as better than others. He'd tried to live by this motto. He never looked down on those who were less fortunate or who had less money than him. But the stupidity of the group of people he was talking to made him change his mind.",
    "userId": 5,
    "tags": [
        "history",
        "american",
        "crime"
    ],
    "reactions": {
        "likes": 192,
        "dislikes": 25
    }
}
```
## DELETE API
```
https://jsonplaceholder.typicode.com/posts/2
200 OK
{}

https://dummyjson.com/posts/2
200 OK
{
    "id": 2,
    "title": "He was an expert but not in a discipline",
    "body": "He was an expert but not in a discipline that anyone could fully appreciate. He knew how to hold the cone just right so that the soft server ice-cream fell into it at the precise angle to form a perfect cone each and every time. It had taken years to perfect and he could now do it without even putting any thought behind it.",
    "tags": [
        "french",
        "fiction",
        "english"
    ],
    "reactions": {
        "likes": 859,
        "dislikes": 32
    },
    "views": 4884,
    "userId": 91,
    "isDeleted": true,
    "deletedOn": "2025-01-10T19:07:39.287Z"
}
```
