package processors;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

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

        keyboardRowList.add(lawKeyboardRow);
        keyboardRowList.add(lawKeyboardRow2);
        keyboardRowList.add(lawKeyboardRow3);
        keyboardRowList.add(lawKeyboardRow4);

        replyKeyboardMarkup.setKeyboard(keyboardRowList);

        sendMessage.setText("Какая техническая помощь Вам нужна?");
    }

    void setButtonsForFirstButton(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow mainKeyboardRow = new KeyboardRow();
        mainKeyboardRow.add(new KeyboardButton("Техническая поддержка"));

        KeyboardRow mainKeyboardRow2 = new KeyboardRow();
        mainKeyboardRow2.add(new KeyboardButton("Юридическая поддержка"));

        keyboardRows.add(mainKeyboardRow);
        keyboardRows.add(mainKeyboardRow2);

        replyKeyboardMarkup.setKeyboard(keyboardRows);

        sendMessage.setText("https://www.facebook.com/help/188157731232424?helpref=topq");
    }

    void setButtonsForSecondButton(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow mainKeyboardRow = new KeyboardRow();
        mainKeyboardRow.add(new KeyboardButton("Техническая поддержка"));

        KeyboardRow mainKeyboardRow2 = new KeyboardRow();
        mainKeyboardRow2.add(new KeyboardButton("Юридическая поддержка"));

        keyboardRows.add(mainKeyboardRow);
        keyboardRows.add(mainKeyboardRow2);

        replyKeyboardMarkup.setKeyboard(keyboardRows);

        sendMessage.setText("https://hyperione.com/ustanovit-chrome/");
    }

    void setButtonsForThirdButton(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow mainKeyboardRow = new KeyboardRow();
        mainKeyboardRow.add(new KeyboardButton("Техническая поддержка"));

        KeyboardRow mainKeyboardRow2 = new KeyboardRow();
        mainKeyboardRow2.add(new KeyboardButton("Юридическая поддержка"));

        keyboardRows.add(mainKeyboardRow);
        keyboardRows.add(mainKeyboardRow2);

        replyKeyboardMarkup.setKeyboard(keyboardRows);

        sendMessage.setText("https://support.google.com/websearch/answer/134479?hl=ru");
    }
}
