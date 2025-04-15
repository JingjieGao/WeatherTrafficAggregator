# GET api/traffic/incidents/json

## Description
Return current traffic incidents data in location and within a specified radius

## Param
* `location` - location based on zipcode
* `Radius` - radius in mi specified by user
    * Example: `api/traffic/incidents/json?location=53597&radius=1`

## Success Response:
    * **Status Code:** 201
    * **Content:**

```json
{
    "severity":3,
    "lng":-89.45683,
    "distance":0.08763206960845245,
    "impacting":true,
    "type":4,
    "fullDesc":"Closed",
    "startTime":"2025-04-15T12:40:56",
    "id":"3944290500030770242",
    "endTime":"2025-04-16T18:40:56",
    "lat":43.19079
}
