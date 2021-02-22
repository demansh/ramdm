package com.demansh.ramdm.songssource.struct;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Collection;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SearchResponse {
    private final Collection<SongResponse> songResponses;

    public SearchResponse(Collection<SongResponse> songResponses) {
        this.songResponses = songResponses;
    }

    public Collection<SongResponse> getResult() {
        return songResponses;
    }
}
