package com.pax.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * @author ligq
 */
public class Now {
    @SerializedName("tem")
    public String temperature;
    @SerializedName("cond")
    public More more;

    public class More {
        @SerializedName("txt")
        public String info;
    }
}
