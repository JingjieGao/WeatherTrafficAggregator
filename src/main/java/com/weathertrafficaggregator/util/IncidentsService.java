package com.weathertrafficaggregator.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mapquestApi.traffic.incidents.Incidents;
import com.mapquestApi.traffic.incidents.IncidentsItem;
import com.weathertrafficaggregator.persistence.IncidentDao;
import org.jvnet.hk2.annotations.Service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Singleton;
import java.util.List;

/**
 * The type Incidents service.
 */
public class IncidentsService {
    private final IncidentDao incidentsDao;

    /**
     * Instantiates a new Incidents service.
     */
    public IncidentsService(){
        incidentsDao = new IncidentDao();
    }

    /**
     * Instantiates a new Incidents service.
     *
     * @param incidentsDao the incidents dao
     */
    public IncidentsService(IncidentDao incidentsDao) {
        this.incidentsDao = incidentsDao;
    }

    /**
     * Gets incidents dao.
     *
     * @return the incidents dao
     */
    public IncidentDao getIncidentsDao() {
        return incidentsDao;
    }

    /**
     * Gets traffic incidents from a given bounding box area.
     *
     * @param boundingBox the bounding box boundaries
     * @return the incidents within the bounding box boundaries
     * @throws Exception the exception
     */
    public Incidents getIncidents(String boundingBox) throws Exception {
        String response = incidentsDao.createIncidentsResponse(boundingBox);
        return incidentsDao.getIncidentsResponse(response);
    }

    /**
     * Formatted display of incidents included in the report.
     *
     * @param incidents the incidents
     * @return the reported incidents
     */
    public String displayIncidents(Incidents incidents) {
        StringBuilder builder = new StringBuilder();
        for (IncidentsItem item : incidents.getIncidents()) {
            builder.append("Type: ").append(item.getTypeDescription(item.getType())).append("\n");
            builder.append("Severity: ").append(item.severityDescription(item.getSeverity())).append("\n");
            builder.append("Description: ").append(item.getFullDesc()).append("\n");
            builder.append("Incident start date: ").append(item.getIncidentStartDate(item.getStartTime())).append("\n");
            builder.append("Incident reported at: ").append(item.formatStartTime(item.getStartTime())).append("\n");
            builder.append("Expected end date: ").append(item.getIncidentEndDate(item.getEndTime())).append("\n");
            builder.append("\n\n");
        }
        return builder.toString();
    }
}