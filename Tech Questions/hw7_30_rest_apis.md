## Postman practice
## Practice with below examples (You can find any Open APIs on the internet):

## 5 GET APIs with different response type
    1. https://dog.ceo/api/breeds/image/random
        {
            "message": "https://images.dog.ceo/breeds/entlebucher/n02108000_1274.jpg",
            "status": "success"
        }
    2. https://covid-19-data.p.rapidapi.com/country/code
        {
            "message": "You are not subscribed to this API."
        }
    3. https://bible-api.com/約翰福音+3:16?translation=cuv
        {
            "reference": "約翰福音 3:16",
            "verses": [
                {
                    "book_id": "JHN",
                    "book_name": "約翰福音",
                    "chapter": 3,
                    "verse": 16,
                    "text": "神愛世人，甚至將他的獨生子賜給他們，叫一切信他的，不至滅亡，反得永生。"
                }
            ],
            "text": "神愛世人，甚至將他的獨生子賜給他們，叫一切信他的，不至滅亡，反得永生。",
            "translation_id": "cuv",
            "translation_name": "Chinese Union Version",
            "translation_note": "Public Domain"
        }
    4. https://api.neso.energy/api/3/action/datapackage_show?id=14-days-ahead-wind-forecasts
        {
            "help": "https://api.neso.energy/api/3/action/help_show?name=datapackage_show",
            "success": true,
            "result": {
                "description": "The dataset contains national and BMU-Level 0-14 day ahead wind forecasts for all the windfarms which are used to produce NESO's national day ahead incentive wind forecasts available [here](https://www.neso.energy/data-portal/day-ahead-wind-forecast). The forecasts are based on evaluated Operational Capacity, which is a deterministic value based on recent actual production levels of that BMU, captured from SCADA telemetry (Operational Metering).\r\n",
                "contributors": [
                    {
                        "role": "author",
                        "email": "",
                        "title": "National Energy System Operator"
                    }
                ],
                "relationships_as_object": [],
                "private": false,
                "licenses": [
                    {
                        "path": "https://www.neso.energy/data-portal/ngeso-open-licence",
                        "name": "ESO",
                        "title": "NESO Open Data Licence"
                    }
                ],
                "groups": [],
                "organization": {
                    "description": "Forecast volumes and cost for reserve margin, wind generation, and generation by fuel type.",
                    "created": "2019-10-31T14:05:28.005545",
                    "title": "Generation",
                    "name": "generation",
                    "is_organization": true,
                    "state": "active",
                    "image_url": "2024-09-30-082745.732066Generation.svg",
                    "revision_id": "33d0b8f7-c74b-4230-bc54-ff8d37dfbdd4",
                    "type": "organization",
                    "id": "b4167cc5-1a14-4aa3-8fa2-9901fa66b06c",
                    "approval_status": "approved"
                },
                "keywords": [
                    "BMU",
                    "Forecast",
                    "Medium Term Forecast",
                    "National",
                    "Wind"
                ],
                "id": "2f134a4e-92e5-43b8-96c3-0dd7d92fcc52",
                "metadata_created": "2021-02-22T16:40:58.358016",
                "name": "14-days-ahead-wind-forecasts",
                "metadata_modified": "2025-01-09T17:29:10.009143",
                "homepage": "",
                "owner_org": "b4167cc5-1a14-4aa3-8fa2-9901fa66b06c",
                "relationships_as_subject": [],
                "descriptionHtml": "",
                "version": "",
                "title": "14 Days Ahead Wind Forecasts",
                "Update Frequency": "8 times/day",
                "creator_user_id": "a5f13177-b398-4489-9e34-0447dc6a2dab",
                "revision_id": "0c30e4a7-7905-40d9-9d1a-ab578f697e08",
                "type": "dataset",
                "resources": [
                    {
                        "hash": "",
                        "description": "This resource contains the national 0-14 day ahead wind forecasts for all the windfarms which are used to produce NESO's national day ahead incentive wind forecasts. This is not a complete list of BMU's within NESO systems and excludes licence-exempt windfarms.",
                        "mediatype": "text/csv",
                        "package_id": "2f134a4e-92e5-43b8-96c3-0dd7d92fcc52",
                        "url_type": "upload",
                        "position": 0,
                        "path": "https://api.neso.energy/dataset/2f134a4e-92e5-43b8-96c3-0dd7d92fcc52/resource/93c3048e-1dab-4057-a2a9-417540583929/download/14da_wind_forecast.csv",
                        "datastore_active": true,
                        "id": "93c3048e-1dab-4057-a2a9-417540583929",
                        "name": "14_days_ahead_wind_forecast",
                        "metadata_modified": "2025-01-09T17:28:49.850607",
                        "created": "2021-02-22T16:41:43.488725",
                        "format": "CSV",
                        "descriptionHtml": "<p>This resource contains the national 0-14 day ahead wind forecasts for all the windfarms which are used to produce NESO's national day ahead incentive wind forecasts. This is not a complete list of BMU's within NESO systems and excludes licence-exempt windfarms.</p>",
                        "state": "active",
                        "last_modified": "2025-01-09T17:28:50.553793",
                        "title": "14 Days Ahead Wind Forecast",
                        "revision_id": "41cf849b-3cac-4ffc-8de9-a729a23ca265"
                    },
                    {
                        "hash": "",
                        "description": "This resource contains the BMU-level 0-14 day ahead wind forecasts for all the windfarms which are used to produce NESO's national 14 day ahead wind forecast. This is not a complete list of BMU's within NESO systems and excludes licence-exempt windfarms.\r\n\r\nThe regions used in this resource are defined using the ITL 1 regions for England alongside the DNO Licence areas for Wales and Scotland extended to their national borders. Offshore wind regions use the IHO Sea Areas split by which land area their connection to the mainland is in.",
                        "mediatype": "text/csv",
                        "package_id": "2f134a4e-92e5-43b8-96c3-0dd7d92fcc52",
                        "url_type": "upload",
                        "position": 1,
                        "path": "https://api.neso.energy/dataset/2f134a4e-92e5-43b8-96c3-0dd7d92fcc52/resource/342aae25-d3a6-436c-b168-db8b247ccb83/download/14da_windunit_forecast_20250109.csv",
                        "datastore_active": true,
                        "id": "342aae25-d3a6-436c-b168-db8b247ccb83",
                        "name": "14_day_ahead_wind_bmu_forecast",
                        "metadata_modified": "2025-01-09T17:29:09.400119",
                        "created": "2023-11-28T10:48:49.979835",
                        "format": "CSV",
                        "descriptionHtml": "<p>This resource contains the BMU-level 0-14 day ahead wind forecasts for all the windfarms which are used to produce NESO's national 14 day ahead wind forecast. This is not a complete list of BMU's within NESO systems and excludes licence-exempt windfarms.</p>\n<p>The regions used in this resource are defined using the ITL 1 regions for England alongside the DNO Licence areas for Wales and Scotland extended to their national borders. Offshore wind regions use the IHO Sea Areas split by which land area their connection to the mainland is in.</p>",
                        "state": "active",
                        "last_modified": "2025-01-09T17:29:09.940985",
                        "title": "14 Day Ahead Wind BMU Forecast",
                        "revision_id": "8d1f3c64-94d3-453d-9a52-5ef672cf5bd9"
                    }
                ]
            }
        }
    5. https://imdb236.p.rapidapi.com/imdb/search?type=movie&genre=Drama&sortField=id&sortOrder=ASC
        {
        "rows": 25,
        "numFound": 253066,
        "results": [
            {
                "id": "tt21377368",
                "primaryTitle": "Vera",
                "originalTitle": "Vera",
                "type": "movie",
                "genres": [
                    "Drama"
                ],
                "averageRating": 6.8,
                "numVotes": 413,
                "startYear": 2022,
                "endYear": null,
                "isAdult": false
            },
            {
                "id": "tt0473065",
                "primaryTitle": "Nordstadt",
                "originalTitle": "Nordstadt",
                "type": "movie",
                "genres": [
                    "Drama"
                ],
                "averageRating": 5,
                "numVotes": 49,
                "startYear": 2005,
                "endYear": null,
                "isAdult": false
            },
            {
                "id": "tt3508198",
                "primaryTitle": "Vasundhara",
                "originalTitle": "Vasundhara",
                "type": "movie",
                "genres": [
                    "Drama"
                ],
                "averageRating": null,
                "numVotes": null,
                "startYear": 1988,
                "endYear": null,
                "isAdult": false
            },
            {
                "id": "tt0066420",
                "primaryTitle": "Sudden Terror",
                "originalTitle": "Eyewitness",
                "type": "movie",
                "genres": [
                    "Crime",
                    "Drama",
                    "Thriller"
                ],
                "averageRating": 6.1,
                "numVotes": 798,
                "startYear": 1970,
                "endYear": null,
                "isAdult": false
            },
        "nextCursorMark": "AoE/AWZmZmEyMTM4NzVkY2IwYWIyNGY4YjYwNWM1MDU1YmM1"
    }
## 5 Post API with json request body, please also paste the response here
    1. http://postman-echo.com/post {
                                        "username": "{{username}}",
                                        "name": "{{name}}",
                                        "role": "{{role}}"
                                    }
        {
            "args": {},
            "data": {
                "username": "flash",
                "name": "Barry Allen",
                "role": "Superhero"
            },
            "files": {},
            "form": {},
            "headers": {
                "host": "postman-echo.com",
                "x-request-start": "t1736445931.985",
                "connection": "close",
                "content-length": "79",
                "x-forwarded-proto": "http",
                "x-forwarded-port": "80",
                "x-amzn-trace-id": "Root=1-67800feb-2b4faf1144a1430b38f331d1",
                "content-type": "application/json",
                "user-agent": "PostmanRuntime/7.43.0",
                "accept": "*/*",
                "postman-token": "9f82b088-8026-4332-b01d-b74c0ff99291",
                "accept-encoding": "gzip, deflate, br"
            },
            "json": {
                "username": "flash",
                "name": "Barry Allen",
                "role": "Superhero"
            },
            "url": "http://postman-echo.com/post"
        }
    2. https://postman-echo.com/post {
                                        "message": "{{results}}"
                                    }
        {
            "args": {},
            "data": "{\n    \"message\": \"[{\"success\":true,\"username\":\"flash\",\"responseAttr\":{\"username\":\"flash\",\"name\":\"Barry Allen\",\"role\":\"Superhero\"},\"responseCode\":200}]\"\n}",
            "files": {},
            "form": {},
            "headers": {
                "host": "postman-echo.com",
                "x-request-start": "t1736446003.392",
                "connection": "close",
                "content-length": "153",
                "x-forwarded-proto": "https",
                "x-forwarded-port": "443",
                "x-amzn-trace-id": "Root=1-67801033-1e84c90c02f792334e6f8a37",
                "content-type": "application/json",
                "user-agent": "PostmanRuntime/7.43.0",
                "accept": "*/*",
                "postman-token": "39823586-7b54-4ef8-b5e6-e8f96af1611e",
                "accept-encoding": "gzip, deflate, br",
                "cookie": "sails.sid=s%3A-o1wvIv71dYQe9CTB2wLpAUyyNx3NIzQ.0nmd%2B6Nc0bgJuSdiwSehL2M0v59NM4MvMSyQ%2F%2BQlPzw"
            },
            "json": null,
            "url": "https://postman-echo.com/post"
        }
    3. https://postman-echo.com/post {
                                            "message": "{{results}}"
                                        }
        {
            "args": {},
            "data": "{\n    \"message\": \"[{\"success\":true,\"username\":\"flash\",\"responseAttr\":{\"username\":\"flash\",\"name\":\"Barry Allen\",\"role\":\"Superhero\"},\"responseCode\":200}]\"\n}",
            "files": {},
            "form": {},
            "headers": {
                "host": "postman-echo.com",
                "x-request-start": "t1736446080.614",
                "connection": "close",
                "content-length": "153",
                "x-forwarded-proto": "https",
                "x-forwarded-port": "443",
                "x-amzn-trace-id": "Root=1-67801080-4729260f3a1f7489752e471c",
                "content-type": "application/json",
                "user-agent": "PostmanRuntime/7.43.0",
                "accept": "*/*",
                "postman-token": "bbb6d792-eb93-4ed4-9fbb-b11b3ddcd30f",
                "accept-encoding": "gzip, deflate, br",
                "cookie": "sails.sid=s%3ASMRg41cKn9am0AU0zFg2WqhHDnkM3SfG.HsfnUPLlHDqYODRcumnyBwaFCQroHIujBzNOiBtMdVQ"
            },
            "json": null,
            "url": "https://postman-echo.com/post"
        }
    4. https://{{tenant}}.api.{{domain}}.com/beta {
                                                        "attributes": {
                                                        "sourceId": "34bfcbe116c9407464af37acbaf7a4dc",
                                                        "city": "Austin",
                                                        "displayName": "John Doe",
                                                        "userName": "jdoe",
                                                        "sAMAccountName": "jDoe",
                                                        "mail": "john.doe@sailpoint.com"
                                                        }
                                                    }
        
    5. https://postman-rest-api-learner.glitch.me/info {
                                                        "name": "Eric"
                                                    }
        {
            "message": "You made a POST request with the following data!",
            "data": {
                "name": "Eric"
            }
        }
