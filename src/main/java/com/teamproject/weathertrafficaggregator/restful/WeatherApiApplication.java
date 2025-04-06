package com.teamproject.weathertrafficaggregator.restful;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class WeatherApiApplication extends Application {
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(WeatherApiService.class);
        return h;
    }
}
