package com.weathertrafficaggregator.util;

import com.mapquestApi.traffic.geocoding.Geocoding;
import com.weathertrafficaggregator.persistence.GeocodingDao;

/**
 * The type Geocoding service.
 */
public class GeocodingService {

    private final GeocodingDao geocodingDao;

    /**
     * Instantiates a new Geocoding service.
     */
    public GeocodingService() {
        geocodingDao = new GeocodingDao();
    }

    /**
     * Instantiates a new Geocoding service.
     *
     * @param geocodingDao the geocoding dao
     */
    public GeocodingService(GeocodingDao geocodingDao) {
        this.geocodingDao = geocodingDao;
    }

    /**
     * Gets geocoding dao.
     *
     * @return the geocoding dao
     */
    public GeocodingDao getGeocodingDao() {
        return geocodingDao;
    }

    /**
     * Creates bounding box area from a given radius
     *
     * @param location      the location the bounding box area surrounds
     * @param radiusInMiles the radius in miles the bounding box should extend beyond the location
     * @return the bounding box values as a string
     * @throws Exception the exception problems with reading or retrieving data, or validation
     */
    public String createBoundingRadius(String location, double radiusInMiles) throws Exception {
        Geocoding geocoding = geocodingDao.geocodingResponse(location);
        if (geocoding != null) {
            double lat = geocodingDao.getLat(geocoding);
            double lng = geocodingDao.getLng(geocoding);
            return BoundingBoxCalculator.getBoundingBox(lat, lng, radiusInMiles).toString();
        } else {
            return null;
        }
    }
}