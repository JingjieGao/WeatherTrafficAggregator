package com.mapquestApi.traffic.geocoding;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProvidedLocation{

	@JsonProperty("location")
	private String location;

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