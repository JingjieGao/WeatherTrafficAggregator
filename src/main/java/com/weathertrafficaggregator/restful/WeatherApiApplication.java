package com.weathertrafficaggregator.restful;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class WeatherApiApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> classSet = new HashSet<Class<?>>();
        classSet.add(WeatherApiService.class);
        return classSet;
    }
}