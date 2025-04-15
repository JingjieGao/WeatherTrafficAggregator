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
        "feelslike_f":45.9,
        "wind_mph":21.5,
        "humidity":38,
        "wind_dir":"NW",
        "temp_f":52
       },
       "location":
          {
            "localtime":"2025-04-15 16:05",
            "name":"Madison",
            "lon":-89.3117980957031,
            "lat":43.0976982116699}
           },
      "incidents":
        [
          {
            "severity":3,
            "distance":0.06339341205717837,
            "lng":-89.39619,
            "impacting":true,
            "startTime":"2025-03-25T21:00:08",
            "endTime":"2025-05-12T15:57:13",
            "id":"1363048257837259500",
            "type":1,
            "lat":43.00807,
            "fullDesc":
            "At Irish Ln - Road construction"},
           {
            "severity":1,
            "distance":0.39030453697949036,
            "lng":-89.29958,
            "impacting":true,
            "startTime":"2025-03-13T05:33:34",
            "endTime":"2025-05-12T15:57:38",
            "id":"2795341460180422024",
            "type":1,
            "lat":43.02273,
            "fullDesc":"Road construction. Right lane closed"},
           {
            "severity":1,
            "distance":0.054070851460534496,
            "lng":-89.31667,
            "impacting":true,
            "startTime":"2025-04-14T13:30:00",
            "endTime":"2025-04-16T18:30:00",
            "id":"295682457145597376",
            "type":1,
            "lat":43.10747,
            "fullDesc":"Road construction"},
           {
            "severity":3,
            "distance":0.5158483530142945,
            "lng":-89.38562,
            "impacting":true,
            "startTime":"2025-03-24T12:00:00",
            "endTime":"2025-09-02T00:00:00",
            "id":"1656474712172869939",
            "type":1,
            "lat":43.02178,
            "fullDesc":"At S Syene Rd - Road construction"},
           {
            "severity":1,
            "distance":0.012430080795525171,
            "lng":-89.2894,
            "impacting":true,
            "startTime":"2025-04-15T02:00:00",
            "endTime":"2025-04-16T10:00:00",
            "id":"3203589636345933583",
            "type":1,
            "lat":43.12139,
            "fullDesc":"At I-94/Exit 138 - Road construction"},
           {
            "severity":3,
            "distance":0.11311373523927906,
            "lng":-89.29148,
            "impacting":true,
            "startTime":"2025-04-14T22:36:54",
            "endTime":"2025-04-16T16:36:54",
            "id":"3541621014133018229",
            "type":4,
            "lat":43.00831,
            "fullDesc":"Closed"},
           {
            "severity":3,
            "distance":0.46115599751398384,
            "lng":-89.39403,
            "impacting":true,
            "startTime":"2025-03-24T12:00:00",
            "endTime":"2025-09-02T00:00:00",
            "id":"3294070095489508790",
            "type":1,
            "lat":43.01922,
            "fullDesc":"Between S Syene Rd and US-14/Cr-mm - Closed due to road construction"},
           {
            "severity":1,
            "distance":0.05034182722187694,
            "lng":-89.3008,
            "impacting":true,
            "startTime":"2025-03-10T05:00:00",
            "endTime":"2025-08-02T04:59:59",
            "id":"2271174166902820978",
            "type":1,
            "lat":43.01786,
            "fullDesc":"Road construction"},
           {
            "severity":3,
            "distance":0.060907395898073334,
            "lng":-89.32939,
            "impacting":true,
            "startTime":"2025-04-14T22:04:54",
            "endTime":"2025-04-16T16:04:54",
            "id":"827470311596430520",
            "type":4,"lat":43.10623,
            "fullDesc":"Closed"},
           {
            "severity":1,
            "distance":0.24860161591050342,
            "lng":-89.29892,
            "impacting":true,
            "startTime":"2025-03-11T08:02:00",
            "endTime":"2025-05-12T15:57:30",
            "id":"363574369261194541",
            "type":4,
            "lat":43.02642,
            "fullDesc":"On-ramp closed"},
           {
            "severity":1,
            "distance":0.7377252952144189,
            "lng":-89.29935,
            "impacting":true,
            "startTime":"2025-03-07T22:14:48",
            "endTime":"2025-05-12T15:57:35",
            "id":"2924522929440241440",
            "type":1,"lat":43.03,
            "fullDesc":"Road construction. Left lane closed"},
           {
            "severity":3,
            "distance":0.7327532628962088,
            "lng":-89.39564,
            "impacting":true,
            "startTime":"2025-03-25T21:00:08",
            "endTime":"2025-05-12T15:57:13",
            "id":"3085043603742466233",
            "type":1,
            "lat":43.0163,
            "fullDesc":"Between Irish Ln and McCoy Rd - Closed due to road construction"},
           {
            "severity":3,
            "distance":0.22374145431945308,
            "lng":-89.29929,
            "impacting":true,
            "startTime":"2025-04-14T06:54:50",
            "endTime":"2025-04-16T18:54:50",
            "id":"1343922187007968451",
            "type":4,
            "lat":43.02258,
            "fullDesc":"Closed"},
           {
            "severity":1,
            "distance":0.06463642013673089,
            "lng":-89.43953,
            "impacting":true,
            "startTime":"2025-04-15T20:59:30",
            "endTime":"2025-04-15T21:15:46",
            "id":"2761220958450799754",
            "type":3,"lat":43.03501,
            "fullDesc":"At Seminole Hwy/Exit 258 - Backed-up traffic with average speeds of 10 km/h. Approach with care"}
        ]
}
