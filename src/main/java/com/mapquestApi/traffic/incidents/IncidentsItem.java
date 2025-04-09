package com.mapquestApi.traffic.incidents;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IncidentsItem{

	public IncidentsItem(){}

	@JsonProperty("severity")
	private int severity;

	@JsonProperty("lng")
	private Object lng;

	@JsonProperty("distance")
	private Object distance;

	@JsonProperty("impacting")
	private boolean impacting;

	@JsonProperty("type")
	private int type;

	@JsonProperty("fullDesc")
	private String fullDesc;

	@JsonProperty("startTime")
	private String startTime;

	@JsonProperty("id")
	private String id;

	@JsonProperty("endTime")
	private String endTime;

	@JsonProperty("lat")
	private Object lat;


	public int getSeverity(){
		return severity;
	}

	public Object getLng(){
		return lng;
	}

	public Object getDistance(){
		return distance;
	}

	public boolean isImpacting(){
		return impacting;
	}


	public int getType(){
		return type;
	}

	public String getFullDesc(){
		return fullDesc;
	}

	public String getStartTime(){
		return startTime;
	}


	public String getId(){
		return id;
	}

	public String getEndTime(){
		return endTime;
	}

	public Object getLat(){
		return lat;
	}


	public String getTypeDescription(int type) {
		switch (type) {
			case 1: return String.valueOf("Construction");
			case 2: return String.valueOf("Event");
			case 3: return String.valueOf("Congestion/Flow");
			case 4: return String.valueOf("Incident/Accident");
			default: return String.valueOf("Unknown");
		}
	}


	public String severityDescription(int severity) {
		if (severity >= 3  && isImpacting()) {
			return "High impact";
		} else if (severity == 2) {
			return "Moderate impact";
		} else {
			return "Low impact";
		}
	}

	@Override
 	public String toString(){
		return
			"IncidentsItem{" +
			"severity = '" + severity + '\'' +
			",lng = '" + lng + '\'' +
			",distance = '" + distance + '\'' +
			",impacting = '" + impacting + '\'' +
			",type = '" + type + '\'' +
			",fullDesc = '" + fullDesc + '\'' +
			",startTime = '" + startTime + '\'' +
			",id = '" + id + '\'' +
			",endTime = '" + endTime + '\'' +
			",lat = '" + lat + '\'' +
			"}";
		}
}