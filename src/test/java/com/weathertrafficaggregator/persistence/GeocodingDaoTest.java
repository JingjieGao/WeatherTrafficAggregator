package com.weathertrafficaggregator.persistence;

import com.mapquestApi.traffic.geocoding.LocationsItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Geocoding dao test.
 */
class GeocodingDaoTest {
    /**
     * The Geocoding dao.
     */
    GeocodingDao geocodingDao;

    /**
     * Sets up method to be performed before each test and instantiates geocoding dao.
     */
    @BeforeEach
    void setup() {
        geocodingDao = new GeocodingDao();
    }

    /**
     * Test geocoding response success.
     *
     * @throws Exception the exception
     */
    @Test
    void testGeocodingResponseSuccess() throws Exception {
        String location = "Madison College Madison 53704";
        assertNotNull(geocodingDao.geocodingResponse(location));
        assertEquals(location, geocodingDao.geocodingResponse(location).getResults().get(0).getProvidedLocation().getLocation());

        List<LocationsItem> items = geocodingDao.geocodingResponse(location)
                .getResults()
                .get(0)
                .getLocations();

        assertNotNull(items);
        assertTrue(items.get(0).getPostalCode().contains("53704"));
        assertEquals(-89.32785, items.get(0).getLatLng().getLng());
        assertEquals(43.12242, items.get(0).getLatLng().getLat());
    }
}