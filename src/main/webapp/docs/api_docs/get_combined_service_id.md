# GET /api/combined_service/combined_service/

## Description
Return data entry from the database with specified id

## Param
* `id` - id of entry in the database we want to return 
    * Example: `api/combined_service/data?zipcode=53714&location=madison&radius=5`

## Success Response:
    * **Status Code:** 200
    * **Content:**

```json
{
    "id": 2,
    "zipcode": "53714",
    "radius": 5.0,
    "weatherAndTrafficDetails": "{\"weather\": {\"current\": {\"temp_f\": 44.8, \"humidity\": 50, \"wind_dir\": \"NNE\", \"wind_mph\": 6, \"feelslike_f\": 41.4}, \"location\": {\"lat\": 43.1818008422852, \"lon\": -89.4532012939453, \"name\": \"Waunakee\", \"localtime\": \"2025-04-15 22:04\"}}, \"incidents\": [{\"id\": \"3944290500030770243\", \"lat\": 43.19079, \"lng\": -89.45683, \"type\": 4, \"endTime\": \"2025-04-17T00:40:56\", \"distance\": 0.08763206960845245, \"fullDesc\": \"Closed\", \"severity\": 3, \"impacting\": true, \"startTime\": \"2025-04-15T12:40:56\"}]}"
}