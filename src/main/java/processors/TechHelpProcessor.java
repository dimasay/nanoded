package processors;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import utils.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class TechHelpProcessor {
    void setTechButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();

        KeyboardRow lawKeyboardRow = new KeyboardRow();
        lawKeyboardRow.add(new KeyboardButton("Регистрация в соц. сети"));

        KeyboardRow lawKeyboardRow2 = new KeyboardRow();
        lawKeyboardRow2.add(new KeyboardButton("Установка браузера"));

        KeyboardRow lawKeyboardRow3 = new KeyboardRow();
        lawKeyboardRow3.add(new KeyboardButton("Использование поисковика"));

        KeyboardRow lawKeyboardRow4 = new KeyboardRow();
        lawKeyboardRow4.add(new KeyboardButton("Назад"));

        KeyboardRow lawKeyboard5 = new KeyboardRow();
        lawKeyboard5.add(new KeyboardButton("Номер тех.поддержки"));

        keyboardRowList.add(lawKeyboardRow);
        keyboardRowList.add(lawKeyboardRow2);
        keyboardRowList.add(lawKeyboardRow3);
        keyboardRowList.add(lawKeyboard5);
        keyboardRowList.add(lawKeyboardRow4);

        replyKeyboardMarkup.setKeyboard(keyboardRowList);

        File file = new File(MessageProcessor.pathToMessages + "техническаяПоддержка.txt");
        String message = FileUtils.readMessageFromFile(file);
        sendMessage.setText(message);
    }

    void setButtonsForFirstButton(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = MessageProcessor.setKeyboard(sendMessage);
        List<KeyboardRow> keyboardRows = MessageProcessor.setMainKeyboardRows();
        replyKeyboardMarkup.setKeyboard(keyboardRows);

        File file = new File(MessageProcessor.pathToMessages + "регистрациявсоцсети.txt");
        String message = FileUtils.readMessageFromFile(file);
        sendMessage.setText(message);
    }

    void setButtonsForSecondButton(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = MessageProcessor.setKeyboard(sendMessage);
        List<KeyboardRow> keyboardRows = MessageProcessor.setMainKeyboardRows();
        replyKeyboardMarkup.setKeyboard(keyboardRows);

        File file = new File(MessageProcessor.pathToMessages + "установкаБраузера.txt");
        String message = FileUtils.readMessageFromFile(file);
        sendMessage.setText(message);
    }

    void setButtonsForThirdButton(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = MessageProcessor.setKeyboard(sendMessage);
        List<KeyboardRow> keyboardRows = MessageProcessor.setMainKeyboardRows();
        replyKeyboardMarkup.setKeyboard(keyboardRows);

        File file = new File(MessageProcessor.pathToMessages + "использованиеПоисковика.txt");
        String message = FileUtils.readMessageFromFile(file);
        sendMessage.setText(message);
    }
}
