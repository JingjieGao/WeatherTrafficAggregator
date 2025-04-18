# API Documentation

## Resources

### WeatherApiService

| Property   | Description                                       | Type/Format  |
|------------|---------------------------------------------------|--------------|
| zipcode    | Unique identifier                                 | string       |

### JSON
```json
{
"zipcode": "53714"
}
```

### IncidentResource

| Property   | Description                                       | Type/Format |
|------------|---------------------------------------------------|-------------|
| location   | Name of the location. For example "Madison"       | string      |
| radius     | Get traffic information within a specified radius | double      |

### JSON
```json
{
"location": "Madison",
"radius": "5"
}
```

### CombinedService (Weather and Traffic)

| Property   | Description                                       | Type/Format |
|------------|---------------------------------------------------|---------|
| zipcode    | Unique identifier                                 | string  |
| location   | Name of the location. For example "Madison"       | string  |
| radius     | Get traffic information within a specified radius | double  |
| id         | Get data out of the database                      | int     |
| locationId | Delete a specific entry in the database           | int     |

### JSON
```json
{
"location": "Madison",
"zipcode": "53714",
"radius": "5"
}
```

## Service Endpoints

| Method | URI                                                                                              | Description                                        |
|--------|--------------------------------------------------------------------------------------------------|----------------------------------------------------|
| GET    | [/api/current/searchTerm](render-md?file=docs/api_docs/get_current_weather.md)                   | Get current weather data                           |
| GET    | [api/traffic/incidents](render-md?file=docs/api_docs/get_incidents.md)                           | Returns incidents in specified location and radius |
| GET    | [api/combined_service/data](render-md?file=docs/api_docs/getcombined_service.md)                 | Get current weather and traffic data               |
| POST   | [api/combined_service/new-location](render-md?file=docs/api_docs/post_combined_service.md)       | Post current weather and traffic data to database  |
| GET    | [api/current/combined_service/{id}](render-md?file=docs/api_docs/get_combined_service_id.md)     | Get weather and traffic report from database       |
| GET    | [api/current/combined_service/get-all](render-md?file=docs/api_docs/get_combined_service_get_all.md) | Get all entries from the database                  |
| DELETE | [api/current/{locationId}](render-md?file=docs/api_docs/delete_combined_service.md)              | Delete entry from the database                     |
