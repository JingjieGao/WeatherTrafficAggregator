package com.weathertrafficaggregator.restful;

import com.mapquestApi.traffic.incidents.Incidents;
import com.weathertrafficaggregator.util.GeocodingService;
import com.weathertrafficaggregator.util.IncidentsService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Resource class for traffic incident data.
 */
@Path("/traffic")
public class IncidentsResource {

    private final GeocodingService geocodingService;
    private final IncidentsService incidentsService;

    /**
     * Instantiates a new Incidents resource.
     */
    public IncidentsResource() {
        geocodingService = new GeocodingService();
        incidentsService = new IncidentsService();
    }

    /**
     * Instantiates a new Incidents resource.
     *
     * @param geocodingService the geocoding service
     * @param incidentsService the incidents service
     */
    public IncidentsResource(GeocodingService geocodingService, IncidentsService incidentsService) {
        this.geocodingService = geocodingService;
        this.incidentsService = incidentsService;
    }

    /**
     * Returns the incident data as a plain text response.
     *
     * @param location      the location
     * @param radiusInMiles the radius
     * @return HTTP response with incidents or error message
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/incidents")
    public Response getIncidents(@QueryParam("location") String location,
                                 @QueryParam("radius") double radiusInMiles) {
        if (location == null || location.isEmpty() || radiusInMiles <= 0) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Missing or invalid location or radius.")
                    .build();
        }

        try {
            String bBox = geocodingService.createBoundingRadius(location, radiusInMiles);
            Incidents items = incidentsService.getIncidents(bBox);

            if (items == null || items.getIncidents() == null || items.getIncidents().isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("No incidents found for the specified area.")
                        .build();
            }

            String formatted = incidentsService.displayIncidents(items);
            return Response.ok(formatted).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Internal server error while retrieving incidents.")
                    .build();
        }
    }


    /**
     * Gets incidents as json.
     *
     * @param location      the location
     * @param radiusInMiles the radius in miles
     * @return the incidents as json
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/incidents/json")
    public Response getIncidentsAsJson(@QueryParam("location") String location,
                                 @QueryParam("radius") double radiusInMiles) {
        try {
            String bBox = geocodingService.createBoundingRadius(location, radiusInMiles);
            Incidents items = incidentsService.getIncidents(bBox);

            if (items == null || items.getIncidents() == null || items.getIncidents().isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Error: No incidents found for the specified area.")
                        .build();
            }
            return Response.ok(items.getIncidents()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Internal server error while retrieving incidents.")
                    .build();
        }
    }
}