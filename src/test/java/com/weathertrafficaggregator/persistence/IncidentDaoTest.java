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

class IncidentDaoTest {
    IncidentDao incidentDao;

    @BeforeEach
    void setUp() {
        incidentDao = new IncidentDao();
    }

    @Test
    void getIncidentResponseSuccess() {
        String response = incidentDao.createIncidentsResponse("43.19488,-89.42710,43.04996,-89.22860");
        //assertEquals("???",incidentDao.incidentsResponse("43.19488,-89.42710,43.04996,-89.22860"));
        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode node = mapper.readTree(response);
            JsonNode incidents = node.path("incidents");
            assertNotNull(incidents);
            assertTrue(incidents.isArray());
            Incidents ins = mapper.readValue(response, Incidents.class);
        for(IncidentsItem item : ins.getIncidents()) {
            System.out.println(item);
        }


        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}