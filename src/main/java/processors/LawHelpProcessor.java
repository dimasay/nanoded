package processors;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import utils.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class LawHelpProcessor {
    void setLawButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = MessageProcessor.setKeyboard(sendMessage);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow lawKeyboardRow = new KeyboardRow();
        lawKeyboardRow.add(new KeyboardButton("Защита персональных данных"));

        KeyboardRow lawKeyboardRow2 = new KeyboardRow();
        lawKeyboardRow2.add(new KeyboardButton("Пенсионное законодательство"));

        KeyboardRow lawKeyboardRow3 = new KeyboardRow();
        lawKeyboardRow3.add(new KeyboardButton("Защита от взлома"));

        KeyboardRow lawKeyboardRow4 = new KeyboardRow();
        lawKeyboardRow4.add(new KeyboardButton("Киберполиция"));

        KeyboardRow lawKeyboardRow5 = new KeyboardRow();
        lawKeyboardRow5.add(new KeyboardButton("Назад"));

        keyboardRowList.add(lawKeyboardRow);
        keyboardRowList.add(lawKeyboardRow2);
        keyboardRowList.add(lawKeyboardRow3);
        keyboardRowList.add(lawKeyboardRow4);
        keyboardRowList.add(lawKeyboardRow5);

        replyKeyboardMarkup.setKeyboard(keyboardRowList);

        File file = new File(MessageProcessor.pathToMessages + "юридическаПоддержка.txt");
        String message = FileUtils.readMessageFromFile(file);
        sendMessage.setText(message);
    }

    void setButtonsForFirstButton(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = MessageProcessor.setKeyboard(sendMessage);
        List<KeyboardRow> keyboardRows = MessageProcessor.setMainKeyboardRows();
        replyKeyboardMarkup.setKeyboard(keyboardRows);

        File file = new File(MessageProcessor.pathToMessages + "защитаПерсональныхДанных.txt");
        String message = FileUtils.readMessageFromFile(file);
        sendMessage.setText(message);
    }

    void setButtonsForSecondButton(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = MessageProcessor.setKeyboard(sendMessage);
        List<KeyboardRow> keyboardRows = MessageProcessor.setMainKeyboardRows();
        replyKeyboardMarkup.setKeyboard(keyboardRows);

        File file = new File(MessageProcessor.pathToMessages + "пенсионноеЗаконодательство.txt");
        String message = FileUtils.readMessageFromFile(file);
        sendMessage.setText(message);
    }

    void setButtonsForThirdButton(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = MessageProcessor.setKeyboard(sendMessage);
        List<KeyboardRow> keyboardRows = MessageProcessor.setMainKeyboardRows();
        replyKeyboardMarkup.setKeyboard(keyboardRows);

        File file = new File(MessageProcessor.pathToMessages + "защитаОтВзлома.txt");
        String message = FileUtils.readMessageFromFile(file);
        sendMessage.setText(message);
    }

    void setButtonsForFourthButton(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = MessageProcessor.setKeyboard(sendMessage);
        List<KeyboardRow> keyboardRows = MessageProcessor.setMainKeyboardRows();
        replyKeyboardMarkup.setKeyboard(keyboardRows);

        File file = new File(MessageProcessor.pathToMessages + "киберполиция.txt");
        String message = FileUtils.readMessageFromFile(file);
        sendMessage.setText(message);
    }
}
