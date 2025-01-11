### REST API

### Postman practice

### Practice with below examples (You can find any Open APIs on the internet):

##### 5 GET APIs with different response type

###### (1) https://catfact.ninja/fact

```
GET https://catfact.ninja/fact

{
  "fact": "On average, cats spend 2/3 of every day sleeping. That means a nine-year-old cat has been awake for only three years of its life.",
  "length": 129
}
```

###### (2) OpenWeatherMap API:

```
GET https://api.openweathermap.org/data/2.5/weather?q=seattle&appid=API_KEY

{
   "coord": {
      "lon": -122.3321,
      "lat": 47.6062
   },
   "weather": [
      {
         "id": 800,
         "main": "Clear",
         "description": "clear sky",
         "icon": "01d"
      }
   ],
   "base": "stations",
   "main": {
      "temp": 295.67,
      "feels_like": 295.42,
      "temp_min": 293.74,
      "temp_max": 297.26,
      "pressure": 1016,
      "humidity": 72
   },
   "visibility": 16093,
   "wind": {
      "speed": 1.79,
      "deg": 216
   },
   "clouds": {
      "all": 0
   },
   "dt": 1647481940,
   "sys": {
      "type": 1,
      "id": 4283,
      "country": "US",
      "sunrise": 1647464567,
      "sunset": 1647512492
   },
   "timezone": -28800,
   "id": 5809844,
   "name": "Seattle",
   "cod": 200
}

```


###### (3) Google Maps:

```
https://maps.googleapis.com/maps/api/geocode/json

GET https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&key=API_KEY

{
   "results" : [
      {
         "address_components" : [
            {
               "long_name" : "1600",
               "short_name" : "1600",
               "types" : [ "street_number" ]
            },
            {
               "long_name" : "Amphitheatre Parkway",
               "short_name" : "Amphitheatre Pkwy",
               "types" : [ "route" ]
            },
            {
               "long_name" : "Mountain View",
               "short_name" : "Mountain View",
               "types" : [ "locality", "political" ]
            },
            {
               "long_name" : "Santa Clara County",
               "short_name" : "Santa Clara County",
               "types" : [ "administrative_area_level_2", "political" ]
            },
            {
               "long_name" : "California",
               "short_name" : "CA",
               "types" : [ "administrative_area_level_1", "political" ]
            },
            {
               "long_name" : "United States",
               "short_name" : "US",
               "types" : [ "country", "political" ]
            },
            {
               "long_name" : "94043",
               "short_name" : "94043",
               "types" : [ "postal_code" ]
            }
         ],
         "formatted_address" : "1600 Amphitheatre Parkway, Mountain View, CA 94043, USA",
         "geometry" : {
            "location" : {
               "lat" : 37.423021,
               "lng" : -122.083739
            },
            "location_type" : "ROOFTOP",
            "viewport" : {
               "northeast" : {
                  "lat" : 37.4243709802915,
                  "lng" : -122.0823900197085
               },
               "southwest" : {
                  "lat" : 37.4216730197085,
                  "lng" : -122.0850879802915
               }
            }
         },
         "place_id" : "ChIJ2eUgeAK6j4ARbn5u_wAGqWA",
         "types" : [ "street_address" ]
      }
   ],
   "status" : "OK"
}
```

###### (4) GitHub API

