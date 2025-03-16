# Homework 7

## GET API 1: JSON Response
- API: https://ghibliapi.vercel.app/locations
- Method: GET
- Params: None
- Response Status: 200 OK
- Response Body：
    ```
    [
    {
        "id": "11014596-71b0-4b3e-b8c0-1c4b15f28b9a",
        "name": "Irontown",
        "climate": "Continental",
        "terrain": "Mountain",
        "surface_water": "40",
        "residents": [
        "https://ghibliapi.vercel.app/people/ba924631-068e-4436-b6de-f3283fa848f0",
        "https://ghibliapi.vercel.app/people/030555b3-4c92-4fce-93fb-e70c3ae3df8b"
        ],
        "films": [
        "https://ghibliapi.vercel.app/films/0440483e-ca0e-4120-8c50-4c8cd9b965d6"
        ],
        "url": "https://ghibliapi.vercel.app/locations/11014596-71b0-4b3e-b8c0-1c4b15f28b9a"
    },

    ...

    {
        "id": "398e3e1e-9912-4eb6-91fe-a9f8b932b67d",
        "name": "St. Morwald's Home for Children",
        "climate": "Mild",
        "terrain": "City",
        "surface_water": "",
        "residents": [
        "https://ghibliapi.vercel.app/people/2d66e2eb-5a74-4721-a5b3-c556497bdb66",
        "https://ghibliapi.vercel.app/people/835f8c7c-2fc6-4f54-b545-c02ab066cd69"
        ],
        "films": [
        "https://ghibliapi.vercel.app/films/790e0028-a31c-4626-a694-86b7a8cada40"
        ],
        "url": "https://ghibliapi.vercel.app/locations/398e3e1e-9912-4eb6-91fe-a9f8b932b67d"
    }
    ]
    ```

## GET API 2: HTML Response
- API: https://www.google.com
- Method: GET
- Params: None
- Response Status: 200 OK
- Response Body：
    ```
    <!doctype html>
    <html itemscope="" itemtype="http://schema.org/WebPage" lang="en">

    <head>
        <meta
            content="Search the world's information, including webpages, images, videos and more. Google has many special features to help you find exactly what you're looking for."
            name="description">
        <meta content="noodp, " name="robots">
        <meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
        <meta content="/images/branding/googleg/1x/googleg_standard_color_128dp.png" itemprop="image">
        <title>Google</title>
        <script nonce="JaNPc373ilf0BgkJyoshMQ">
        ...
    ```

## GET API 3: Image Response
- API: https://cataas.com/cat
- Method: GET
- Params: None
- Response Status: 200 OK
- Response Body：a picture of cat
  
## GET API 4: TXT Response
- API: https://baconipsum.com/api/?type=meat-and-filler
- Method: GET
- Params: None
- Response Status: 200 OK
- Response Body：
    ```
    [
        "Bresaola filet mignon boudin qui, pariatur occaecat frankfurter short ribs chuck.  Dolore veniam culpa reprehenderit.  Dolore culpa eu meatball cillum doner ullamco non ham cupidatat incididunt turducken laboris.  Meatball sunt shoulder irure pastrami venison, burgdoggen sausage porchetta strip steak alcatra.  Tail drumstick kevin ut flank sed pork tempor shoulder.",
    ```

## GET API 5: XML Response
- API: https://www.w3schools.com/xml/note.xml
- Method: GET
- Params: None
- Response Status: 200 OK
- Response Body：
    ```
    <?xml version="1.0" encoding="UTF-8"?>
    <note>
        <to>Tove</to>
        <from>Jani</from>
        <heading>Reminder</heading>
        <body>Don't forget me this weekend!</body>
    </note>
    ```

## POST API 1
- API: https://reqres.in/api/register
- Method: POST
- Request Body:
    ```
    {
        "email": "eve.holt@reqres.in",
        "password": "pistol"
    }
    ```
