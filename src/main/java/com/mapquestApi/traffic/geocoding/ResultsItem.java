package com.mapquestApi.traffic.geocoding;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Results item.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultsItem{

	@JsonProperty("locations")
	private List<LocationsItem> locations;

	@JsonProperty("providedLocation")
	private ProvidedLocation providedLocation;

	/**
	 * Get locations list.
	 *
	 * @return the list
	 */
	public List<LocationsItem> getLocations(){
		return locations;
	}

	/**
	 * Get provided location provided location.
	 *
	 * @return the provided location
	 */
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