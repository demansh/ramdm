package com.demansh.ramdm.songssource.mappers;

import com.demansh.ramdm.songssource.struct.AuthorResponse;
import com.demansh.ramdm.songssource.struct.SearchResponse;
import com.demansh.ramdm.songssource.struct.SongResponse;
import com.github.demansh.jamdm.Search;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class AmDmSearchMapper implements SearchMapper {
    @Override
    public SearchResponse toResponse(Search search) {
        Collection<SongResponse> songResponses = search.result()
                .stream()
                .map(song -> {
                    var authorResponse = new AuthorResponse(song.author());
                    return new SongResponse(song, authorResponse);
                }).collect(Collectors.toList());
        return new SearchResponse(songResponses);
    }
}
