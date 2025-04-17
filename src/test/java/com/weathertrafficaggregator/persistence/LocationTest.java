package com.weathertrafficaggregator.persistence;

import com.weathertrafficaggregator.entity.Location;
import com.weathertrafficaggregator.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {

    GenericDao<Location> genericDao;

    @BeforeEach
    void setUp() {
        genericDao = new GenericDao<>(Location.class);
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
    }

    @Test
    void getById() {
        Location retrievedLocation = genericDao.getById(1);

        assertNotNull(retrievedLocation);
        assertEquals("53597", retrievedLocation.getZipcode());
    }

    @Test
    void insert() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Location weatherAndTrafficData = new Location("53597", 5.0, "{\"weather\":{\"current\":{\"feelslike_f\":41.4,\"wind_mph\":6,\"humidity\":50,\"wind_dir\":\"NNE\",\"temp_f\":44.8},\"location\":{\"localtime\":\"2025-04-15 22:04\",\"name\":\"Waunakee\",\"lon\":-89.4532012939453,\"lat\":43.1818008422852}},\"incidents\":[{\"severity\":3,\"lng\":-89.45683,\"distance\":0.08763206960845245,\"impacting\":true,\"startTime\":\"2025-04-15T12:40:56\",\"id\":\"3944290500030770243\",\"endTime\":\"2025-04-17T00:40:56\",\"type\":4,\"lat\":43.19079,\"fullDesc\":\"Closed\"}]}" );

        genericDao.insert(weatherAndTrafficData);

        String retrievedData = weatherAndTrafficData.getZipcode();

        assertEquals(retrievedData, weatherAndTrafficData.getZipcode());
    }

    @Test
    void deleteEntity() {
        Location locationToBeDeleted = genericDao.getById(1);
        genericDao.deleteEntity(locationToBeDeleted);
        assertNull(genericDao.getById(1));
    }

    @Test
    void getAll() {
        List<Location> locations = genericDao.getAll();

        int tableSize = locations.size();

        assertNotNull(locations);
        assertEquals(tableSize, locations.size());
    }
}