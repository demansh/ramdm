package com.demansh.ramdm.bot;

import com.demansh.ramdm.bot.service.ResultService;
import com.demansh.ramdm.songssource.mappers.SearchMapper;
import com.demansh.ramdm.songssource.services.SearchService;
import com.demansh.ramdm.songssource.struct.SearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerInlineQuery;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.inlinequery.InlineQuery;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class AmDmBot extends TelegramLongPollingBot {
    private static final Integer CACHETIME = 60;

    private final SearchService searchService;
    private final SearchMapper searchMapper;
    private final ResultService resultService;

    @Autowired
    public AmDmBot(SearchService searchService,
                   SearchMapper searchMapper,
                   ResultService resultService) {
        this.searchService = searchService;
        this.searchMapper = searchMapper;
        this.resultService = resultService;
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
        String query = inlineQuery.getQuery();
        String offset = inlineQuery.getOffset();
        if (offset == null || offset.isEmpty()) {
            offset = "page1";
        }
        SearchResponse searchResult = searchMapper
                .toResponse(searchService.getSearch(query, offset));

        AnswerInlineQuery answerInlineQuery = new AnswerInlineQuery();
        answerInlineQuery.setInlineQueryId(inlineQuery.getId());
        answerInlineQuery.setCacheTime(CACHETIME);
        answerInlineQuery.setResults(resultService.toResults(searchResult));
        answerInlineQuery.setNextOffset("page2");
        try {
            sendApiMethod(answerInlineQuery);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
