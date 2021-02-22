package com.demansh.ramdm.bot.service;

import com.demansh.ramdm.songssource.mappers.SearchMapper;
import com.demansh.ramdm.songssource.services.SearchService;
import com.demansh.ramdm.songssource.struct.SearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.AnswerInlineQuery;
import org.telegram.telegrambots.meta.api.objects.inlinequery.InlineQuery;

@Component
public class DefaultAnswerService implements AnswerService {
    private final SearchService searchService;
    private final SearchMapper searchMapper;
    private final ResultService resultService;

    @Autowired
    public DefaultAnswerService(
            SearchService searchService,
            SearchMapper searchMapper,
            ResultService resultService) {
        this.searchService = searchService;
        this.searchMapper = searchMapper;
        this.resultService = resultService;
    }

    @Override
    public AnswerInlineQuery toAnswer(InlineQuery inlineQuery, int cacheTime) {
        String query = inlineQuery.getQuery();
        String offset = inlineQuery.getOffset();
        if (offset == null || offset.isEmpty()) {
            offset = "page1";
        }
        SearchResponse searchResult = searchMapper
                .toResponse(searchService.getSearch(query, offset));
        AnswerInlineQuery answerInlineQuery = new AnswerInlineQuery();
        answerInlineQuery.setInlineQueryId(inlineQuery.getId());
        answerInlineQuery.setCacheTime(cacheTime);
        answerInlineQuery.setResults(resultService.toResults(searchResult));
        answerInlineQuery.setNextOffset(incPage(offset));
        return answerInlineQuery;
    }

    private String incPage(String page) {
        return String.format("page%d", Integer.parseInt(page.substring(4)) + 1);
    }
}
