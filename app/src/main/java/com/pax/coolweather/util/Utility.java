package com.pax.coolweather.util;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.pax.coolweather.constant.Const;
import com.pax.coolweather.db.City;
import com.pax.coolweather.db.County;
import com.pax.coolweather.db.Province;
import com.pax.coolweather.gson.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 解析和处理服务器返回的数据
 *
 * @author ligq
 */
public class Utility {

    /**
     * 解析和处理服务器返回的省级数据
     *
     * @param response 服务器返回的数据
     * @return 解析是否成功
     */
    public static boolean handleProvinceResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allProvinces = new JSONArray(response);
                for (int i = 0; i < allProvinces.length(); i++) {
                    JSONObject provinceObj = (JSONObject) allProvinces.get(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObj.getString("name"));
                    province.setProvinceCode(provinceObj.getInt("id"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                Log.i(Const.TAG, "handleProvinceResponse: " + e.getLocalizedMessage());
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     *
     * @param response 服务器返回的数据
     * @return 解析是否成功
     */
    public static boolean handleCityResponse(String response, int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCities = new JSONArray(response);
                for (int i = 0; i < allCities.length(); i++) {
                    JSONObject cityObj = (JSONObject) allCities.get(i);
                    City city = new City();
                    city.setCityName(cityObj.getString("name"));
                    city.setCityCode(cityObj.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                Log.i(Const.TAG, "handleCityResponse: " + e.getLocalizedMessage());
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的县级数据
     *
     * @param response 服务器返回的数据
     * @return 解析是否成功
     */
    public static boolean handleCountyResponse(String response, int cityId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCounties = new JSONArray(response);
                for (int i = 0; i < allCounties.length(); i++) {
                    JSONObject countyObj = (JSONObject) allCounties.get(i);
                    County county = new County();
                    county.setCountyName(countyObj.getString("name"));
                    county.setWeatherId(countyObj.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                Log.i(Const.TAG, "handleCountyResponse: " + e.getLocalizedMessage());
            }
        }
        return false;
    }

    /**
     * 解析服务器返回天气的数据
     *
     * @param response 天气数据
     * @return 天气实体类
     */
    public static Weather handleWeatherResponse(String response) {
        try {
            Log.i(Const.TAG, "handleWeatherResponse: response=" + response);
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent, Weather.class);
        } catch (JSONException e) {
            Log.i(Const.TAG, "handleWeatherResponse: e:" + e.getLocalizedMessage());
        }
        return null;
    }
}