```
GET https://api.github.com/repos/JoshWang3/Chuwa20241209

{
  "id": 902210527,
  "node_id": "R_kgDONcaj3w",
  "name": "Chuwa20241209",
  "full_name": "JoshWang3/Chuwa20241209",
  "private": false,
  "owner": {
    "login": "JoshWang3",
    "id": 163091353,
    "node_id": "U_kgDOCbiTmQ",
    "avatar_url": "https://avatars.githubusercontent.com/u/163091353?v=4",
    "gravatar_id": "",
    "url": "https://api.github.com/users/JoshWang3",
    "html_url": "https://github.com/JoshWang3",
    "followers_url": "https://api.github.com/users/JoshWang3/followers",
    "following_url": "https://api.github.com/users/JoshWang3/following{/other_user}",
    "gists_url": "https://api.github.com/users/JoshWang3/gists{/gist_id}",
    "starred_url": "https://api.github.com/users/JoshWang3/starred{/owner}{/repo}",
    "subscriptions_url": "https://api.github.com/users/JoshWang3/subscriptions",
    "organizations_url": "https://api.github.com/users/JoshWang3/orgs",
    "repos_url": "https://api.github.com/users/JoshWang3/repos",
    "events_url": "https://api.github.com/users/JoshWang3/events{/privacy}",
    "received_events_url": "https://api.github.com/users/JoshWang3/received_events",
    "type": "User",
    "user_view_type": "public",
    "site_admin": false
  },
  "html_url": "https://github.com/JoshWang3/Chuwa20241209",
  "description": null,
  "fork": false,
  "url": "https://api.github.com/repos/JoshWang3/Chuwa20241209",
  "forks_url": "https://api.github.com/repos/JoshWang3/Chuwa20241209/forks",
  "keys_url": "https://api.github.com/repos/JoshWang3/Chuwa20241209/keys{/key_id}",
  "collaborators_url": "https://api.github.com/repos/JoshWang3/Chuwa20241209/collaborators{/collaborator}",
  "teams_url": "https://api.github.com/repos/JoshWang3/Chuwa20241209/teams",
  "hooks_url": "https://api.github.com/repos/JoshWang3/Chuwa20241209/hooks",
  "issue_events_url": "https://api.github.com/repos/JoshWang3/Chuwa20241209/issues/events{/number}",
  "events_url": "https://api.github.com/repos/JoshWang3/Chuwa20241209/events",
  "assignees_url": "https://api.github.com/repos/JoshWang3/Chuwa20241209/assignees{/user}",
  "branches_url": "https://api.github.com/repos/JoshWang3/Chuwa20241209/branches{/branch}",
  "tags_url": "https://api.github.com/repos/JoshWang3/Chuwa20241209/tags",
  "blobs_url": "https://api.github.com/repos/JoshWang3/Chuwa20241209/git/blobs{/sha}",
  "git_tags_url": "https://api.github.com/repos/JoshWang3/Chuwa20241209/git/tags{/sha}",
  "git_refs_url": "https://api.github.com/repos/JoshWang3/Chuwa20241209/git/refs{/sha}",
  "trees_url": "https://api.github.com/repos/JoshWang3/Chuwa20241209/git/trees{/sha}",
  "statuses_url": "https://api.github.com/repos/JoshWang3/Chuwa20241209/statuses/{sha}",
  "languages_url": "https://api.github.com/repos/JoshWang3/Chuwa20241209/languages",
  "stargazers_url": "https://api.github.com/repos/JoshWang3/Chuwa20241209/stargazers",
  "contributors_url": "https://api.github.com/repos/JoshWang3/Chuwa20241209/contributors",
  "subscribers_url": "https://api.github.com/repos/JoshWang3/Chuwa20241209/subscribers",
  "subscription_url": "https://api.github.com/repos/JoshWang3/Chuwa20241209/subscription",
  "commits_url": "https://api.github.com/repos/JoshWang3/Chuwa20241209/commits{/sha}",
  "git_commits_url": "https://api.github.com/repos/JoshWang3/Chuwa20241209/git/commits{/sha}",
  "comments_url": "https://api.github.com/repos/JoshWang3/Chuwa20241209/comments{/number}",
  "issue_comment_url": "https://api.github.com/repos/JoshWang3/Chuwa20241209/issues/comments{/number}",
  "contents_url": "https://api.github.com/repos/JoshWang3/Chuwa20241209/contents/{+path}",
  "compare_url": "https://api.github.com/repos/JoshWang3/Chuwa20241209/compare/{base}...{head}",
  "merges_url": "https://api.github.com/repos/JoshWang3/Chuwa20241209/merges",
  "archive_url": "https://api.github.com/repos/JoshWang3/Chuwa20241209/{archive_format}{/ref}",
  "downloads_url": "https://api.github.com/repos/JoshWang3/Chuwa20241209/downloads",
  "issues_url": "https://api.github.com/repos/JoshWang3/Chuwa20241209/issues{/number}",
  "pulls_url": "https://api.github.com/repos/JoshWang3/Chuwa20241209/pulls{/number}",
  "milestones_url": "https://api.github.com/repos/JoshWang3/Chuwa20241209/milestones{/number}",
  "notifications_url": "https://api.github.com/repos/JoshWang3/Chuwa20241209/notifications{?since,all,participating}",
  "labels_url": "https://api.github.com/repos/JoshWang3/Chuwa20241209/labels{/name}",
  "releases_url": "https://api.github.com/repos/JoshWang3/Chuwa20241209/releases{/id}",
  "deployments_url": "https://api.github.com/repos/JoshWang3/Chuwa20241209/deployments",
  "created_at": "2024-12-12T06:00:29Z",
  "updated_at": "2025-01-09T18:43:51Z",
  "pushed_at": "2025-01-11T03:51:46Z",
  "git_url": "git://github.com/JoshWang3/Chuwa20241209.git",
  "ssh_url": "git@github.com:JoshWang3/Chuwa20241209.git",
  "clone_url": "https://github.com/JoshWang3/Chuwa20241209.git",
  "svn_url": "https://github.com/JoshWang3/Chuwa20241209",
  "homepage": null,
  "size": 6609,
  "stargazers_count": 5,
  "watchers_count": 5,
  "language": null,
  "has_issues": true,
  "has_projects": true,
  "has_downloads": true,
  "has_wiki": true,
  "has_pages": false,
  "has_discussions": false,
  "forks_count": 0,
  "mirror_url": null,
  "archived": false,
  "disabled": false,
  "open_issues_count": 91,
  "license": null,
  "allow_forking": true,
  "is_template": false,
  "web_commit_signoff_required": false,
  "topics": [
    
  ],
  "visibility": "public",
  "forks": 0,
  "open_issues": 91,
  "watchers": 5,
  "default_branch": "main",
  "temp_clone_token": null,
  "network_count": 0,
  "subscribers_count": 2
}
```

