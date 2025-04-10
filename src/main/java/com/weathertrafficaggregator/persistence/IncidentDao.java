package com.weathertrafficaggregator.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mapquestApi.traffic.incidents.Incidents;
import io.github.cdimascio.dotenv.Dotenv;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * The type Incident dao.
 */
public class IncidentDao {
    private static final Dotenv dotenv = Dotenv.load();
    private GeocodingDao geocodingDao;

    /**
     * Instantiates a new Incident dao.
     */
    public IncidentDao() {}

    /**
     * Create incidents response string.
     *
     * @param boundingBoxValues the bounding box values
     * @return the response string
     */
    public String createIncidentsResponse(String boundingBoxValues) {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target(dotenv.get("MAPQUEST_INCIDENTS_BASE_URL"))
                        .queryParam("key", dotenv.get("MAPQUEST_API_KEY"))
                        .queryParam("filters", "construction,incidents,event,congestion")
                        .queryParam("boundingBox", boundingBoxValues);
        return target.request(MediaType.APPLICATION_JSON).get(String.class);
    }

    /**
     * Gets incidents response.
     *
     * @param response the response
     * @return the incidents response
     */
    public Incidents getIncidentsResponse(String response) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(response, Incidents.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}