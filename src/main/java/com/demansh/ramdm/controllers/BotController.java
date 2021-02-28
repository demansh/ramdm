package com.demansh.ramdm.controllers;

import com.demansh.ramdm.bot.AmDmBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
@RequestMapping("webhook")
public class BotController {
    private final AmDmBot bot;

    @Autowired
    public BotController(AmDmBot bot) {
        this.bot = bot;
    }

    @PostMapping
    public BotApiMethod<?> getBotResponse(@RequestBody Update update) {
        return bot.onWebhookUpdateReceived(update);
    }
}
