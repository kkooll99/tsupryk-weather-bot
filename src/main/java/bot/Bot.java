package bot;

import lombok.SneakyThrows;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendSticker;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import service.impl.WeatherServiceImpl;

import java.util.List;


public class Bot extends TelegramLongPollingBot {

    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        var cityName = update.getMessage().getText();

        var service = new WeatherServiceImpl();
        var sendMsg = new SendMessage();
        sendMsg.enableMarkdown(true);
        sendMsg.setChatId(update.getMessage().getChatId());
        sendMsg.setText(service.getByCityName(cityName));

        KeyboardRow firstKeyboardRow = new KeyboardRow();
        firstKeyboardRow.add("Hi");

        KeyboardRow secondKeyboardRow = new KeyboardRow();
        secondKeyboardRow.add("Bye");


        sendMsg.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setKeyboard(List.of(firstKeyboardRow, secondKeyboardRow));
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);

        execute(sendMsg);


    }

    //@SneakyThrows
    //public synchronized void sendMsg(String chatId, String msg) {
    //}

    @Override
    public String getBotUsername() {
        return "tsupryk_service_weather_bot";
    }

    @Override
    public String getBotToken() {
        return "1196421477:AAEzPVQVM-9bpaj8dGiImeQ-FvUqB-W5MoY";
    }
}
