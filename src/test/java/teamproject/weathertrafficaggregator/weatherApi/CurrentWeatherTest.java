package teamproject.weathertrafficaggregator.weatherApi;

import com.teamproject.weathertrafficaggregator.persistence.CurrentWeatherDao;
import com.weatherApi.Current;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CurrentWeatherTest {
    CurrentWeatherDao currentWeatherDao;

    @BeforeEach
    void setup() {
        currentWeatherDao = new CurrentWeatherDao();
    }

    @Test
    public void testGetCurrentTempC() throws Exception {
        String searchQuery = "53597";

        Current current = currentWeatherDao.getCurrentWeather(searchQuery);
        Object currentTempCelsius = current.getTempC();

        assertNotNull(currentTempCelsius);
        assertEquals(8.8, currentTempCelsius);
    }
}
