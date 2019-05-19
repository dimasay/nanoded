import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import processors.MessageProcessor;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Program {
    private static final File chromeDriverFile = new File("chromedriver.exe");
    private static final File edgeDriverFile = new File("geckodriver.exe");
    public static WebDriver oWebDriver;

    static {
        System.setProperty("webdriver.gecko.driver", edgeDriverFile.getAbsolutePath());
    }

    public static void main(String[] args) {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, chromeDriverFile.getAbsolutePath());
        oWebDriver = new ChromeDriver();
        oWebDriver.get("http://calcuslug.ho.ua/");

        JFrame frame = new JFrame("NanoDed");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(260, 100);
        frame.setVisible(true);
        frame.add(new JLabel("NanoDed server for Telegram was started"), BorderLayout.CENTER);

        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new NanoDedBot(new MessageProcessor(oWebDriver)));
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }

    }
}
