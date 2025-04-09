package com.mapquestApi.traffic.geocoding;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DisplayLatLng{

	@JsonProperty("lng")
	private Object lng;

	@JsonProperty("lat")
	private Object lat;

	public Object getLng(){
		return lng;
	}

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