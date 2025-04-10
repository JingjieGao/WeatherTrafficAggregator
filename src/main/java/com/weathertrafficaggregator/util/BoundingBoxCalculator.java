package com.weathertrafficaggregator.util;

/**
 * The type Bounding box calculator.
 */
public class BoundingBoxCalculator {

    /**
     * The type Bounding box.
     */
    public static class BoundingBox {
        /**
         * The Min lat.
         */
        public double minLat;
        /**
         * The Max lat.
         */
        public double maxLat;
        /**
         * The Min lng.
         */
        public double minLng;
        /**
         * The Max lng.
         */
        public double maxLng;

        /**
         * Instantiates a new Bounding box.
         *
         * @param minLat the min lat
         * @param maxLat the max lat
         * @param minLng the min lng
         * @param maxLng the max lng
         */
        public BoundingBox(double minLat, double maxLat, double minLng, double maxLng) {
            this.minLat = minLat;
            this.maxLat = maxLat;
            this.minLng = minLng;
            this.maxLng = maxLng;
        }

        @Override
        public String toString() {
            return maxLat + "," + minLng + "," + minLat + "," + maxLng;
        }

        /**
         * From string bounding box.
         *
         * @param bboxStr the bbox str
         * @return the bounding box
         */
        public static BoundingBox fromString(String bboxStr) {
            String[] parts = bboxStr.split(",");
            double minLat = Double.parseDouble(parts[0]);
            double maxLat = Double.parseDouble(parts[1]);
            double minLng = Double.parseDouble(parts[2]);
            double maxLng = Double.parseDouble(parts[3]);
            return new BoundingBox(minLat, maxLat, minLng, maxLng);
        }
    }

    /**
     * Calculates bounding box values
     *
     * @param lat           the lat
     * @param lng           the lng
     * @param radiusInMiles the radius in miles
     * @return the bounding box
     */
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