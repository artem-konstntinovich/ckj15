package MyTelegram;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.Date;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.generics.LongPollingBot;
import static org.telegram.telegrambots.logging.BotLogger.log;

import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;


public class Bot extends TelegramLongPollingBot {

/*

    public static LongPollingBot getBot() {
        return new Bot();
    }
*/

    @Override
    public void onUpdateReceived(Update update) {/*
        if (   update != null //пустота от другого - бота - программы
                && update.hasMessage()
                && update.getMessage().hasText()) {
            //
            String message_text = update.getMessage().getText();
            if (message_text.equals("/time")) {
                Date currentDate = new Date();
                String messageSend = currentDate.toString();


                long chat_id = update.getMessage().getChatId();
                sendMsg(update.getMessage().
                        getChatId().toString(), messageSend);
            }
        }
           *//* else if (message_text.equals("/empl"))
            {
                //вывод списка сотрудников
                //import java.util.Vector;
                Vector<String> empls = db.getEmplNames();
                String messageSend = "сотрудники: \n";
                for(String str : empls)
                {
                    //messageSend = messageSend + str + "\n";
                    messageSend += str + "\n";
                }
                long chat_id = update.getMessage().getChatId();
                sendMsg(update.getMessage().
                        getChatId().toString(), messageSend);
            }*//*
            else if (message_text.equals("/help"))
            {
                long chat_id = update.getMessage().getChatId();
                sendMsg(update.getMessage().
                        getChatId().toString(), "две команды: /time и /hello");
            }
            else//в ответ отправляю эхом то, что пришло
            {
                String message = update.getMessage().getText();
                sendMsg(update.getMessage().getChatId().toString(), message);
            }*/
            //

    }

    @Override
    public String getBotUsername() {
        return "mytelegabot27122021mbot";
    }

    @Override
    public String getBotToken() {
        return "5086506280:AAFiji8vIObv7IQTt2gdJscUclecO1-1zk8";
    }

    /**
     * Метод для настройки сообщения и его отправки.
     * @param chatId id чата
     * @param s Строка, которую необходимот отправить в качестве сообщения.
     */
    public synchronized void sendMsg(String chatId, String s) {
     /*   SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
           // log.log(Level.SEVERE, "Exception: ", e.toString());
        }
*/
    }
}