###### (5) Random User Generator API

```
GET https://randomuser.me/api/

{
  "results": [{
    "gender": "male",
    "name": {
      "title": "Mr",
      "first": "John",
      "last": "Doe"
    },
    "location": {
      "street": {
        "number": 123,
        "name": "Main Street"
      },
      "city": "Some City",
      "state": "Some State",
      "postcode": "12345"
    },
    "email": "johndoe@example.com",
    "login": {
      "username": "johndoe123",
      "password": "password123"
    },
    "dob": {
      "date": "1985-10-10T00:00:00.000Z",
      "age": 35
    }
  }]
}
```

##### 5 Post API with json request body, please also paste the response here

###### (1)  Create a Todo Item

```
POST  https://api.todoist.com/rest/v1/tasks 

Request:
{
    "content": "Buy groceries", 
    "project_id": "228383823" 
}

Response:
{
    "id": 123456789, 
    "content": "Buy groceries", 
    "project_id": 228383823 
}

```

###### (2)  JSONPlaceholder API - Create a Post

```
POST https://jsonplaceholder.typicode.com/posts

Request:
{
  "title": "foo",
  "body": "bar",
  "userId": 1
}

Response:
{
  "id": 101,
  "title": "foo",
  "body": "bar",
  "userId": 1
}
```


###### (3) ReqRes API - Create a User

```
POST https://reqres.in/api/users

Request:
{
  "name": "John Lee",
  "job": "Software Engineer"
}

Response:
{
  "name": "John Lee",
  "job": "Software Engineer",
  "id": "1234",
  "createdAt": "2025-01-01T00:00:00.000Z"
}
```

###### (4) Trello API - Create a Board

```
POST https://api.trello.com/1/boards/

Request:
{
  "name": "My New Board",
  "defaultLabels": true,
  "defaultLists": true,
  "prefs_permissionLevel": "public",
  "prefs_voting": "disabled",
  "key": "your-api-key",
  "token": "your-oauth-token"
}

Response:
{
  "id": "5f3d16c62fdd2f1d4d9e03d8",
  "name": "My New Board",
  "url": "https://trello.com/b/5f3d16c62fdd2f1d4d9e03d8/my-new-board",
  "prefs": {
    "permissionLevel": "public",
    "voting": "disabled"
  },
  "lists": [
    {
      "id": "5f3d16c62fdd2f1d4d9e03d9",
      "name": "To Do",
      "closed": false
    }
  ],
  "labels": []
}
```

