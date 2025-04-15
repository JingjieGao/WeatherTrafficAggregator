# GET api/current/searchTerm

## Description
Return current weather data

## Param
* `searchTerm` - get weather data for entered zipcode
  * Example: `api/current/searchTerm?zipcode=53597`

## Success Response:
    * **Status Code:** 201
    * **Content:**

```json
{
"current":
    {
        "feelslike_f":48.3,
        "wind_mph":21.3,"humidity":38,
        "wind_dir":"NW","temp_f":53.8},
"location":
    {
        "localtime":"2025-04-15 15:35",
        "name":"Waunakee",
        "lon":-89.4532012939453,
        "lat":43.1818008422852
    }
}
