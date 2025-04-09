package com.weathertrafficaggregator.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Incident {

    @JsonProperty("type")
    public String type;

    @JsonProperty("severity")
    public int severity;

    @JsonProperty("startTime")
    public String startTime;

    @JsonProperty("endTime")
    public String endTime;

    @JsonProperty("startDate")
    public String startDate;

    @JsonProperty("endDate")
    public String endDate;

    @JsonProperty("impacting")
    public String impacting;

    @JsonProperty("description")
    public String description;

    public Incident() {}

    public Incident(String type, int severity, String startTime, String endTime,
                    String startDate, String endDate, String impacting, String description) {
        this.type = type;
        this.severity = severity;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startDate = startDate;
        this.endDate = endDate;
        this.impacting = impacting;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImpacting() {
        return "true".equalsIgnoreCase(impacting) ? "true" : "";
    }

    public void setImpacting(String impacting) {
        this.impacting = impacting;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeDescription() {
        switch (type) {
            case "1": return "Construction";
            case "2": return "Event";
            case "3": return "Congestion/Flow";
            case "4": return "Incident/Accident";
            default: return "Unknown";
        }
    }


    public String severityDescription(int severity) {
        if (severity >= 3  && impacting.equals("true")) {
            return "High impact";
        } else if (severity == 2) {
            return "Moderate impact";
        } else {
            return "Low impact";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Incident incident = (Incident) o;
        return severity == incident.severity && Objects.equals(type, incident.type) && Objects.equals(startTime, incident.startTime) && Objects.equals(endTime, incident.endTime) && Objects.equals(startDate, incident.startDate) && Objects.equals(endDate, incident.endDate) && Objects.equals(impacting, incident.impacting) && Objects.equals(description, incident.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, severity, startTime, endTime, startDate, endDate, impacting, description);
    }

    @Override
    public String toString() {
        return "Incident{" +
                "type='" + type + '\'' +
                ", severity=" + severity +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", impacting='" + impacting + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}