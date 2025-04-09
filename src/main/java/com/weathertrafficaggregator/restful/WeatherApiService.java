package com.weathertrafficaggregator.restful;

import com.weathertrafficaggregator.persistence.WeatherResponseDao;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

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
        com.weatherApi.Response response = responseDao.searchLocation(zipcode);
        return Response.status(200).entity(response).build();
    }
}