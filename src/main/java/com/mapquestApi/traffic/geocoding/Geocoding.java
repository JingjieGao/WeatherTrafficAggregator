package com.mapquestApi.traffic.geocoding;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Geocoding.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Geocoding{

	@JsonProperty("options")
	private Options options;

	@JsonProperty("results")
	private List<ResultsItem> results;

	/**
	 * Get options options.
	 *
	 * @return the options
	 */
	public Options getOptions(){
		return options;
	}

	/**
	 * Get results list.
	 *
	 * @return the list
	 */
	public List<ResultsItem> getResults(){
		return results;
	}

	@Override
 	public String toString(){
		return
			"Geocoding{" +
			"options = '" + options + '\'' +
			",results = '" + results + '\'' +
			"}";
		}
}