package com.demansh.ramdm.bot;

import com.demansh.ramdm.bot.service.AnswerService;
import com.demansh.ramdm.config.BotConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.inlinequery.InlineQuery;

import javax.annotation.PostConstruct;

@Component
public class AmDmBot extends TelegramWebhookBot {
    private final AnswerService answerService;
    private final BotConfig botConfig;
    private final RestTemplate restTemplate;

    @Autowired
    public AmDmBot(
            AnswerService answerService,
            BotConfig botConfig,
            RestTemplateBuilder restTemplateBuilder) {
        this.answerService = answerService;
        this.botConfig = botConfig;
        restTemplate = restTemplateBuilder.build();
    }

    @PostConstruct
    public void registerWebhookUrl() {
        String webhookRegistrationUrl = String.format(
                "https://api.telegram.org/bot%s/setWebhook?url=%s",
                botConfig.getToken(),
                botConfig.getWebhookUrl()
        );
        restTemplate.getForObject(webhookRegistrationUrl, Object.class);
    }

    @Override
    public String getBotUsername() {
        return "@chords";
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        InlineQuery inlineQuery = update.getInlineQuery();
        return answerService.toAnswer(inlineQuery, botConfig.getCacheTime());
    }

    @Override
    public String getBotPath() {
        return botConfig.getWebhookUrl();
    }
}
