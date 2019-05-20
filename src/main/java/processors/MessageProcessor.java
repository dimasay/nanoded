package processors;

import org.openqa.selenium.WebDriver;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import selenium.CalculatorSite;
import utils.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageProcessor {
    private LawHelpProcessor lawHelpProcessor;
    private TechHelpProcessor techHelpProcessor;
    private CalculatorSite calculatorSite;
    private Map<String, List<String>> calculatorAccess;
    public static String pathToMessages = "C:\\dedText\\";

    public MessageProcessor(WebDriver oWebDriver) {
        this.lawHelpProcessor = new LawHelpProcessor();
        this.techHelpProcessor = new TechHelpProcessor();
        this.calculatorSite = new CalculatorSite(oWebDriver);
        calculatorAccess = new HashMap<>();
    }

    public SendMessage process(Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());

        if (!calculatorAccess.containsKey(message.getChatId().toString())) {
            calculatorAccess.put(message.getChatId().toString(), new ArrayList<>());
        }
        chooseAction(message, sendMessage);
        return sendMessage;
    }

    private void chooseAction(Message message, SendMessage sendMessage) {
        switch (message.getText()) {
            case "/start":
            case "Назад":
                setMainButtons(sendMessage);
                break;
            case "Техническая поддержка":
                techHelpProcessor.setTechButtons(sendMessage);
                break;
            case "Юридическая поддержка":
                lawHelpProcessor.setLawButtons(sendMessage);
                break;
            case "Защита персональных данных":
                lawHelpProcessor.setButtonsForFirstButton(sendMessage);
                break;
            case "Пенсионное законодательство":
                lawHelpProcessor.setButtonsForSecondButton(sendMessage);
                break;
            case "Защита от взлома":
                lawHelpProcessor.setButtonsForThirdButton(sendMessage);
                break;
            case "Киберполиция":
                lawHelpProcessor.setButtonsForFourthButton(sendMessage);
                break;
            case "Регистрация в соц. сети":
                techHelpProcessor.setButtonsForFirstButton(sendMessage);
                break;
            case "Установка браузера":
                techHelpProcessor.setButtonsForSecondButton(sendMessage);
                break;
            case "Использование поисковика":
                techHelpProcessor.setButtonsForThirdButton(sendMessage);
                break;
            case "Калькулятор коммунальных платежей":
                setCalculatorButtons(sendMessage);
                break;
            case "Газ":
                List<String> calcListGas = new ArrayList<>();
                calcListGas.add("Газ");
                calculatorAccess.replace(message.getChatId().toString(), calcListGas);
                sendMessage.setText("Введите старые показания счетчика:");
                break;
            case "Электроэнергия":
                List<String> calcListE = new ArrayList<>();
                calcListE.add("Электроэнергия");
                calculatorAccess.replace(message.getChatId().toString(), calcListE);
                sendMessage.setText("Введите старые показания счетчика:");
                break;
            default:
                processDefault(message, sendMessage);
        }
    }

    private void setDoc(SendMessage sendMessage) {
        File file = new File(pathToMessages + "1.txt");
        String message = FileUtils.readMessageFromFile(file);
        sendMessage.setText(message);
    }

    private void processDefault(Message message, SendMessage sendMessage) {
        try {
            int pokazaniya = Integer.parseInt(message.getText());
            List<String> chatValues = calculatorAccess.get(message.getChatId().toString());
            if (chatValues.size() == 1) {
                chatValues.add(String.valueOf(pokazaniya));
                calculatorAccess.replace(message.getChatId().toString(), chatValues);
                sendMessage.setText("Введите новые показания счетчика:");
            } else if (chatValues.size() == 2) {
                chatValues.add(String.valueOf(pokazaniya));
                calculatorSite.calculate(message.getChatId().toString(), chatValues, calculatorAccess, sendMessage);
            }
        } catch (NumberFormatException e) {
            sendMessage.setText("Вы ввели данные в неправильном формате. Повторите попытку.");
        }
    }

    private void setCalculatorButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = setKeyboard(sendMessage);

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow calcKeyboardRow = new KeyboardRow();
        calcKeyboardRow.add(new KeyboardButton("Газ"));

        KeyboardRow calcKeyboardRow2 = new KeyboardRow();
        calcKeyboardRow2.add(new KeyboardButton("Электроэнергия"));

        KeyboardRow calcKeyboardRow3 = new KeyboardRow();
        calcKeyboardRow3.add(new KeyboardButton("Назад"));

        keyboardRows.add(calcKeyboardRow);
        keyboardRows.add(calcKeyboardRow2);
        keyboardRows.add(calcKeyboardRow3);

        replyKeyboardMarkup.setKeyboard(keyboardRows);

        sendMessage.setText("Выберите тип коммунальных услуг.");
    }

    private void setMainButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = setKeyboard(sendMessage);
        List<KeyboardRow> keyboardRows = setMainKeyboardRows();
        replyKeyboardMarkup.setKeyboard(keyboardRows);

        sendMessage.setText("В какой помощи Вы нуждаетесь?");
    }

    static ReplyKeyboardMarkup setKeyboard(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        return replyKeyboardMarkup;
    }

    static List<KeyboardRow> setMainKeyboardRows() {
        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow mainKeyboardRow = new KeyboardRow();
        mainKeyboardRow.add(new KeyboardButton("Техническая поддержка"));

        KeyboardRow mainKeyboardRow2 = new KeyboardRow();
        mainKeyboardRow2.add(new KeyboardButton("Юридическая поддержка"));

        KeyboardRow mainKeyboardRow3 = new KeyboardRow();
        mainKeyboardRow3.add(new KeyboardButton("Калькулятор коммунальных платежей"));



        keyboardRows.add(mainKeyboardRow);
        keyboardRows.add(mainKeyboardRow2);
        keyboardRows.add(mainKeyboardRow3);

        return keyboardRows;
    }
}
