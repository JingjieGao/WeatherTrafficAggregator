package com.weathertrafficaggregator.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherApi.Current;
import com.weatherApi.Response;
import io.github.cdimascio.dotenv.Dotenv;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class WeatherResponseDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private static final Dotenv dotenv = Dotenv.load();
    String apiKey = dotenv.get("WEATHER_API_KEY");
    String searchUrl = dotenv.get("WEATHER_API_QUERY_URL");

    public Response searchLocation(String searchString) throws JsonProcessingException {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target(searchUrl + searchString + apiKey);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        logger.debug(response);
        return mapper.readValue(response, Response.class);
    }
}