package com.mapquestApi.traffic.geocoding;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultsItem{

	@JsonProperty("locations")
	private List<LocationsItem> locations;

	@JsonProperty("providedLocation")
	private ProvidedLocation providedLocation;

	public List<LocationsItem> getLocations(){
		return locations;
	}

	public ProvidedLocation getProvidedLocation(){
		return providedLocation;
	}

	@Override
 	public String toString(){
		return
			"ResultsItem{" +
			"locations = '" + locations + '\'' +
			",providedLocation = '" + providedLocation + '\'' +
			"}";
		}
}