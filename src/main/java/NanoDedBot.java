import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import processors.DocumentBuilder;
import processors.MessageProcessor;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class NanoDedBot extends TelegramLongPollingBot {
    private MessageProcessor messageProcessor;
    private DocumentBuilder documentBuilder;
    private Map<String, Boolean> isBuilder;
    private Map<String, Map<String, String>> userBuilderData;

    NanoDedBot(MessageProcessor messageProcessor) {
        this.messageProcessor = messageProcessor;
        isBuilder = new HashMap<>();
        userBuilderData = new HashMap<>();
        documentBuilder = new DocumentBuilder();
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        String chatId = message.getChatId().toString();
        String fileName = "C:\\dedText\\" + chatId + "output.docx";
        Map<SendMessage, SendDocument> messageSendDocumentMap = new HashMap<>();
        if (!isBuilder.containsKey(chatId)) {
            isBuilder.put(chatId, false);
        }
        if (isBuilder.get(chatId) && message.getText().equals("Назад")) {
            isBuilder.replace(chatId, false);
            userBuilderData.remove(chatId);
        }
        if (isBuilder.get(chatId)) {
            if (!userBuilderData.containsKey(chatId)) {
                userBuilderData.put(chatId, new HashMap<>());
            }
            try {
                messageSendDocumentMap = documentBuilder.buildDoc(message, userBuilderData, fileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            SendMessage sendMessage = messageProcessor.processMessage(message, isBuilder);
            messageSendDocumentMap.put(sendMessage, null);
        }

        for (Map.Entry<SendMessage, SendDocument> entry : messageSendDocumentMap.entrySet()) {
            if (entry.getKey() != null) {
                try {
                    execute(entry.getKey());
                    break;
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (entry.getValue() != null) {
                try {
                    execute(entry.getValue());
                    isBuilder.replace(chatId, false);
                    break;
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
        File file = new File(fileName);
        file.deleteOnExit();
    }

    @Override
    public String getBotUsername() {
        return "NanoDedBot";
    }

    @Override
    public String getBotToken() {
        return "807382426:AAEfAoJknJ1SR3PVK3shfqlD5xzfuhiYrMQ";
    }
}
