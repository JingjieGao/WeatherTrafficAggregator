package com.weathertrafficaggregator.weatherApi;

import com.weatherApi.Response;
import com.weathertrafficaggregator.persistence.WeatherResponseDao;
import com.weathertrafficaggregator.test.util.Database;
import io.github.cdimascio.dotenv.Dotenv;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * The type Weather api response test.
 */
public class WeatherApiResponseTest {
    /**
     * The Weather response dao.
     */
    WeatherResponseDao weatherResponseDao;

    /**
     * Sets .
     */
    @BeforeEach
    void setup() {
        weatherResponseDao = new WeatherResponseDao();
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
    }

    private final Logger logger = LogManager.getLogger(this.getClass());
    private static final Dotenv dotenv = Dotenv.load();
    /**
     * The Api key.
     */
    String apiKey = dotenv.get("WEATHER_API_KEY");
    /**
     * The Search url.
     */
    String searchUrl = dotenv.get("WEATHER_API_QUERY_URL");

    /**
     * Gets api key.
     *
     * @throws Exception the exception
     */
    @org.junit.jupiter.api.Test
    public void getAPIKey() throws Exception{
        assertEquals(apiKey, dotenv.get("WEATHER_API_KEY"));
        assertEquals(searchUrl, dotenv.get("WEATHER_API_QUERY_URL"));
    }

    /**
     * Test weather api json.
     *
     * @throws Exception the exception
     */
    @Test
    public void testWeatherApiJSON() throws Exception {
        String searchQuery = "53597";

        Response weatherResponse = weatherResponseDao.searchLocation(searchQuery);

        assertNotNull(weatherResponse);
    }
}