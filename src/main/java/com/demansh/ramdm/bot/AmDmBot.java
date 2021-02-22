package com.demansh.ramdm.bot;

import com.demansh.ramdm.services.SearchService;
import com.github.demansh.jamdm.Author;
import com.github.demansh.jamdm.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerInlineQuery;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.inlinequery.InlineQuery;
import org.telegram.telegrambots.meta.api.objects.inlinequery.inputmessagecontent.InputTextMessageContent;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResult;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResultArticle;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class AmDmBot extends TelegramLongPollingBot {
    private static final Integer CACHETIME = 60;

    private final SearchService searchService;

    @Autowired
    public AmDmBot(SearchService searchService) {
        this.searchService = searchService;
    }


    @Override
    public String getBotUsername() {
        return "AmDm";
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
        System.out.println(query);
        System.out.println(offset);
        if (offset == null || offset.isEmpty()) {
            offset = "page1";
        }

        var results = searchService.getSearch(query, offset).result();

        AnswerInlineQuery answerInlineQuery = new AnswerInlineQuery();
        answerInlineQuery.setInlineQueryId(inlineQuery.getId());
        answerInlineQuery.setCacheTime(CACHETIME);
        answerInlineQuery.setResults(convertRaeResults(results));
        answerInlineQuery.setNextOffset("page2");
        try {
            sendApiMethod(answerInlineQuery);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private static List<InlineQueryResult> convertRaeResults(Collection<Song> songs) {
        List<InlineQueryResult> results = new ArrayList<>();

        int c = 0;
        for (Song song : songs) {
            InputTextMessageContent messageContent = new InputTextMessageContent();
            messageContent.setDisableWebPagePreview(false);
            String songName = song.name();
            String songPathName = song.pathName();
            String songId = song.id();
            Author author = song.author();
            String authorPathName = song.author().pathName();
            String authorName = song.author().name();
            messageContent.setMessageText(String.format(
                    "<a href=\"https://ramdm.herokuapp.com/%s",
                    String.format("api/v1/authors/%s/songs/%s/%s/html\">%s - %s</a>",
                            authorPathName,
                            songPathName,
                            songId,
                            authorName,
                            songName)
            ));
            messageContent.setParseMode("HTML");
            InlineQueryResultArticle article = new InlineQueryResultArticle();
            article.setInputMessageContent(messageContent);
            article.setId(Integer.toString(c));
            article.setTitle(song.author().name() + " - " + song.name());
            article.setHideUrl(false);
//            article.setUrl();
            results.add(article);
            c++;
        }
        return results;
    }
}
