import logic.MainLoop;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException, TelegramApiRequestException, InterruptedException {
        ApiContextInitializer.init();
        TelegramBotsApi botapi = new TelegramBotsApi();

        Properties props = new Properties();
        props.load(new FileInputStream("resources/config.properties"));
        TelegramClient bot = new TelegramClient(props);

        botapi.registerBot(bot);

        MainLoop mainLoop = new MainLoop();
        mainLoop.startLoop(bot, bot);
    }
}