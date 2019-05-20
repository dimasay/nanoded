package processors;

import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class DocumentBuilder {
    public Map<SendMessage, SendDocument> buildDoc(Message message, Map<String, Map<String, String>> userBuilderData, String fileName) throws Exception {
        String chatId = message.getChatId().toString();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        SendDocument sendDocument = new SendDocument();
        sendDocument.setChatId(chatId);
        Map<SendMessage, SendDocument> messageDocumentMap = new HashMap<>();
        Map<String, String> replaceMap = userBuilderData.get(chatId);

        if (replaceMap.size() == 0) {
            replaceMap.put("{district}", message.getText());
            userBuilderData.replace(chatId, replaceMap);
            sendMessage.setText("Введите ваше ФИО");
            messageDocumentMap.put(sendMessage, null);
        } else if (replaceMap.size() == 1) {
            replaceMap.put("{fullName}", message.getText());
            userBuilderData.replace(chatId, replaceMap);
            sendMessage.setText("Введите ваш адрес");
            messageDocumentMap.put(sendMessage, null);
        } else if (replaceMap.size() == 2) {
            replaceMap.put("{address}", message.getText());
            userBuilderData.replace(chatId, replaceMap);
            sendMessage.setText("Введите Вашу серию паспорта");
            messageDocumentMap.put(sendMessage, null);
        } else if (replaceMap.size() == 3) {
            replaceMap.put("{s}", message.getText());
            userBuilderData.replace(chatId, replaceMap);
            sendMessage.setText("Введите дату выдачи паспорта");
            messageDocumentMap.put(sendMessage, null);
        } else if (replaceMap.size() == 4) {
            replaceMap.put("{date}", message.getText());
            userBuilderData.replace(chatId, replaceMap);
            sendMessage.setText("Введите номер паспорта");
            messageDocumentMap.put(sendMessage, null);
        } else if (replaceMap.size() == 5) {
            replaceMap.put("{numb}", message.getText());
            userBuilderData.replace(chatId, replaceMap);
            sendMessage.setText("Введите Вашу дату рождения");
            messageDocumentMap.put(sendMessage, null);
        } else if (replaceMap.size() == 6) {
            replaceMap.put("{birthday}", message.getText());
            userBuilderData.replace(chatId, replaceMap);
            sendMessage.setText("Кем выдан Ваш паспорт?");
            messageDocumentMap.put(sendMessage, null);
        } else if (replaceMap.size() == 7) {
            replaceMap.put("{vidan}", message.getText());
            userBuilderData.replace(chatId, replaceMap);
            sendMessage.setText("Введите имя гражданина, на чьи похороны Вы просите выделить помощь");
            messageDocumentMap.put(sendMessage, null);
        } else if (replaceMap.size() == 8) {
            replaceMap.put("{dead}", message.getText());
            userBuilderData.replace(chatId, replaceMap);
            sendMessage.setText("Введите дату заполнения в формате дд.мм.гггг");
            messageDocumentMap.put(sendMessage, null);
        } else if (replaceMap.size() == 9) {
            replaceMap.put("{date2}", message.getText());
            userBuilderData.replace(chatId, replaceMap);
            build(userBuilderData.get(chatId), sendDocument, messageDocumentMap, fileName);
            userBuilderData.remove(chatId);
        }
        return messageDocumentMap;
    }

    private void build(Map<String, String> stringStringMap, SendDocument sendDocument, Map<SendMessage, SendDocument> messageDocumentMap, String fileName) throws Exception {
        Replacer replacer = new Replacer();
        File file = replacer.replace(stringStringMap, sendDocument.getChatId(), fileName);
        sendDocument.setDocument(file);
        messageDocumentMap.put(null, sendDocument);
    }
}
