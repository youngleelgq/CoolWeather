package com.pax.coolweather.gson;

/**
 * @author ligq
 */
public class Aqi {

    public AqiCity city;

    public class AqiCity {
        public String aqi;
        public String pm25;
    }
}
