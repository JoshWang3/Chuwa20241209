# HW7
____
### 1. 5 GET APIs with different response type
- **GET** https://jsonplaceholder.typicode.com/posts?id=1
```
[
    {
        "userId": 1,
        "id": 1,
        "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
        "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
    }
]
```

- **GET** http://numbersapi.com/42
```
42 is the sum of the codes of the letters in the words "BIG BANG" using the encoding A=1, B=2, C=3, etc.
```

- **GET** https://catfact.ninja/fact
```
{
    "fact": "The oldest cat on record was Crème Puff from Austin, Texas, who lived from 1967 to August 6, 2005, three days after her 38th birthday. A cat typically can live up to 20 years, which is equivalent to about 96 human years.",
    "length": 220
}
```

- **GET** https://api.spacexdata.com/v4/launches/latest
```
{
    "fairings": null,
    "links": {
        "patch": {
            "small": "https://images2.imgbox.com/eb/d8/D1Yywp0w_o.png",
            "large": "https://images2.imgbox.com/33/2e/k6VE4iYl_o.png"
        },
        "reddit": {
            "campaign": null,
            "launch": "https://www.reddit.com/r/spacex/comments/xvm76j/rspacex_crew5_launchcoast_docking_discussion_and/",
            "media": null,
            "recovery": null
        },
        "flickr": {
            "small": [],
            "original": []
        },
        "presskit": null,
        "webcast": "https://youtu.be/5EwW8ZkArL4",
        "youtube_id": "5EwW8ZkArL4",
        "article": null,
        "wikipedia": "https://en.wikipedia.org/wiki/SpaceX_Crew-5"
    },
    "static_fire_date_utc": null,
    "static_fire_date_unix": null,
    "net": false,
    "window": null,
    "rocket": "5e9d0d95eda69973a809d1ec",
    "success": true,
    "failures": [],
    "details": null,
    "crew": [
        "62dd7196202306255024d13c",
        "62dd71c9202306255024d13d",
        "62dd7210202306255024d13e",
        "62dd7253202306255024d13f"
    ],
    "ships": [],
    "capsules": [
        "617c05591bad2c661a6e2909"
    ],
    "payloads": [
        "62dd73ed202306255024d145"
    ],
    "launchpad": "5e9e4502f509094188566f88",
    "flight_number": 187,
    "name": "Crew-5",
    "date_utc": "2022-10-05T16:00:00.000Z",
    "date_unix": 1664985600,
    "date_local": "2022-10-05T12:00:00-04:00",
    "date_precision": "hour",
    "upcoming": false,
    "cores": [
        {
            "core": "633d9da635a71d1d9c66797b",
            "flight": 1,
            "gridfins": true,
            "legs": true,
            "reused": false,
            "landing_attempt": true,
            "landing_success": true,
            "landing_type": "ASDS",
            "landpad": "5e9e3033383ecbb9e534e7cc"
        }
    ],
    "auto_update": true,
    "tbd": false,
    "launch_library_id": "f33d5ece-e825-4cd8-809f-1d4c72a2e0d3",
    "id": "62dd70d5202306255024d139"
}
```

- **GET** https://dog.ceo/api/breeds/image/random
```
{
    "message": "https://images.dog.ceo/breeds/hound-blood/n02088466_7607.jpg",
    "status": "success"
}
```

### 2. 5 POST APIs with json request body, please also paste the response

- **POST** https://jsonplaceholder.typicode.com/posts
```
Request Body:
{
    "title": "foo",
    "body": "bar",
    "userId": 1
}

Response:
{
    "title": "foo",
    "body": "bar",
    "userId": 1,
    "id": 101
}
```

- **POST** https://reqres.in/api/users
```
Request Body:
{
    "name": "LJJ",
    "job": "developer"
}

Response:
{
    "name": "LJJ",
    "job": "developer",
    "id": "236",
    "createdAt": "2025-01-10T23:49:25.190Z"
}
```

- **POST** https://fakestoreapi.com/products
```
Request Body:
{
  "title": "Sample Product",
  "price": 29.99,
  "description": "A great product",
  "image": "https://example.com/product.png",
  "category": "electronics"
}

Response:
{
    "id": 21,
    "title": "Sample Product",
    "price": 29.99,
    "description": "A great product",
    "image": "https://example.com/product.png",
    "category": "electronics"
}
```