- Response Status: 200 OK
- Response Body：
    ```
    {"id":4,"token":"QpwL5tke4Pnpja7X4"}
    ```

## POST API 2
- API: https://jsonplaceholder.typicode.com/posts
- Method: POST
- Request Body:
    ```
    {
    "title": "foo",
    "body": "bar",
    "userId": 1
    }
    ```
- Response Status: 200 OK
- Response Body：
    ```
    {
    "id": 101
    }
    ```

## POST API 3
- API: https://reqres.in/api/users
- Method: POST
- Request Body:
    ```
    {
    "name": "John",
    "job": "Developer"
    }
    ```
- Response Status: 200 OK
- Response Body：
    ```
    {
    "name": "John",
    "job": "Developer",
    "id": "123",
    "createdAt": "2025-01-10T12:00:00.000Z"
    }
    ```

## POST API 4
- API: https://reqres.in/api/login
- Method: POST
- Request Body:
    ```
    {
    "email": "eve.holt@reqres.in",
    "password": "cityslicka"
    }
    ```
- Response Status: 200 OK
- Response Body：
    ```
    {
    "token": "QpwL5tke4Pnpja7X4"
    }
    ```

## POST API 5
- API: https://fakestoreapi.com/carts
- Method: POST
- Request Body:
    ```
    {
    "userId": 5,
    "date": "2023-03-15",
    "products": [
        { "productId": 1, "quantity": 2 },
        { "productId": 3, "quantity": 1 }
    ]
    }
    ```
- Response Status: 200 OK
- Response Body：
    ```
    {
    "id": 6,
    "userId": 5,
    "date": "2023-03-15",
    "products": [
        { "productId": 1, "quantity": 2 },
        { "productId": 3, "quantity": 1 }
    ]
    }
    ```

## PUT API 1
- API: https://reqres.in/api/users/2
- Method: PUT
- Request Body:
    ```
    {
    "name": "Jane",
    "job": "Manager"
    }
    ```
- Response Status: 200 OK
- Response Body：
    ```
    {
    "name": "Jane",
    "job": "Manager",
    "updatedAt": "2025-01-10T12:05:00.000Z"
    }
    ```

## PUT API 2
- API: https://jsonplaceholder.typicode.com/posts/1
- Method: PUT
- Request Body:
    ```
    {
    "title": "updated title",
    "body": "updated body",
    "userId": 1
    }
    ```
- Response Status: 200 OK
- Response Body：
    ```
    {
    "id": 1,
    "title": "updated title",
    "body": "updated body",
    "userId": 1
    }
    ```

## PUT API 3
- API: https://fakestoreapi.com/carts/5
- Method: PUT
- Request Body:
    ```
    {
    "userId": 5,
    "date": "2025-01-10",
    "products": [
        { "productId": 2, "quantity": 4 }
    ]
    }
    ```
- Response Status: 200 OK
- Response Body：
    ```
    {
    "id": 5,
    "userId": 5,
    "date": "2025-01-10",
    "products": [
        { "productId": 2, "quantity": 4 }
    ]
    }
    ```

## DELETE API 1
- API: https://reqres.in/api/users/2
- Method: DELET
- Response Status: 204 No Content

## DELETE API 2
- API: https://fakestoreapi.com/carts/5
- Method: DELET
- Response Status: 200 OK

## 404
- API: https://jsonplaceholder.typicode.com/posts/99999
- Method: GET
- Params: None
- Response Status: 404 Not Found
- Response Body：
    ```
    {}
    ```

## 401
- API: https://api.openweathermap.org/data/2.5/weather?q=London
- Method: GET
- Params: None
- Response Status: 401 Unauthorized
- Response Body：
    ```
    {
        "cod": 401,
        "message": "Invalid API key. Please see https://openweathermap.org/faq#error401 for more info."
    }
    ```

## 500
- API: https://httpstat.us/500
- Method: GET
- Params: None
- Response Status: 500 Internal Server Error
- Response Body：
    ```
    500 Internal Server Error
    ```


