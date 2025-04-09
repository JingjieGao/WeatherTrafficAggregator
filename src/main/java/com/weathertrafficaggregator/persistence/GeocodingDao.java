package com.weathertrafficaggregator.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mapquestApi.traffic.geocoding.Geocoding;
import io.github.cdimascio.dotenv.Dotenv;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;


public class GeocodingDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private static final Dotenv dotenv = Dotenv.load();

    public GeocodingDao(){}

    public Geocoding geocodingResponse(String location) throws Exception {
        Client client = ClientBuilder.newClient();

        WebTarget target =
                client.target(dotenv.get("MAPQUEST_GEOCODING_BASE_URL"))
                             .queryParam("key", dotenv.get("MAPQUEST_API_KEY"))
                             .queryParam("maxResults", 1)
                             .queryParam("location", location);
        logger.info(target);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(response, Geocoding.class);
        } catch (JsonProcessingException e) {
            logger.error("Error parsing response: {}", e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    public String getLat(Geocoding geocoding) {
        return geocoding.getResults().get(0).getLocations().get(0).getLatLng().getLat().toString();
    }

    public String getLng(Geocoding geocoding) {
        return geocoding.getResults().get(0).getLocations().get(0).getLatLng().getLng().toString();
    }
}