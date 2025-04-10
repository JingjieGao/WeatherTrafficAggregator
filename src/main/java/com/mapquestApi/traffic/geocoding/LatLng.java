package com.mapquestApi.traffic.geocoding;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Lat lng.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LatLng{

	@JsonProperty("lng")
	private double lng;

	@JsonProperty("lat")
	private double lat;

	/**
	 * Get lng double.
	 *
	 * @return the double
	 */
	public double getLng(){
		return lng;
	}

	/**
	 * Get lat double.
	 *
	 * @return the double
	 */
	public double getLat(){
		return lat;
	}

	@Override
 	public String toString(){
		return
			"LatLng{" +
			"lng = '" + lng + '\'' +
			",lat = '" + lat + '\'' +
			"}";
		}
}