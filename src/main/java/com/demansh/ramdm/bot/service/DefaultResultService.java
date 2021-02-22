package com.demansh.ramdm.bot.service;

import com.demansh.ramdm.songssource.struct.SearchResponse;
import com.demansh.ramdm.songssource.struct.SongResponse;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.inlinequery.inputmessagecontent.InputTextMessageContent;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResult;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResultArticle;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultResultService implements ResultService {
    @Override
    public List<InlineQueryResult> toResults(SearchResponse searchResult) {
        List<InlineQueryResult> results = new ArrayList<>();
        int c = 0;
        for (SongResponse song : searchResult.getResult()) {
            InputTextMessageContent messageContent = new InputTextMessageContent();
            messageContent.setDisableWebPagePreview(false);
            messageContent.setMessageText(String.format(
                    "<a href=\"https://ramdm.herokuapp.com%s\">%s - %s</a>",
                    song.getUri(),
                    song.getAuthor().getName(),
                    song.getName()));
            messageContent.setParseMode("HTML");
            InlineQueryResultArticle article = new InlineQueryResultArticle();
            article.setInputMessageContent(messageContent);
            article.setId(Integer.toString(c));
            article.setTitle(String.format(
                    "%s - %s",
                    song.getAuthor().getName(),
                    song.getName()));
            article.setHideUrl(false);
            results.add(article);
            c++;
        }
        return results;
    }
}
