package com.weathertrafficaggregator.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.weatherApi.Current;
import com.weatherApi.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type Current weather dao.
 */
public class CurrentWeatherDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private final WeatherResponseDao weatherResponseDao = new WeatherResponseDao();

    /**
     * Gets current weather.
     *
     * @param searchString the search string
     * @return the current weather
     * @throws JsonProcessingException the json processing exception
     */
    public Current getCurrentWeather(String searchString) throws JsonProcessingException {
        Response response = weatherResponseDao.searchLocation(searchString);
        Current current = response.getCurrent();
        logger.debug(current.toString());
        return current;
    }
}