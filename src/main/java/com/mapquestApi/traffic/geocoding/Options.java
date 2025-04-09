package com.mapquestApi.traffic.geocoding;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Options{

	@JsonProperty("maxResults")
	private int maxResults;

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