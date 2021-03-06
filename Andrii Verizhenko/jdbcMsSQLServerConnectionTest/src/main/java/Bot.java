
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.generics.LongPollingBot;

import java.sql.SQLException;
import java.util.Date;

import static java.lang.Integer.parseInt;

public class Bot extends TelegramLongPollingBot {


    public static LongPollingBot getBot() {
        return new Bot();
    }

    @Override
    public void onUpdateReceived(Update update) {
        //
        if (   update != null //пустота от другого - бота - программы
                && update.hasMessage()
                && update.getMessage().hasText())
        {
            String message_text = update.getMessage().getText();
            if (message_text.equals("/time"))
            {
                Date currentDate = new Date();
                String messageSend = currentDate.toString();

                long chat_id = update.getMessage().getChatId();
                sendMsg(update.getMessage().
                        getChatId().toString(), messageSend);
            }
            else if (message_text.equals("/help"))
            {
                long chat_id = update.getMessage().getChatId();
                sendMsg(update.getMessage().
                        getChatId().toString(), "пять команд: /time, /showID , /id= , /help  и /empl");
            }
            else if (message_text.equals("/empl"))
            {
                String messageSend = MySQLiteDataBase.getSelect();
                long chat_id = update.getMessage().getChatId();
                sendMsg(update.getMessage().
                        getChatId().toString(), messageSend);
            }  else if (message_text.equals("/showID"))
            {
                String messageSend = null;
                try {
                    messageSend = MySQLiteDataBase.customerID();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                long chat_id = update.getMessage().getChatId();
                sendMsg(update.getMessage().
                        getChatId().toString(), messageSend);
            }else if (message_text.contains("/id="))
            {
                String messageSend = null;
                try {
                    messageSend = MySQLiteDataBase.customerById(message_text.replace("/id=","").trim());
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                long chat_id = update.getMessage().getChatId();
                sendMsg(update.getMessage().
                        getChatId().toString(), messageSend);
            }
            else//в ответ отправл¤ю эхом то, что пришло
            {
                String message = update.getMessage().getText();
                sendMsg(update.getMessage().getChatId().toString(), message);
            }
        }
        //
    }

    @Override
    public String getBotUsername() {
        return "northwindMyBot";
    }

    @Override
    public String getBotToken() {
        return "5026733639:AAEsS5Qqsz_Xi-xhTm6EIMBYF9swCD7ynJY";
    }
    /**
     * ћетод дл¤ настройки сообщени¤ и его отправки.
     * @param chatId id чата
     * @param s —трока, которую необходимот отправить в качестве сообщени¤.
     */
    public synchronized void sendMsg(String chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            //log.log(Level.SEVERE, "Exception: ", e.toString());
        }
    }

}
