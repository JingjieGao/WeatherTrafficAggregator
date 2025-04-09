package com.weathertrafficaggregator.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mapquestApi.traffic.incidents.Incidents;
import com.mapquestApi.traffic.incidents.IncidentsItem;
import com.weathertrafficaggregator.entity.Incident;
import io.github.cdimascio.dotenv.Dotenv;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class IncidentDao {
    private static final Dotenv dotenv = Dotenv.load();
    private GeocodingDao geocodingDao;

    public IncidentDao() {}

    public String createIncidentsResponse(String boundingBoxValues) {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target(dotenv.get("MAPQUEST_INCIDENTS_BASE_URL"))
                        .queryParam("key", dotenv.get("MAPQUEST_API_KEY"))
                        .queryParam("fields", "construction,incidents,event,congestion")
                        .queryParam("boundingBox", boundingBoxValues);

        return target.request(MediaType.APPLICATION_JSON).get(String.class);
    }

    public Incidents getIncidentsResponse(String response) {
        ObjectMapper mapper = new ObjectMapper();
        Incidents incidents = null;
        try {
            incidents = mapper.readValue(response, Incidents.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return incidents;
    }
}