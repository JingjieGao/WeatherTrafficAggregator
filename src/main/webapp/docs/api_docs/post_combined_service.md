# GET /api/combined_service/new-location

## Description
Post a new report to the database

## Param
* `zipcode` - zipcode of area
* `location` - name of the location
* `radius` - what size of area to look for traffic reports
    * Example: `api/combined_service/new-location`

## Success Response:
    * **Status Code:** 200
    * **Content:**

```json
{
    "id": 33,
    "zipcode": "54229",
    "radius": 1.0,
    "weatherAndTrafficDetails": "{\"weather\":{\"current\":{\"feelslike_f\":36.8,\"wind_mph\":11.4,\"humidity\":41,\"wind_dir\":\"SSE\",\"temp_f\":43},\"location\":{\"localtime\":\"2025-04-16 19:12\",\"name\":\"New Franken\",\"lon\":-87.8235015869141,\"lat\":44.5592002868652}},\"incidents\":\"No incidents found for the specified area.\"}"
}