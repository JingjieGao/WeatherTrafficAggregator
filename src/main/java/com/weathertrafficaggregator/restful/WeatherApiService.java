package com.weathertrafficaggregator.restful;

import com.weathertrafficaggregator.persistence.WeatherResponseDao;
import com.weatherApi.Current;
import com.weatherApi.Location;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/current")
public class WeatherApiService {

    @GET
    @Produces("text/plain")
    @Path("/hello")
    public Response getMessage() {
        // Return a simple message
        String output = "Hello World";
        return Response.status(200).entity(output).build();
    }

    @GET
    @Produces("application/json")
    @Path("searchTerm")
    public Response getCurrentWeather(@QueryParam("zipcode") String zipcode) throws Exception {
        WeatherResponseDao responseDao = new WeatherResponseDao();
        com.weatherApi.Response weatherResponse = responseDao.searchLocation(zipcode);

        // Extract the current weather data
        Current current = weatherResponse.getCurrent();

        // Extract the location data
        Location location = weatherResponse.getLocation();

        // Prepare the simplified response
        Map<String, Object> simplifiedResponse = new HashMap<>();

        // Fields from 'current'
        Map<String, Object> currentDetails = new HashMap<>();
        currentDetails.put("feelslike_f", current.getFeelslikeF());
        currentDetails.put("temp_f", current.getTempF());
        currentDetails.put("wind_mph", current.getWindMph());
        currentDetails.put("humidity", current.getHumidity());
        currentDetails.put("wind_dir", current.getWindDir());

        // Fields from 'location'
        Map<String, Object> locationDetails = new HashMap<>();
        locationDetails.put("localtime", location.getLocaltime());
        locationDetails.put("name", location.getName());
        locationDetails.put("lon", location.getLon());
        locationDetails.put("lat", location.getLat());

        // Construct the final simplified response
        simplifiedResponse.put("current", currentDetails);
        simplifiedResponse.put("location", locationDetails);

        return Response.status(200).entity(simplifiedResponse).build();
    }
}