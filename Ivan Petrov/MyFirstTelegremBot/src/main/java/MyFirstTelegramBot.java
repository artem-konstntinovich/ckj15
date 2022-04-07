
import MyTelegram.Bot;
import Database.MySQLiteDatabase;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;


public class My FirstTelegramBot {


    public static void main(String[] args){
        System.out.println("Hello from jdbcSQLiteConnection");
        // System.out.println(MySQLiteDataBase.getSelect());

        //"заставил" свое приложение и Java машину
        //"проинициализировать" - загрузить в память
        //и сделать доступным все драйверы из maven
        //для работы с телеграммом
        ApiContextInitializer.init();
        //Класс для работы с телеграммом как с сервером
        //нужен мне только для регистрации своего класса
        //Bot при помощи которого я буду обрабатывать
        //приходящие сообщения
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try
        {
            //зарегистрировал свой токен -
            //теперь телеграм знает, что мое
            //приложение онлайн и ему можно передавать
            //данные
            telegramBotsApi.registerBot(new Bot());
            // telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
        //

        //
    }


}
