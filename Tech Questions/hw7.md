# Homework 7
## REST API 

### 1. 5 GET APls with different response type

1.1 Harry Potter Spells

GET https://potterapi-fedeperin.vercel.app/en/spells
Response:
[{"spell":"Accio","use":"Summoning charm","index":0},{"spell":"Glisseo","use":"Turns a staircase into a slide","index":1},{"spell":"Impervius","use":"Protects caster from a variety of substances, including water and fire","index":2},{"spell":"Wingardium Leviosa/Locomotor","use":"Levitates objects","index":3},{"spell":"Scourgify","use":"Cleans things","index":4},{"spell":"Portus","use":"Creates a portkey","index":5},{"spell":"Orchideous","use":"Grows flowers from end of wand","index":6},{"spell":"Lumos","use":"Makes wand emit light","index":7},{"spell":"Reparo","use":"Repairs broken objects","index":8},{"spell":"Reducio","use":"Shrinks objects","index":9},{"spell":"Pack","use":"Packs trunks and luggage","index":10},{"spell":"Riddikulus","use":"Transforms Boggarts into a humorous shape","index":11},{"spell":"Protego","use":"Shields caster from curses","index":12},{"spell":"Muffliato","use":"Keeps others nearby from overhearing conversations","index":13},{"spell":"Silencio/Langlock","use":"Stops someone from talking (by sticking one's tongue to the roof of his/her mouth)","index":14},{"spell":"Expelliarmus","use":"Disarming Charm","index":15},{"spell":"Oblivate","use":"Erases memories","index":16},{"spell":"Episkey","use":"Heals minor injuries","index":17},{"spell":"Tergeo","use":"Cleans off surfaces","index":18},{"spell":"Relashio","use":"Forces target to let go of whatever they're holding","index":19},{"spell":"Confundo","use":"Causes confusions and makes others easily susceptible to influence","index":20},{"spell":"Expecto Patronum","use":"Patronus Charm","index":21},{"spell":"Ferula","use":"Conjures bandages","index":22},{"spell":"Evanesco","use":"Vanishing spell","index":23},{"spell":"Alohomora","use":"Opens locks","index":24},{"spell":"Nox","use":"Turns off lumos","index":25},{"spell":"Quietus","use":"Quiets magically amplified voice","index":26},{"spell":"Incendio","use":"Creates fire","index":27},{"spell":"Homenum Revelio","use":"Reveal people nearby","index":28},{"spell":"Prior Incantato","use":"Reveals last spell cast","index":29},{"spell":"Finite Incantatem","use":"Negates the effects of many spells","index":30},{"spell":"Erecto","use":"Erects tents or other structures","index":31},{"spell":"Diffindo","use":"Cuts or rips material","index":32},{"spell":"Stupefy","use":"Stuns target","index":33},{"spell":"Repelo Muggletum","use":"Repels Muggles","index":34},{"spell":"Avada Kedavra","use":"The Killing Curse","index":35},{"spell":"Aguamenti","use":"Shoot water from wand","index":36},{"spell":"Geminio","use":"Creates temporary, worthless duplicate of any object","index":37},{"spell":"Locomotor Mortis","use":"Leg-lock curse","index":38},{"spell":"Anapneo","use":"Clears someone's airway","index":39},{"spell":"Reducto","use":"Explodes object","index":40},{"spell":"Obscuro","use":"Blindfolds target","index":41},{"spell":"Impedimenta","use":"Freezes someone advancing toward you","index":42},{"spell":"Cave Inimicum/Protego Totalum","use":"Strengthens an area's defenses","index":43},{"spell":"Meteolojinx Recanto","use":"Ends effects of weather spells","index":44},{"spell":"Specialis Revelio","use":"Reveals hidden magical properties in an object","index":45},{"spell":"Descendo","use":"Moves objects downward","index":46},{"spell":"Defodio","use":"Carves through stone and steel","index":47},{"spell":"Aparecium","use":"Make invisible ink appear","index":48},{"spell":"Piertotum Locomotor","use":"Animates statues","index":49},{"spell":"Imperio","use":"Makes target obey every command","index":50},{"spell":"Fidelius Charm","use":"binds a secret to the soul of a Secret-Keeper","index":51},{"spell":"Avis/Oppugno","use":"Shoots flock of birds from wand","index":52},{"spell":"Expulso","use":"Explodes objects","index":53},{"spell":"Legilimens","use":"Reveals memories and thoughts of target","index":54},{"spell":"Duro","use":"Hardens objects","index":55},{"spell":"Sonorus","use":"Amplifies one's voice","index":56},{"spell":"Deprimo","use":"Creates great downward pressure","index":57},{"spell":"Levicorpus","use":"Levitates target by ankle","index":58},{"spell":"Liberacorpus","use":"Lowers target of levicorpus","index":59},{"spell":"Mobilicorpus","use":"Moves bodies","index":60},{"spell":"Confringo","use":"Explodes objects into flames","index":61},{"spell":"Densaugeo","use":"Makes teeth grow quickly","index":62},{"spell":"Incarcarous","use":"Ties someone up with ropes","index":63},{"spell":"Deletrius","use":"Dismisses the effects of Prior Incantato","index":64},{"spell":"Rictusempra","use":"Tickling Charm","index":65},{"spell":"Petrificus Totalus","use":"Renders target completely immobile","index":66},{"spell":"Fiendfyre Curse","use":"Makes cursed fire","index":67},{"spell":"Tarantallegra","use":"Forces target to dance","index":68},{"spell":"Morsmordre","use":"Conjures the Dark Mark","index":69},{"spell":"Sectumsempra","use":"Causes severe lacerations","index":70},{"spell":"Crucio","use":"Causes immense pain","index":71}]
Status:
200: OK.
404: Not found.

