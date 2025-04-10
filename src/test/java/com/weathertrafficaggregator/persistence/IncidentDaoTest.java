package com.weathertrafficaggregator.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mapquestApi.traffic.incidents.Incidents;
import com.mapquestApi.traffic.incidents.IncidentsItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Incident dao test.
 */
class IncidentDaoTest {
    /**
     * The Incident dao.
     */
    IncidentDao incidentDao;

    /**
     * Sets up method to be performed before each test and instantiates incident dao.
     */
    @BeforeEach
    void setUp() {
        incidentDao = new IncidentDao();
    }

    /**
     * Gets incident response success.
     */
    @Test
    void getIncidentResponseSuccess() {
        String response = incidentDao.createIncidentsResponse("43.19488,-89.42710,43.04996,-89.22860");
        assertNotNull(response);

        ObjectMapper mapper = new ObjectMapper();
        try {
            Incidents ins = mapper.readValue(response, Incidents.class);
            assertNotNull(ins);
            assertTrue(!ins.getIncidents().isEmpty());
            assertTrue(ins.getIncidents().get(0).getType() >= 1 || ins.getIncidents().get(0).getType() <= 4);
            assertTrue(ins.getIncidents().get(0).getSeverity() >= 1 || ins.getIncidents().get(0).getSeverity() <= 4);
            assertTrue(ins.getIncidents().get(0).getStartTime().length() == 19);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}