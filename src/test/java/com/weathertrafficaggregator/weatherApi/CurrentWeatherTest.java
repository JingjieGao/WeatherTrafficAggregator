package com.weathertrafficaggregator.weatherApi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.weathertrafficaggregator.persistence.CurrentWeatherDao;
import com.weatherApi.Current;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

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