-  **POST** https://restful-booker.herokuapp.com/booking
```
Request Body:
{
  "firstname": "Jim",
  "lastname": "Brown",
  "totalprice": 111,
  "depositpaid": true,
  "bookingdates": {
    "checkin": "2023-01-01",
    "checkout": "2023-01-05"
  },
  "additionalneeds": "Breakfast"
}


Response:
{
    "bookingid": 1045,
    "booking": {
        "firstname": "Jim",
        "lastname": "Brown",
        "totalprice": 111,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2023-01-01",
            "checkout": "2023-01-05"
        },
        "additionalneeds": "Breakfast"
    }
}
```

- **POST** https://petstore.swagger.io/v2/pet
```
Request Body:
{
  "id": 1,
  "category": {
    "id": 0,
    "name": "dog"
  },
  "name": "Rex",
  "photoUrls": [
    "https://example.com/rex.jpg"
  ],
  "tags": [
    {
      "id": 0,
      "name": "friendly"
    }
  ],
  "status": "available"
}

Response:
{
    "id": 1,
    "category": {
        "id": 0,
        "name": "dog"
    },
    "name": "Rex",
    "photoUrls": [
        "https://example.com/rex.jpg"
    ],
    "tags": [
        {
            "id": 0,
            "name": "friendly"
        }
    ],
    "status": "available"
}
```

### 3. 3 PUT APIs with json request body, please also paste the response

- **PUT** https://jsonplaceholder.typicode.com/posts/1
```
Request Body:
{
  "id": 1,
  "title": "updated title",
  "body": "updated body",
  "userId": 1
}

Response:
{
    "id": 1,
    "title": "updated title",
    "body": "updated body",
    "userId": 1
}
```

- **PUT** https://reqres.in/api/users/2
```
Request Body:
{
  "name": "New Name",
  "job": "New Job"
}

Response:
{
    "name": "New Name",
    "job": "New Job",
    "updatedAt": "2025-01-10T23:57:41.907Z"
}
```

- **PUT** https://fakestoreapi.com/products/1
```
Request Body:
{
  "title": "Updated Product",
  "price": 1000000,
  "description": "Updated description of the product",
  "image": "https://example.com/product.png",
  "category": "alien technology"
}

Response:
{
    "id": 1,
    "title": "Updated Product",
    "price": 1000000,
    "description": "Updated description of the product",
    "image": "https://example.com/product.png",
    "category": "alien technology"
}
```

### 4. 2 DELETE APIs
- **DELETE** https://jsonplaceholder.typicode.com/posts/1
```
{}
```

- **DELETE** https://reqres.in/api/users/2
```
{}
```

### 5. Each example with 404, 401, 500 and any http status code you know
- **GET** https://jsonplaceholder.typicode.com/posts/1000
``` 
404 Not Found
```

- **POST** https://www.uuidtools.com/api/generate/v4
```
Response:
405 Method Not Allowed
```

- **PUT** https://jsonplaceholder.typicode.com/posts/101
```
Request Body:
{
  "id": 101,
  "title": "Updated Title",
  "body": "This is an update to a non-existent post.",
  "userId": 1
}

Response:
500 Internal Server Error
TypeError: Cannot read properties of undefined (reading 'id')
at update (/app/node_modules/json-server/lib/server/router/plural.js:262:24)
at Layer.handle [as handle_request] (/app/node_modules/express/lib/router/layer.js:95:5)
at next (/app/node_modules/express/lib/router/route.js:137:13)
at next (/app/node_modules/express/lib/router/route.js:131:14)
at Route.dispatch (/app/node_modules/express/lib/router/route.js:112:3)
at Layer.handle [as handle_request] (/app/node_modules/express/lib/router/layer.js:95:5)
at /app/node_modules/express/lib/router/index.js:281:22
at param (/app/node_modules/express/lib/router/index.js:354:14)
at param (/app/node_modules/express/lib/router/index.js:365:14)
at Function.process_params (/app/node_modules/express/lib/router/index.js:410:3)
```










