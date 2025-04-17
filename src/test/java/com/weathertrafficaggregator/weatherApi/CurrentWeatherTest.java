package com.weathertrafficaggregator.weatherApi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.weatherApi.Current;
import com.weathertrafficaggregator.persistence.CurrentWeatherDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * The type Current weather test.
 */
public class CurrentWeatherTest {

    /**
     * The Current weather dao.
     */
    CurrentWeatherDao currentWeatherDao;

    /**
     * Sets .
     */
    @BeforeEach
    void setup() {
        currentWeatherDao = new CurrentWeatherDao();
    }

    /**
     * Test get current temp c.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetCurrentTempC() throws Exception {
        String searchQuery = "53597";
        try {
            Current current = currentWeatherDao.getCurrentWeather(searchQuery);
            Object currentTempCelsius = current.getTempC();
            assertNotNull(currentTempCelsius);
           // assertEquals(8.8, currentTempCelsius);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}