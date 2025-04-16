package com.weathertrafficaggregator.weatherApi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.weatherApi.Current;
import com.weathertrafficaggregator.persistence.CurrentWeatherDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CurrentWeatherTest {

    CurrentWeatherDao currentWeatherDao;

    @BeforeEach
    void setup() {
        currentWeatherDao = new CurrentWeatherDao();
    }

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