###### (5) OpenWeatherMap API,

```
Create an account to get an API key

POST https://api.openweathermap.org/data/2.5/weather

Request:

{
  "q": "Seattle",
  "appid": "API_KEY"
}

Response:

{
  "coord": {
    "lon": -122.3321,
    "lat": 47.6062
  },
  "weather": [
    {
      "id": 801,
      "main": "Clouds",
      "description": "few clouds",
      "icon": "02d"
    }
  ],
  "base": "stations",
  "main": {
    "temp": 284.32,
    "feels_like": 283.44,
    "temp_min": 283.15,
    "temp_max": 285.74,
    "pressure": 1014,
    "humidity": 92
  },
  "visibility": 10000,
  "wind": {
    "speed": 1.54,
    "deg": 128
  },
  "clouds": {
    "all": 23
  },
  "dt": 1615467863,
  "sys": {
    "type": 1,
    "id": 1412,
    "country": "US",
    "sunrise": 1615441811,
    "sunset": 1615491157
  },
  "timezone": -28800,
  "id": 5809844,
  "name": "Seattle",
  "cod": 200
}

```

##### 3 PUT API with json request body, please also paste the response here


###### (1) JSONPlaceholder API

```
PUT https://jsonplaceholder.typicode.com/posts/1

Request:
{
  "id": 1,
  "title": "Updated Title",
  "body": "This is the updated body of the post.",
  "userId": 1
}

Response:
{
  "id": 1,
  "title": "Updated Title",
  "body": "This is the updated body of the post.",
  "userId": 1
}

```

###### (2) OpenWeatherMap API (Update User Profile)

```
PUT https://api.openweathermap.org/data/2.5/user

Request:
{
  "userId": "12345",
  "email": "newemail@example.com",
  "location": "Seattle",
  "apiKey": "API_KEY"
}

Response:
{
  "status": "success",
  "message": "User profile updated successfully.",
  "userId": "12345",
  "email": "newemail@example.com",
  "location": "Seattle"
}
```

###### (3) Reqres API (Update a User's Information)

```
PUT https://reqres.in/api/users/2

Request:
{
  "name": "John Lee",
  "job": "Software Engineer"
}


Response:
{
  "name": "John Lee",
  "job": "Software Engineer",
  "updatedAt": "2025-01-10T12:12:34.000Z"
}

```

##### 2 DELETE API

###### (1) JSONPlaceholder API (Delete a Post)

```
DELETE https://jsonplaceholder.typicode.com/posts/1

Response: 
{}

```

###### (2) Reqres API (Delete a User)

```
DELETE https://reqres.in/api/users/2

Response: 
{
  "status": "success"
}
```

##### Each example with 404, 401,500 and any http status codes you know

###### (1) JSONPlaceholder API: DELETE Request - 404 Not Found

```
DELETE https://jsonplaceholder.typicode.com/posts/9999

{
  "error": "Not Found"
}
```

###### (2) OpenWeatherMap API: DELETE Request - 400 Bad Request

```
DELETE https://api.openweathermap.org/data/2.5/weather?q=London&appid=API_KEY

{
  "message": "Bad Request",
  "cod": "400"
}

```

###### (3)  Reqres API: DELETE Request - 401 Unauthorized


```
DELETE https://reqres.in/api/users/2

{
  "error": "Unauthorized"
}

```

###### (4) JSONPlaceholder API: DELETE Request - 500 Internal Server Error

```
DELETE https://jsonplaceholder.typicode.com/posts/1

{
  "error": "Internal Server Error"
}

```

###### (5) GitHub API: DELETE Request - 204 No Content

```
DELETE https://api.github.com/repos/qlLog/Hello-World

{}

```

```
404 Not Found: Resource not found
401 Unauthorized: Missing or incorrect authentication
500 Internal Server Error: 
204 No Content: Successful deletion, no content returned.
400 Bad Request: Invalid or unsupported request method 
```