package com.mapquestApi.traffic.incidents;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Incidents item.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IncidentsItem{

	/**
	 * Instantiates a new Incidents item.
	 */
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


	/**
	 * Get severity int.
	 *
	 * @return the int
	 */
	public int getSeverity(){
		return severity;
	}

	/**
	 * Get lng object.
	 *
	 * @return the object
	 */
	public Object getLng(){
		return lng;
	}

	/**
	 * Get distance object.
	 *
	 * @return the object
	 */
	public Object getDistance(){
		return distance;
	}

	/**
	 * Is impacting boolean.
	 *
	 * @return the boolean
	 */
	public boolean isImpacting(){
		return impacting;
	}


	/**
	 * Get type int.
	 *
	 * @return the int
	 */
	public int getType(){
		return type;
	}

	/**
	 * Get full desc string.
	 *
	 * @return the string
	 */
	public String getFullDesc(){
		return fullDesc;
	}

	/**
	 * Get start time string.
	 *
	 * @return the string
	 */
	public String getStartTime(){
		return startTime;
	}


	/**
	 * Get id string.
	 *
	 * @return the string
	 */
	public String getId(){
		return id;
	}

	/**
	 * Get end time string.
	 *
	 * @return the string
	 */
	public String getEndTime(){
		return endTime;
	}

	/**
	 * Get lat object.
	 *
	 * @return the object
	 */
	public Object getLat(){
		return lat;
	}


	/**
	 * Gets type description.
	 *
	 * @param type the type
	 * @return the type description
	 */
	public String getTypeDescription(int type) {
		switch (type) {
			case 1: return String.valueOf("Construction");
			case 2: return String.valueOf("Event");
			case 3: return String.valueOf("Congestion/Flow");
			case 4: return String.valueOf("Incident/Accident");
			default: return String.valueOf("Unknown");
		}
	}


	/**
	 * Severity description string.
	 *
	 * @param severity the severity
	 * @return the string
	 */
	public String severityDescription(int severity) {
		if (severity >= 3  && isImpacting()) {
			return "High impact";
		} else if (severity == 2) {
			return "Moderate impact";
		} else {
			return "Low impact";
		}
	}

	/**
	 * Gets incident start date.
	 *
	 * @param startTime the start time
	 * @return the incident start date
	 */
	public String getIncidentStartDate(String startTime) {
		return startTime.substring(0, 10);
	}

	/**
	 * Gets incident end date.
	 *
	 * @param endTime the end time
	 * @return the incident end date
	 */
	public String getIncidentEndDate(String endTime) {
		return endTime.substring(0, 10);
	}

	/**
	 * Format start time string.
	 *
	 * @param startTime the start time
	 * @return the string
	 */
	public String formatStartTime(String startTime) {
		return startTime.substring(11);
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