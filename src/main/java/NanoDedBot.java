import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import processors.MessageProcessor;

public class NanoDedBot extends TelegramLongPollingBot {
    private MessageProcessor messageProcessor;

    public NanoDedBot(MessageProcessor messageProcessor) {
        this.messageProcessor = messageProcessor;
    }

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage = messageProcessor.process(update.getMessage());
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
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
