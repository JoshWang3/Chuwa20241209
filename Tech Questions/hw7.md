baseUrl: https://jsonplaceholder.typicode.com

Get:
1. {{baseUrl}}/posts:

Status: 200 OK 
Response:
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
{
"userId": 1,
"id": 3,
"title": "ea molestias quasi exercitationem repellat qui ipsa sit aut",
"body": "et iusto sed quo iure\nvoluptatem occaecati omnis eligendi aut ad\nvoluptatem doloribus vel accusantium quis pariatur\nmolestiae porro eius odio et labore et velit aut"
},
{
"userId": 1,
"id": 4,
"title": "eum et est occaecati",
"body": "ullam et saepe reiciendis voluptatem adipisci\nsit amet autem assumenda provident rerum culpa\nquis hic commodi nesciunt rem tenetur doloremque ipsam iure\nquis sunt voluptatem rerum illo velit"
},
{
"userId": 1,
"id": 5,
"title": "nesciunt quas odio",
"body": "repudiandae veniam quaerat sunt sed\nalias aut fugiat sit autem sed est\nvoluptatem omnis possimus esse voluptatibus quis\nest aut tenetur dolor neque"
},
{
"userId": 1,
"id": 6,
"title": "dolorem eum magni eos aperiam quia",
"body": "ut aspernatur corporis harum nihil quis provident sequi\nmollitia nobis aliquid molestiae\nperspiciatis et ea nemo ab reprehenderit accusantium quas\nvoluptate dolores velit et doloremque molestiae"
},
{
"userId": 1,
"id": 7,
"title": "magnam facilis autem",
"body": "dolore placeat quibusdam ea quo vitae\nmagni quis enim qui quis quo nemo aut saepe\nquidem repellat excepturi ut quia\nsunt ut sequi eos ea sed quas"
},
{
"userId": 1,
"id": 8,
"title": "dolorem dolore est ipsam",
"body": "dignissimos aperiam dolorem qui eum\nfacilis quibusdam animi sint suscipit qui sint possimus cum\nquaerat magni maiores excepturi\nipsam ut commodi dolor voluptatum modi aut vitae"
},
{
"userId": 1,
"id": 9,
"title": "nesciunt iure omnis dolorem tempora et accusantium",
"body": "consectetur animi nesciunt iure dolore\nenim quia ad\nveniam autem ut quam aut nobis\net est aut quod aut provident voluptas autem voluptas"
},
{
"userId": 1,
"id": 10,
"title": "optio molestias id quia eum",
"body": "quo et expedita modi cum officia vel magni\ndoloribus qui repudiandae\nvero nisi sit\nquos veniam quod sed accusamus veritatis error"
},
{
"userId": 2,
"id": 11,
"title": "et ea vero quia laudantium autem",
"body": "delectus reiciendis molestiae occaecati non minima eveniet qui voluptatibus\naccusamus in eum beatae sit\nvel qui neque voluptates ut commodi qui incidunt\nut animi commodi"
},
...
2. {{baseUrl}}/posts/999

Status: 404 not found
Response: {}


3. {{baseUrl}}/posts/1

Status: 200 OK
Response:
{
"userId": 1,
"id": 1,
"title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
"body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
}

4. {{baseUrl}}/users

Status: 200 OK
Response:

