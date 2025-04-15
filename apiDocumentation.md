# API Documentation

## Resources

### CombinedService (Weather and Traffic)

| Property    | Description                                                                    | Type/Format      |
|-------------|--------------------------------------------------------------------------------|------------------|
| zipcode     | Unique identifier                                                              | string           |
| location    | Name of the location. For example "Madison"                                    | string           |
| radius      | Get traffic information within a specified radius                              | string           |

### JSON
```json
{
"location": "Madison",
"zipcode": "53714",
"radius": "5"
}
```
## Service Endpoints

| Method | URI                                                             | Description                                        |
|--------|-----------------------------------------------------------------|----------------------------------------------------|
| GET    | [/api/current/searchTerm](docs/api_docs/get_current_weather.md) | Get current weather data                           |
| GET    | [api/traffic/incidents](docs/api_docs/get_incidents.md)         | Returns incidents in specified location and radius |
| GET    | [api/current/searchTerm](docs/api_docs/getcombined_service.md)  | Get current weather and traffic data               |