## 3 PUT API with json request body, please also paste the response here
    1. https://postman-rest-api-learner.glitch.me/info?id=1 {
                                                                "name": "Eric"
                                                            }
        {
            "message": "You made a PUT request to update id=1 with the following data!",
            "data": {
                "name": "Eric"
            }
        }
    2. /v1/users/:userId {
                            "name": "John Doe",
                            "state": "deactivated",
                            "isAdmin": false,
                            "policy": "mollit dolor ea",
                            "roles": [
                            1,
                            3
                            ],
                            "applicationNotificationSubscriptions": {}
                        }
        {
            "accountId": 3886,
            "created": "2020-06-10T09:05:27.993483Z",
            "email": "john.doe@example.com",
            "id": 6,
            "inviteToken": "Gy9b8w1irmQtEPo5RmbMmSPheL5h4",
            "modified": "2021-09-12T10:12:42Z",
            "name": "John Doe",
            "policy": {
            "Role": 127,
            "Applications": null
            },
            "state": "invited",
            "isAdmin": false,
            "roles": [
            71
            ],
            "authMethod": "basic_auth",
            "applicationNotificationSubscriptions": {},
            "lastSignedIn": "2021-09-12T10:12:42Z",
            "lastAccessed": "2021-09-12T10:14:42Z",
            "latestFeedTimestamp": "2020-06-01T00:00:00Z",
            "additionalAttributes": {}
        }
    3. {{baseUrl}}/v1/provisioning/scim/Users/:userId {
                                                        "userName": "john.doe@example.com",
                                                        "active": true,
                                                        "displayName": "John Doe",
                                                        "name": {
                                                            "formatted": "Mr. John J Doe"
                                                            }
                                                        }
        {
            "id": "ipsum ex id aliquip",
            "userName": "john.doe@example.com",
            "active": true,
            "displayName": "John Doe",
            "name": {
                "formatted": "Mr. John J Doe"
                }
        }