[
{
"id": 1,
"name": "Leanne Graham",
"username": "Bret",
"email": "Sincere@april.biz",
"address": {
"street": "Kulas Light",
"suite": "Apt. 556",
"city": "Gwenborough",
"zipcode": "92998-3874",
"geo": {
"lat": "-37.3159",
"lng": "81.1496"
}
},
"phone": "1-770-736-8031 x56442",
"website": "hildegard.org",
"company": {
"name": "Romaguera-Crona",
"catchPhrase": "Multi-layered client-server neural-net",
"bs": "harness real-time e-markets"
}
},
....

5. {{baseUrl}}/posts/1/comments

Status: 200 OK
Response:
[
{
"postId": 1,
"id": 1,
"name": "id labore ex et quam laborum",
"email": "Eliseo@gardner.biz",
"body": "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium"
},
{
"postId": 1,
"id": 2,
"name": "quo vero reiciendis velit similique earum",
"email": "Jayne_Kuhic@sydney.com",
"body": "est natus enim nihil est dolore omnis voluptatem numquam\net omnis occaecati quod ullam at\nvoluptatem error expedita pariatur\nnihil sint nostrum voluptatem reiciendis et"
},
{
"postId": 1,
"id": 3,
"name": "odio adipisci rerum aut animi",
"email": "Nikita@garfield.biz",
"body": "quia molestiae reprehenderit quasi aspernatur\naut expedita occaecati aliquam eveniet laudantium\nomnis quibusdam delectus saepe quia accusamus maiores nam est\ncum et ducimus et vero voluptates excepturi deleniti ratione"
},
{
"postId": 1,
"id": 4,
"name": "alias odio sit",
"email": "Lew@alysha.tv",
"body": "non et atque\noccaecati deserunt quas accusantium unde odit nobis qui voluptatem\nquia voluptas consequuntur itaque dolor\net qui rerum deleniti ut occaecati"
},
{
"postId": 1,
"id": 5,
"name": "vero eaque aliquid doloribus et culpa",
"email": "Hayden@althea.biz",
"body": "harum non quasi et ratione\ntempore iure ex voluptates in ratione\nharum architecto fugit inventore cupiditate\nvoluptates magni quo et"
}
]


Post:
1. 
Url: {{baseUrl}}/posts 
Request Body:
{
"title": "Sample Post",
"body": "This is a sample post body",
"userId": 1
}

Status: 201 Created
Response:
{
"title": "Sample Post",
"body": "This is a sample post body",
"userId": 1,
"id": 101
}

2. 
Url: {{baseUrl}}/comments
Request Body:
{
"postId": 1,
"name": "Test Commenter",
"email": "test@example.com",
"body": "This is a test comment."
} 

Status: 201 Created
Response: 
{
"postId": 1,
"name": "Test Commenter",
"email": "test@example.com",
"body": "This is a test comment.",
"id": 501
}

3. 
Url: {{baseUrl}}/todos
Request Body:
{
"title": "Learn Postman",
"completed": false,
"userId": 1
}

Status: 201 Created
Response:
{
"title": "Learn Postman",
"completed": false,
"userId": 1,
"id": 201
}

4. 
Url: {{baseUrl}}/users
Request Body:
{
"name": "Alice Johnson",
"username": "alicej",
"email": "alice.johnson@example.com",
"phone": "123-456-7890",
"website": "alicejohnson.com"
}

Status: 201 Created
Response:
{
"name": "Alice Johnson",
"username": "alicej",
"email": "alice.johnson@example.com",
"phone": "123-456-7890",
"website": "alicejohnson.com",
"id": 11
}

5.
Url: {{baseUrl}}/albums
Request Body:
{
"userId": 1,
"title": "Travel Memories"
}

Status: 201 Created
Response:
{
"userId": 1,
"title": "Travel Memories",
"id": 101
}

Put: 
1. 
Url: {{baseUrl}}/posts/1
Request Body: 

{
"id": 1,
"title": "Updated Title",
"body": "Updated Body Content",
"userId": 1
}

Status: 200 OK
Response:
{
"id": 1,
"title": "Updated Title",
"body": "Updated Body Content",
"userId": 1
}

2. 
Url: {{baseUrl}}/todos/1
Request Body:
{
"id": 1,
"title": "Learn Advanced Postman",
"completed": true,
"userId": 1
}

Status: 200 OK
Response:
{
"id": 1,
"title": "Learn Advanced Postman",
"completed": true,
"userId": 1
}

3. 
Url: {{baseUrl}}/posts/999
Request Body:
{
"id": 999,
"title": "Updated Title",
"body": "Updated Body Content",
"userId": 999
}

Status: 500 Internal Server Error
Response:
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

Delete:
1. 
Url: {{baseUrl}}/posts/1

Status: 200 Ok
Response: {}

2. 
Url: {{baseUrl}}/invalidposts/9999

Status: 404 Not Found
Response: {}