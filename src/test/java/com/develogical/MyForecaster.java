package com.develogical;

public interface MyForecaster {


    class Forecast {
        public final String outlook;
        public final int temperature;

        public Forecast(String outlook, int temperature) {
            this.outlook = outlook;
            this.temperature = temperature;
        }
    }

    public Forecast getWeatherDataFromForecaster(String place, String day);
}
