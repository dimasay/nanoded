package processors;

import org.openqa.selenium.WebDriver;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import selenium.CalculatorSite;

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

    public SendMessage processMessage(Message message, Map<String, Boolean> isBuilder) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());

        String chatId = message.getChatId().toString();
        if (!calculatorAccess.containsKey(chatId)) {
            calculatorAccess.put(chatId, new ArrayList<>());
        }
        chooseAction(message, sendMessage, isBuilder);

        return sendMessage;
    }

    private void chooseAction(Message message, SendMessage sendMessage, Map<String, Boolean> isBuilder) {
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
            case "Консультация с юристом":
                lawHelpProcessor.setConsultButtons(sendMessage);
                break;
            case "Номер тех.поддержки":
                sendMessage.setText("+380668397795 - Саевский Дмитрий, маг 120 уровня");
                break;
            case "Развлечения":
                processFun(sendMessage);
                break;
            case "Конструктор документов":
                setBuilderButtons(sendMessage);
                break;
            case "Виплата допомоги на поховання":
                isBuilder.replace(message.getChatId().toString(), true);
                sendMessage.setText("Введите район и город  управления пенсионного фонда");
                break;
            default:
                processDefault(message, sendMessage);
        }
    }

    private void setBuilderButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = MessageProcessor.setKeyboard(sendMessage);
        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow builderKeyboardRow = new KeyboardRow();
        builderKeyboardRow.add(new KeyboardButton("Виплата допомоги на поховання"));

        KeyboardRow builderKeyboardRow2 = new KeyboardRow();
        builderKeyboardRow2.add(new KeyboardButton("Назад"));

        keyboardRows.add(builderKeyboardRow);
        keyboardRows.add(builderKeyboardRow2);

        replyKeyboardMarkup.setKeyboard(keyboardRows);
        sendMessage.setText("Выберите тип документа");
    }

    private void processFun(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = MessageProcessor.setKeyboard(sendMessage);
        List<KeyboardRow> keyboardRows = MessageProcessor.setMainKeyboardRows();
        replyKeyboardMarkup.setKeyboard(keyboardRows);

        sendMessage.setText("https://t.me/nanodedFun");
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

        KeyboardRow mainKeyboardRow5 = new KeyboardRow();
        mainKeyboardRow5.add(new KeyboardButton("Конструктор документов"));

        KeyboardRow mainKeyboardRow4 = new KeyboardRow();
        mainKeyboardRow4.add(new KeyboardButton("Развлечения"));

        keyboardRows.add(mainKeyboardRow);
        keyboardRows.add(mainKeyboardRow2);
        keyboardRows.add(mainKeyboardRow3);
        keyboardRows.add(mainKeyboardRow5);
        keyboardRows.add(mainKeyboardRow4);

        return keyboardRows;
    }
}
