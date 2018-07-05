package com.develogical;

import com.weather.Day;
import com.weather.Forecaster;
import com.weather.Region;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MyCacheTest {
    @Test
    public void getWeatherDataFromForecasterTest() throws Exception {
        MyForecaster delegate = mock(MyForecaster.class);

        MyCache myCache = new MyCache(delegate);
        myCache.getWeatherDataFromForecaster("p", "d");

        verify(delegate).getWeatherDataFromForecaster("p", "d");
    }

    @Test
    public void onlyGetsForecastFromDelegateOnce() throws Exception {
        MyForecaster delegate = mock(MyForecaster.class);

        MyCache myCache = new MyCache(delegate);
        myCache.getWeatherDataFromForecaster("p", "d");
        myCache.getWeatherDataFromForecaster("p", "d");
        myCache.getWeatherDataFromForecaster("p", "d");
        myCache.getWeatherDataFromForecaster("p", "d");
        myCache.getWeatherDataFromForecaster("p", "d");

        verify(delegate, times(1)).getWeatherDataFromForecaster("p", "d");
    }

    @Test
    public void getForecastforToday() throws Exception {
        MyForecaster delegate = mock(MyForecaster.class);

        MyCache myCache = new MyCache(delegate);
        myCache.getWeatherDataFromForecaster("p",new Date( 2018,1,1,1,0).toString());
        verify(delegate, times(1)).getWeatherDataFromForecaster("p",new Date( 2018,1,1,1,0).toString());
    }



}
