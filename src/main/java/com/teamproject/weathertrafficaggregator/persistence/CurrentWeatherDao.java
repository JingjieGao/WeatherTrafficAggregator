package com.teamproject.weathertrafficaggregator.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.weatherApi.Current;
import com.weatherApi.Response;
import io.github.cdimascio.dotenv.Dotenv;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CurrentWeatherDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private final WeatherResponseDao weatherResponseDao = new WeatherResponseDao();

    public Current getCurrentWeather(String searchString) throws JsonProcessingException {
        Response response = weatherResponseDao.searchLocation(searchString);
        Current current = response.getCurrent();
        logger.debug(current.toString());
        return current;
    }
}
