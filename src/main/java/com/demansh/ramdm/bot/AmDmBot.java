package com.demansh.ramdm.bot;

import com.demansh.ramdm.bot.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.inlinequery.InlineQuery;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class AmDmBot extends TelegramLongPollingBot {
    private static final Integer CACHE_TIME = 60;

    private final AnswerService answerService;

    @Autowired
    public AmDmBot(AnswerService answerService) {
        this.answerService = answerService;
    }


    @Override
    public String getBotUsername() {
        return "Guitar chords";
    }

    @Override
    public String getBotToken() {
        return "1652833608:AAH6yzZ61sYfSDgrRSTL5i4IPJn6cvUirwQ";
    }

    @Override
    public void onUpdateReceived(Update update) {
        InlineQuery inlineQuery = update.getInlineQuery();
        try {
            sendApiMethod(answerService.toAnswer(inlineQuery, CACHE_TIME));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
