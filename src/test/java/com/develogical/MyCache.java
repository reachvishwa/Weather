package com.develogical;

import java.util.HashMap;
import java.util.Map;

public class MyCache implements MyForecaster {
    private final MyForecaster delegate;
    private final Map<String, Forecast> cache = new HashMap<>();

    public MyCache(MyForecaster delegate) {
        this.delegate = delegate;
    }

    @Override
    public Forecast getWeatherDataFromForecaster(String place, String day) {
        if (cache.containsKey(place)) {
            return cache.get(place);
        }
        Forecast result = delegate.getWeatherDataFromForecaster(place, day);
        cache.put(place, result);
        return result;
    }


}
