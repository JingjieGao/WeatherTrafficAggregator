package com.mapquestApi.traffic.incidents;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * The type Incidents.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Incidents{

	/**
	 * Instantiates a new Incidents.
	 */
	public Incidents(){}

	@JsonProperty("incidents")
	private List<IncidentsItem> incidents;

	/**
	 * Get incidents list.
	 *
	 * @return the list
	 */
	public List<IncidentsItem> getIncidents(){
		return incidents;
	}

	@Override
 	public String toString(){
		return
			"Incident{" +
			"incidents = '" + incidents + '\'' +
			"}";
		}
}