## 2 DELETE API
    1. https://postman-rest-api-learner.glitch.me/info?id=1
        {
            "message": "You made a DELETE request to delete id=1!"
        }
    2. {{baseUrl}}/v1/applications/:applicationId/campaigns/:campaignId/achievements/:achievementId 
        {
            "message": "ullamco",
            "errors": [
            {
            "source": {
            "pointer": "qui ve",
            "parameter": "esse officia aliqua Ut",
            "line": "sed pariatur exercitation",
            "resource": "esse culpa incididunt"
            },
            "title": "eu consequat",
            "details": "Lorem reprehenderit cillum nisi"
            },
            {
            "source": {
            "pointer": "laborum aute nostrud",
            "parameter": "cupidatat nisi cillum",
            "line": "dolore non proident amet incididunt",
            "resource": "Ut sit"
            },
            "title": "irure fugiat dolor in nulla",
            "details": "id occaec"
            }
            ],
            "StatusCode": 77975783
        }
## Each example with 404, 401,500 and any http status codes you know
    1. 401 Unauthorized: https://covid-19-data.p.rapidapi.com/country/code 
    2. 403 Forbidden: 
    3. 404 Not Found: https://0x.org/api   
    4. 429 Too Many Request: https://covid-19-data.p.rapidapi.com/country/code 
    5. 500 Internal Server Error: 
    6. 503(service unavailable): https://quote-garden.onrender.com/api/v3/quotes
    7. 523 Unreachable: https://www.cryptonator.com/api/