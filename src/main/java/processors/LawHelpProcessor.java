package processors;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

class LawHelpProcessor {
    void setLawButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

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
        lawKeyboardRow4.add(new KeyboardButton("Назад"));

        keyboardRowList.add(lawKeyboardRow);
        keyboardRowList.add(lawKeyboardRow3);
        keyboardRowList.add(lawKeyboardRow3);
        keyboardRowList.add(lawKeyboardRow4);
        keyboardRowList.add(lawKeyboardRow5);

        replyKeyboardMarkup.setKeyboard(keyboardRowList);

        sendMessage.setText("Какая юридическая помощь Вам нужна?");
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

        sendMessage.setText("Закон Украины «О защите персональных данных»\n" +
                "https://cedem.org.ua/ru/library/zakon-ukrayny-o-zashhyte-personalnyh-dannyh/");

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

        sendMessage.setText("Про загальнообов'язкове державне пенсійне страхування\n" +
                "https://zakon.rada.gov.ua/laws/show/1058-15");
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

        sendMessage.setText("Как защитить от взлома домашний ПК\n" +
                "https://ichip.ru/kak-zashhitit-ot-vzloma-domashnijj-pk.html");
    }

    void setButtonsForFourthButton(SendMessage sendMessage) {
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

        sendMessage.setText("Причерноморское Управление киберполиции\n" +
                "Департамент киберполиции НПУ\n" +
                "Скидановский Спуск, 7а\n" +
                "Приморский район, Одесса\n" +
                "+380 (48) 733–52–08\n" +
                "+380 67–910–35–29\n" +
                "www.cyberpolice.gov.ua");
    }
}
