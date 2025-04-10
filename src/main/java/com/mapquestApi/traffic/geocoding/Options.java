package com.mapquestApi.traffic.geocoding;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Options.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Options{

	@JsonProperty("maxResults")
	private int maxResults;

	/**
	 * Get max results int.
	 *
	 * @return the int
	 */
	public int getMaxResults(){
		return maxResults;
	}

	@Override
 	public String toString(){
		return
			"Options{" +
			"maxResults = '" + maxResults + '\'' +
			"}";
		}
}