package teamproject.weathertrafficaggregator.weatherApi;

import com.teamproject.weathertrafficaggregator.persistence.WeatherResponseDao;
import com.weatherApi.Current;
import com.weatherApi.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WeatherApiResponseTest {
    WeatherResponseDao weatherResponseDao;

    @BeforeEach
    void setup() {
        weatherResponseDao = new WeatherResponseDao();
    }

    private final Logger logger = LogManager.getLogger(this.getClass());
    private static final Dotenv dotenv = Dotenv.load();
    String apiKey = dotenv.get("WEATHER_API_KEY");
    String searchUrl = dotenv.get("WEATHER_API_QUERY_URL");

    @org.junit.jupiter.api.Test
    public void getAPIKey() throws Exception{
        assertEquals(apiKey, dotenv.get("WEATHER_API_KEY"));
        assertEquals(searchUrl, dotenv.get("WEATHER_API_QUERY_URL"));
    }

    @Test
    public void testWeatherApiJSON() throws Exception {
        String searchQuery = "53597";

        Response weatherResponse = weatherResponseDao.searchLocation(searchQuery);

        assertNotNull(weatherResponse);
    }
}
