package com.mapquestApi.traffic.geocoding;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Provided location.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProvidedLocation{

	@JsonProperty("location")
	private String location;

	/**
	 * Get location string.
	 *
	 * @return the string
	 */
	public String getLocation(){
		return location;
	}

	@Override
 	public String toString(){
		return
			"ProvidedLocation{" +
			"location = '" + location + '\'' +
			"}";
		}
}