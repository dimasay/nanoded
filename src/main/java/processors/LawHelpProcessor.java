package processors;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.Collections;

class LawHelpProcessor {
    void setLawButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        KeyboardRow lawKeyboardRow = new KeyboardRow();
        lawKeyboardRow.add(new KeyboardButton("Защита персональных данных"));
        lawKeyboardRow.add(new KeyboardButton("Пенсионное законодательство"));
        lawKeyboardRow.add(new KeyboardButton("Защита от взлома"));
        lawKeyboardRow.add(new KeyboardButton("Киберполиция"));
        lawKeyboardRow.add(new KeyboardButton("Назад"));

        replyKeyboardMarkup.setKeyboard(Collections.singletonList(lawKeyboardRow));

        sendMessage.setText("Какая юридическая помощь Вам нужна?");
    }

    void setButtonsForFirstButton(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        KeyboardRow lawKeyboardRow = new KeyboardRow();
        lawKeyboardRow.add(new KeyboardButton("Техническая поддержка"));
        lawKeyboardRow.add(new KeyboardButton("Юридическая поддержка"));

        replyKeyboardMarkup.setKeyboard(Collections.singletonList(lawKeyboardRow));

        sendMessage.setText("Закон Украины «О защите персональных данных»\n" +
                "https://cedem.org.ua/ru/library/zakon-ukrayny-o-zashhyte-personalnyh-dannyh/");

    }

    void setButtonsForSecondButton(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        KeyboardRow lawKeyboardRow = new KeyboardRow();
        lawKeyboardRow.add(new KeyboardButton("Техническая поддержка"));
        lawKeyboardRow.add(new KeyboardButton("Юридическая поддержка"));

        replyKeyboardMarkup.setKeyboard(Collections.singletonList(lawKeyboardRow));

        sendMessage.setText("Про загальнообов'язкове державне пенсійне страхування\n" +
                "https://zakon.rada.gov.ua/laws/show/1058-15");
    }

    void setButtonsForThirdButton(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        KeyboardRow lawKeyboardRow = new KeyboardRow();
        lawKeyboardRow.add(new KeyboardButton("Техническая поддержка"));
        lawKeyboardRow.add(new KeyboardButton("Юридическая поддержка"));

        replyKeyboardMarkup.setKeyboard(Collections.singletonList(lawKeyboardRow));

        sendMessage.setText("Как защитить от взлома домашний ПК\n" +
                "https://ichip.ru/kak-zashhitit-ot-vzloma-domashnijj-pk.html");
    }

    void setButtonsForFourthButton(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        KeyboardRow lawKeyboardRow = new KeyboardRow();
        lawKeyboardRow.add(new KeyboardButton("Техническая поддержка"));
        lawKeyboardRow.add(new KeyboardButton("Юридическая поддержка"));

        replyKeyboardMarkup.setKeyboard(Collections.singletonList(lawKeyboardRow));

        sendMessage.setText("Причерноморское Управление киберполиции\n" +
                "Департамент киберполиции НПУ\n" +
                "Скидановский Спуск, 7а\n" +
                "Приморский район, Одесса\n" +
                "+380 (48) 733–52–08\n" +
                "+380 67–910–35–29\n" +
                "www.cyberpolice.gov.ua");
    }
}
