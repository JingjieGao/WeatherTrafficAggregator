package com.mapquestApi.traffic.geocoding;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Geocoding{

	@JsonProperty("options")
	private Options options;

	@JsonProperty("results")
	private List<ResultsItem> results;

	public Options getOptions(){
		return options;
	}

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