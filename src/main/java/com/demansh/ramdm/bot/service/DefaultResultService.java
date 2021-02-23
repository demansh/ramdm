package com.demansh.ramdm.bot.service;

import com.demansh.ramdm.songssource.struct.SearchStruct;
import com.demansh.ramdm.songssource.struct.SongStruct;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.inlinequery.inputmessagecontent.InputTextMessageContent;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResult;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResultArticle;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultResultService implements ResultService {
    private static final String ROOT = System.getenv("ROOT_URL");

    @Override
    public List<InlineQueryResult> toResults(SearchStruct searchResult) {
        List<InlineQueryResult> results = new ArrayList<>();
        int c = 0;
        for (SongStruct song : searchResult.getResult()) {
            InputTextMessageContent messageContent = new InputTextMessageContent();
            messageContent.setDisableWebPagePreview(false);
            messageContent.setMessageText(String.format(
                    "<a href=\"%s%s\">%s - %s</a>",
                    ROOT,
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
