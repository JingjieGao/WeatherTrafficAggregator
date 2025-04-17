# GET /api/combined_service/data

## Description
Return current traffic incidents data in location and within a specified radius

## Param
* `zipcode` - zipcode of location
* `location` - location based on zipcode
* `Radius` - radius in mi specified by user
    * Example: `api/combined_service/data?zipcode=53714&location=madison&radius=5`

## Success Response:
    * **Status Code:** 200
    * **Content:**

```json
{
  "weather":
    {
      "current":
        {
          "feelslike_f":54.6,
          "wind_mph":6.7,
          "humidity":30,
          "wind_dir":"SE",
          "temp_f":56.1
        },
      "location":
        {
          "localtime":"2025-04-16 18:16",
          "name":"Waunakee",
          "lon":-89.4532012939453,
          "lat":43.1818008422852}
         },
      "incidents":
        "No incidents found for the specified area."
   }
}