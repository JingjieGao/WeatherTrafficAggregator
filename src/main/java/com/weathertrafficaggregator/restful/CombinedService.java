package com.weathertrafficaggregator.restful;

import com.mapquestApi.traffic.incidents.Incidents;
import com.weathertrafficaggregator.persistence.WeatherResponseDao;
import com.weathertrafficaggregator.util.GeocodingService;
import com.weathertrafficaggregator.util.IncidentsService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;

/**
 * The type Combined service.
 */
@Path("/combined_service")
public class CombinedService {

    private final GeocodingService geocodingService;
    private final IncidentsService incidentsService;

    /**
     * Instantiates a new Combined service.
     */
    public CombinedService() {
        geocodingService = new GeocodingService();
        incidentsService = new IncidentsService();
    }

    /**
     * Instantiates a new Combined service.
     *
     * @param geocodingService the geocoding service
     * @param incidentsService the incidents service
     */
    public CombinedService(GeocodingService geocodingService, IncidentsService incidentsService) {
        this.geocodingService = geocodingService;
        this.incidentsService = incidentsService;
    }

    /**
     * Gets combined data.
     *
     * @param zipcode       the zipcode
     * @param location      the location
     * @param radiusInMiles the radius in miles
     * @return the combined data
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/data")
    public Response getCombinedData(@QueryParam("zipcode") String zipcode,
                                    @QueryParam("location") String location,
                                    @QueryParam("radius") double radiusInMiles) {
        try {
            WeatherResponseDao responseDao = new WeatherResponseDao();
            com.weatherApi.Response response = responseDao.searchLocation(zipcode);

            if (location == null || location.isEmpty() || radiusInMiles <= 0) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Missing or invalid location or radius.")
                        .build();
            }
            String bBox = geocodingService.createBoundingRadius(location, radiusInMiles);
            Incidents incidents = incidentsService.getIncidents(bBox);

            JSONObject combinedData = new JSONObject();

            combinedData.put("weather", response);

            if (incidents != null && incidents.getIncidents() != null && !incidents.getIncidents().isEmpty()) {
                combinedData.put("incidents", incidents.getIncidents());
            } else {
                combinedData.put("incidents", "No incidents found for the specified area.");
            }

            return Response.ok(combinedData.toString()).build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Internal server error while retrieving data.")
                    .build();
        }
    }
}