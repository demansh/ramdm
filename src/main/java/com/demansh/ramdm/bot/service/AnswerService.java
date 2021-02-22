package com.demansh.ramdm.bot.service;

import org.telegram.telegrambots.meta.api.methods.AnswerInlineQuery;
import org.telegram.telegrambots.meta.api.objects.inlinequery.InlineQuery;

public interface AnswerService {
    AnswerInlineQuery toAnswer(InlineQuery inlineQuery, int cacheTime);
}
