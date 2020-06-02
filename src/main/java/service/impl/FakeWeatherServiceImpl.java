package service.impl;

import exceptions.IncorrectCityNameException;
import model.Weather;
import service.WeatherService;

import java.util.List;
import java.util.Map;

import static javax.security.auth.callback.ConfirmationCallback.NO;
import static service.ApiConstants.NOT_FOUND_STATUS_CODE;
import static service.ApiConstants.OK_STATUS_CODE;

public class FakeWeatherServiceImpl implements WeatherService{

    public String getByCityName(String city) {

        validateCityName(city);

        WeatherResponse weatherResponse = fakeHTTPClient(city.toLowerCase());

        var weather = "";

        if (weatherResponse.statusCode != NOT_FOUND_STATUS_CODE) {
            weather = weatherResponse.body.toString();
        }


        return weather;
    }


    private WeatherResponse fakeHTTPClient(String cityName) {
        WeatherResponse weatherResponse = null;

  /*      var lviv = new Weather("Lviv", "UA", 18, 0);
        var kyiv = new Weather("Kyiv", "UA", 20, 12);
        var odesa = new Weather("Odesa", "UA", 25, 20);
        var yalta = new Weather("Yalta", "UA", 28, 90);

        Map<String, Weather> cities = Map.of("lviv", lviv,
                                                "kyiv", kyiv,
                                                "odesa", odesa,
                                                "yalta", yalta);

        var weather = cities.get(cityName);

        if (weather == null) {
            weatherResponse = new WeatherResponse(NOT_FOUND_STATUS_CODE, null);
        } else {
            weatherResponse = new WeatherResponse(OK_STATUS_CODE, weather);
        }
     */   return weatherResponse;
    }

    class WeatherResponse {
        int statusCode;
        Weather body;

        public WeatherResponse(int statusCode, Weather body) {
            this.statusCode = statusCode;
            this.body = body;
        }
    }

}
