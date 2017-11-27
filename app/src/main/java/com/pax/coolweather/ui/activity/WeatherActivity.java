package com.pax.coolweather.ui.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.pax.coolweather.R;
import com.pax.coolweather.gson.Weather;
import com.pax.coolweather.ui.fragment.ChooseAreaFragment;
import com.pax.coolweather.util.Utility;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author ligq
 */
public class WeatherActivity extends AppCompatActivity {

    @BindView(R.id.bing_pic_img)
    ImageView bingPicImg;
    @BindView(R.id.nav_button)
    Button navButton;
    @BindView(R.id.title_city)
    TextView titleCity;
    @BindView(R.id.title_update_time)
    TextView titleUpdateTime;
    @BindView(R.id.degree_text)
    TextView degreeText;
    @BindView(R.id.weather_info_text)
    TextView weatherInfoText;
    @BindView(R.id.forecast_layout)
    LinearLayout forecastLayout;
    @BindView(R.id.aqi_text)
    TextView aqiText;
    @BindView(R.id.pm25_text)
    TextView pm25Text;
    @BindView(R.id.comfort_text)
    TextView comfortText;
    @BindView(R.id.car_wash_text)
    TextView carWashText;
    @BindView(R.id.sport_text)
    TextView sportText;
    @BindView(R.id.weather_layout)
    ScrollView weatherLayout;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    @BindView(R.id.choose_area_fragment)
    ChooseAreaFragment chooseAreaFragment;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String weatherString = sp.getString("weather", null);
        if (TextUtils.isEmpty(weatherString)) {
            String weatherId = getIntent().getStringExtra("weather_id");
            weatherLayout.setVisibility(View.INVISIBLE);
            requestWeather(weatherId);
        } else {
            Weather weather = Utility.handleWeatherResponse(weatherString);
            showWeatherInfo(weather);
        }

    }

    private void showWeatherInfo(Weather weather) {
        // TODO: 2017/11/27  
    }

    private void requestWeather(String weatherId) {
        // TODO: 2017/11/27  
    }
}
