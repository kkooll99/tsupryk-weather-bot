package service.impl;

import com.google.gson.Gson;
import com.vdurmont.emoji.Emoji;
import com.vdurmont.emoji.EmojiManager;
import lombok.SneakyThrows;
import model.Weather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import service.WeatherIcon;
import service.WeatherService;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static service.ApiConstants.*;

@Service
public class WeatherServiceImpl implements WeatherService{


    @SneakyThrows
    public String getByCityName(String city)  {

        validateCityName(city);

        var gson = new Gson();

        var httpClient = HttpClient.newBuilder()
                .build();

        var request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(GET_WEATHER_BY_CITY_URL + city.replaceAll(" ", "+") + API_KEY_PARAM))
                .build();

        var responseStr = "Невірно вказане місто!";

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == OK_STATUS_CODE) {
            var weathers = gson.fromJson(response.body(), WeatherResponse.class);


            weathers.data[0].setIcon(new WeatherIcon().getWeatherIcon(weathers.data[0]));
            responseStr = weathers.data[0].toString();
        }



        return responseStr;
    }

    class WeatherResponse {

        Weather[] data;
    }
}
