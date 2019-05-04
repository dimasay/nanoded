package processors;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class MessageProcessor {
    private LawHelpProcessor lawHelpProcessor;
    private TechHelpProcessor techHelpProcessor;

    public MessageProcessor() {
        this.lawHelpProcessor = new LawHelpProcessor();
        this.techHelpProcessor = new TechHelpProcessor();
    }

    public SendMessage process(Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());
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
        }
    }

    private void setMainButtons(SendMessage sendMessage) {
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

        sendMessage.setText("В какой помощи Вы нуждаетесь?");
    }
}
