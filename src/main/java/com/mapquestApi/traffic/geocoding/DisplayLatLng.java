package com.mapquestApi.traffic.geocoding;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Display lat lng.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DisplayLatLng{

	@JsonProperty("lng")
	private Object lng;

	@JsonProperty("lat")
	private Object lat;

	/**
	 * Get lng object.
	 *
	 * @return the object
	 */
	public Object getLng(){
		return lng;
	}

	/**
	 * Get lat object.
	 *
	 * @return the object
	 */
	public Object getLat(){
		return lat;
	}

	@Override
 	public String toString(){
		return
			"DisplayLatLng{" +
			"lng = '" + lng + '\'' +
			",lat = '" + lat + '\'' +
			"}";
		}
}