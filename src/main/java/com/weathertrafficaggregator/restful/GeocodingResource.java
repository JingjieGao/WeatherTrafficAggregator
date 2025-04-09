package com.weathertrafficaggregator.restful;

import com.mapquestApi.traffic.geocoding.Geocoding;
import com.weathertrafficaggregator.persistence.GeocodingDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/geocoding")
public class GeocodingResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTrafficIncidents(@QueryParam("location") String location) throws Exception {
        GeocodingDao geocodingDao = new GeocodingDao();
        if(location == null || location.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        Geocoding geocoding = geocodingDao.geocodingResponse(location);

        return Response.ok().build();
     }
}