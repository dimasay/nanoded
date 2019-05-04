package processors;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.Collections;

class TechHelpProcessor {
    void setTechButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        KeyboardRow lawKeyboardRow = new KeyboardRow();
        lawKeyboardRow.add(new KeyboardButton("Регистрация в соц. сети"));
        lawKeyboardRow.add(new KeyboardButton("Установка браузера"));
        lawKeyboardRow.add(new KeyboardButton("Использование поисковика"));
        lawKeyboardRow.add(new KeyboardButton("Назад"));

        replyKeyboardMarkup.setKeyboard(Collections.singletonList(lawKeyboardRow));

        sendMessage.setText("Какая техническая помощь Вам нужна?");
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

        sendMessage.setText("https://www.facebook.com/help/188157731232424?helpref=topq");
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

        sendMessage.setText("https://hyperione.com/ustanovit-chrome/");
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

        sendMessage.setText("https://support.google.com/websearch/answer/134479?hl=ru");
    }
}
