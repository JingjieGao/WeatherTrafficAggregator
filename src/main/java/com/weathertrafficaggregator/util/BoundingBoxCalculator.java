package com.weathertrafficaggregator.util;

public class BoundingBoxCalculator {

    public static class BoundingBox {
        public double minLat;
        public double maxLat;
        public double minLng;
        public double maxLng;

        public BoundingBox(double minLat, double maxLat, double minLng, double maxLng) {
            this.minLat = minLat;
            this.maxLat = maxLat;
            this.minLng = minLng;
            this.maxLng = maxLng;
        }
    }

    public static BoundingBox getBoundingBox(double lat, double lng, double radiusInMiles) {
        final double MILES_PER_LAT_DEGREE = 69.0;
        double latDelta = radiusInMiles / MILES_PER_LAT_DEGREE;
        double lngDelta = radiusInMiles / (MILES_PER_LAT_DEGREE * Math.cos(Math.toRadians(lat)));

        double minLat = lat - latDelta;
        double maxLat = lat + latDelta;
        double minLng = lng - lngDelta;
        double maxLng = lng + lngDelta;

        return new BoundingBox(minLat, maxLat, minLng, maxLng);
    }
}