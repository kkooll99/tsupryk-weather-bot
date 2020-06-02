import bot.Bot;
import config.BotConfig;
import exceptions.IncorrectCityNameException;
import lombok.SneakyThrows;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import service.WeatherService;
import service.impl.FakeWeatherServiceImpl;
import service.impl.WeatherServiceImpl;

import java.io.IOException;


public class BotMainApp {

    @SneakyThrows
    public static void main(String[] args) {

        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        telegramBotsApi.registerBot(new Bot());

    }
}



/*
        var annotationConfigApplicationContext = new AnnotationConfigApplicationContext(BotConfig.class);
        var weatherService = annotationConfigApplicationContext.getBean(WeatherService.class);




        try {
            System.out.println(weatherService.getByCityName("Львів"));
        } catch (IncorrectCityNameException e) {
            System.out.println(e.getMessage());
        }
*/