1.2 Weather Info

GET https://api.open-meteo.com/v1/forecast?latitude=35&longitude=139&current_weather=true
Response:
{"latitude":35.0,"longitude":139.0,"generationtime_ms":0.051856040954589844,"utc_offset_seconds":0,"timezone":"GMT","timezone_abbreviation":"GMT","elevation":234.0,"current_weather_units":{"time":"iso8601","interval":"seconds","temperature":"°C","windspeed":"km/h","winddirection":"°","is_day":"","weathercode":"wmo code"},"current_weather":{"time":"2025-01-11T00:15","interval":900,"temperature":3.5,"windspeed":3.3,"winddirection":311,"is_day":1,"weathercode":0}
}
Status:
200: Success.
404: Invalid endpoint.

1.3 Chinese Characters

GET http://ccdb.hemiola.com/characters?count
Response:
[
    {
        "count": "20902"
    }
]
Status:
200: OK.
404: Not found.

1.4 Chess Player

GET  https://api.chess.com/pub/player/erik
{"avatar":"https://images.chesscomfiles.com/uploads/v1/user/41.5434c4ff.200x200o.5b102889d835.jpeg","player_id":41,"@id":"https://api.chess.com/pub/player/erik","url":"https://www.chess.com/member/erik","name":"Erik","username":"erik","followers":7983,"country":"https://api.chess.com/pub/country/US","location":"Bay Area, CA","last_online":1736551495,"joined":1178556600,"status":"staff","is_streamer":false,"verified":false,"league":"Silver","streaming_platforms":[]}
Status:
200: OK.
404: Not found.

1.5 Bitcoin Price

GET https://api.coingecko.com/api/v3/simple/price?ids=bitcoin&vs_currencies=usd
{
    "bitcoin": {
        "usd": 94365
    }
}
Status:
200: Returns Bitcoin prices.
401: Missing API key.

### 2. 5 Post API with json request body, please also paste the response here

2.1 Add a todo 

POST https://jsonplaceholder.typicode.com/todos
Body: { "title": "Finish project", "completed": false }
Response:
{
    "title": "Finish project",
    "completed": false,
    "id": 201
}
Status:
201: Resource created.
400: Bad request.

2.2 User Login

POST https://reqres.in/api/login
Body: { "email": "user@example.com", "password": "password123" }
Response:
{
    "error": "user not found"
}
Status:
201: Resource created.
400: Bad request.

2.3 Create a User

POST https://reqres.in/api/users
Body: { "name": "Thiha", "job": "Developer" }
Response: 
{ "name": "Thiha", "job": "Developer", "id": "19", "createdAt": "2025-01-09T00:00:00.000Z" }
Status:
201: Resource created.
400: Bad request.

2.4 Submit a Feedback

POST https://example.com/api/feedback
Body: { "message": "Great API examples!", "rating": 5 }
Response:
{
    "success": 1
}
Status:
201: Resource created.
400: Bad request.

2.5 Add a book 

POST https://example.com/api/books
Body: { "title": "Effective Java", "author": "Joshua Bloch" }
Response:
{
    "success": 1
}
Status:
201: Resource created.
400: Bad request.

### 3. 3 PUT API with json request body, please also paste the response here

3.1 Update a todo

PUT https://jsonplaceholder.typicode.com/todos/1
Body: { "title": "Complete documentation", "completed": true }
Response:
Response:
{
    "title": "Complete documentation",
    "completed": true,
    "id": 201
}
Status:
201: Created.
404: Not Found.

3.2 Update Order Status

PUT https://example.com/api/orders/123
Body: { "status": "Shipped" }
Response:
{
    "success": 1
}
Status:
201: Created.
204: No Content.

3.3 Update a User Info

PUT https://reqres.in/api/users/2
Body: { "name": "Thiha", "job": "Manager" }
Response: 
Response:
{
    "success": 1
}
Status:
200: OK.
401: Unauthorized.

### 4. 2 DELETE API

4.1 Delete a todo

DELETE https://jsonplaceholder.typicode.com/todos/1
Reponse: 
{
    "success": 1
}
Status:
200: Returns an empty object.
404: Resource not found.

4.2 Delete a user

DELETE https://reqres.in/api/users/2
Reponse: 
{
    "success": true
}
Status: 
204: No content, resource deleted.
404: Resource not found.

5. Each example with 404, 401,500 and any http status codes you know