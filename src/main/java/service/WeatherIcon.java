package service;

import com.vdurmont.emoji.Emoji;
import com.vdurmont.emoji.EmojiManager;
import model.Weather;
import service.impl.WeatherServiceImpl;

public class WeatherIcon {
    public String getWeatherIcon (Weather weathers) {
        Emoji emoji = null;
        System.out.println(weathers.toString());
        if (weathers.getClouds() >= 80) {
            if (weathers.getPrecip() >= 50) {

                if (weathers.getSnow() > 0) {
                    emoji = EmojiManager.getForAlias("cloud_snow");

                } else {
                    emoji = EmojiManager.getForAlias("cloud_rain");

                }
            } else {
                emoji = EmojiManager.getForAlias("cloud");

            }
        } else {
            if (weathers.getClouds() >= 30 && weathers.getPrecip() >= 30) {
                emoji = EmojiManager.getForAlias("white_sun_behind_cloud_rain");

            } else

            if (weathers.getClouds() >= 30) {
                emoji = EmojiManager.getForAlias("partly_sunny");

            } else {
                emoji = EmojiManager.getForAlias("sunny");

            }



        }


        return emoji.getUnicode();
    }
}
