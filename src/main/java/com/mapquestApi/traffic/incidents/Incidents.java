package com.mapquestApi.traffic.incidents;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Incidents{

	public Incidents(){}

	@JsonProperty("incidents")
	private List<IncidentsItem> incidents;

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