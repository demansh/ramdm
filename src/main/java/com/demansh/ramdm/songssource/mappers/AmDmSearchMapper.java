package com.demansh.ramdm.songssource.mappers;

import com.demansh.ramdm.songssource.struct.AuthorStruct;
import com.demansh.ramdm.songssource.struct.SearchStruct;
import com.demansh.ramdm.songssource.struct.SongStruct;
import com.github.demansh.jamdm.Search;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AmDmSearchMapper implements Mapper<Search, SearchStruct> {
    @Override
    public SearchStruct toStruct(Search search) {
        Collection<SongStruct> songResponse = Optional
                .ofNullable(search.result())
                .orElse(Collections.emptyList())
                .stream()
                .map(song -> {
                    var authorResponse = new AuthorStruct(song.author());
                    return new SongStruct(song, authorResponse);
                }).collect(Collectors.toList());
        return new SearchStruct(songResponse);
    }
}
