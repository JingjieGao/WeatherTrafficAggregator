package com.weathertrafficaggregator.restful;

import com.mapquestApi.traffic.incidents.Incidents;
import com.weathertrafficaggregator.entity.Location;
import com.weathertrafficaggregator.persistence.GenericDao;
import com.weathertrafficaggregator.persistence.WeatherResponseDao;
import com.weathertrafficaggregator.util.GeocodingService;
import com.weathertrafficaggregator.util.IncidentsService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;

import java.util.List;

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
            com.weatherApi.Response weatherResponse = responseDao.searchLocation(zipcode);

            com.weatherApi.Current current = weatherResponse.getCurrent();
            com.weatherApi.Location weatherLocation = weatherResponse.getLocation();

            // Create simplified weather JSON
            JSONObject weatherJson = new JSONObject();

            JSONObject currentJson = new JSONObject();
            currentJson.put("feelslike_f", current.getFeelslikeF());
            currentJson.put("temp_f", current.getTempF());
            currentJson.put("wind_mph", current.getWindMph());
            currentJson.put("humidity", current.getHumidity());
            currentJson.put("wind_dir", current.getWindDir());

            JSONObject locationJson = new JSONObject();
            locationJson.put("localtime", weatherLocation.getLocaltime());
            locationJson.put("name", weatherLocation.getName());
            locationJson.put("lon", weatherLocation.getLon());
            locationJson.put("lat", weatherLocation.getLat());

            weatherJson.put("current", currentJson);
            weatherJson.put("location", locationJson);

            if (location == null || location.isEmpty() || radiusInMiles <= 0) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Missing or invalid location or radius.")
                        .build();
            }
            String bBox = geocodingService.createBoundingRadius(location, radiusInMiles);
            Incidents incidents = incidentsService.getIncidents(bBox);

            JSONObject combinedData = new JSONObject();

            combinedData.put("weather", weatherJson);

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

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/new-location")
    public Response createNewLocation(@FormParam("zipcode") String zipcode,
                                      @FormParam("location") String location,
                                      @FormParam("radius") double radiusInMiles) {

        // curl -X POST curl -X POST "http://localhost:8080/weather_traffic_aggregator_war/api/combined_service/new-location" \
        //     -d "zipcode=90210&location=Los Angeles&radius=10"
        try {
            WeatherResponseDao responseDao = new WeatherResponseDao();
            com.weatherApi.Response weatherResponse = responseDao.searchLocation(zipcode);

            com.weatherApi.Current current = weatherResponse.getCurrent();
            com.weatherApi.Location weatherLocation = weatherResponse.getLocation();

            // Create simplified weather JSON
            JSONObject weatherJson = new JSONObject();

            JSONObject currentJson = new JSONObject();
            currentJson.put("feelslike_f", current.getFeelslikeF());
            currentJson.put("temp_f", current.getTempF());
            currentJson.put("wind_mph", current.getWindMph());
            currentJson.put("humidity", current.getHumidity());
            currentJson.put("wind_dir", current.getWindDir());

            JSONObject locationJson = new JSONObject();
            locationJson.put("localtime", weatherLocation.getLocaltime());
            locationJson.put("name", weatherLocation.getName());
            locationJson.put("lon", weatherLocation.getLon());
            locationJson.put("lat", weatherLocation.getLat());

            weatherJson.put("current", currentJson);
            weatherJson.put("location", locationJson);

            if (location == null || location.isEmpty() || radiusInMiles <= 0) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Missing or invalid location or radius.")
                        .build();
            }
            String bBox = geocodingService.createBoundingRadius(location, radiusInMiles);
            Incidents incidents = incidentsService.getIncidents(bBox);

            JSONObject combinedData = new JSONObject();

            combinedData.put("weather", weatherJson);

            if (incidents != null && incidents.getIncidents() != null && !incidents.getIncidents().isEmpty()) {
                combinedData.put("incidents", incidents.getIncidents());
            } else {
                combinedData.put("incidents", "No incidents found for the specified area.");
            }

            Location newWeatherAndTrafficReport = new Location(zipcode, radiusInMiles, combinedData.toString());

            GenericDao<Location> dao = new GenericDao<>(Location.class);

            dao.insert(newWeatherAndTrafficReport);

//            return Response.ok(combinedData.toString()).build();
            return Response.status(200).entity(newWeatherAndTrafficReport).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Internal server error while retrieving data.")
                    .build();
        }
    }

    @GET
    @Path("/{id}") // combined_service/2
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCombinedDataById(@PathParam("id") int id) {
        // curl -X GET http://localhost:8080/weather_traffic_aggregator_war/api/combined_service/2

        GenericDao<Location> dao = new GenericDao<>(Location.class);
        Location location = dao.getById(id);

        if(location == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.status(200).entity(location).build();
    }

    @GET
    @Path("/get-all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCombinedData() {
        // curl -X GET http://localhost:8080/weather_traffic_aggregator_war/api/combined_service/get-all

        GenericDao<Location> dao = new GenericDao<>(Location.class);
        List<Location> locations = dao.getAll();

        if(locations == null || locations.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.status(200).entity(locations).build();
    }

    @DELETE
    @Path("/{locationId}")
    public Response deleteCombinedData(@PathParam("locationId") int locationId) {
        // curl -X DELETE http://localhost:8080/weather_traffic_aggregator_war/api/combined_service/{locationId}

        GenericDao<Location> dao = new GenericDao<>(Location.class);
        Location location = dao.getById(locationId);

        if (location == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        dao.deleteEntity(location);

        String successResponse = "{\"message\":\"Location " + locationId + " deleted successfully.\"}";
        return Response.ok(successResponse).build();
    }
}