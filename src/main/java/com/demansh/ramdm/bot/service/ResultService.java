package com.demansh.ramdm.bot.service;

import com.demansh.ramdm.songssource.struct.SearchStruct;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResult;

import java.util.List;

public interface ResultService {
    List<InlineQueryResult> toResults(SearchStruct searchResult);
}
