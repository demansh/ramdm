package com.demansh.ramdm.songssource.struct;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Collection;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SearchStruct {
    private final Collection<SongStruct> songRespons;

    public SearchStruct(Collection<SongStruct> songRespons) {
        this.songRespons = songRespons;
    }

    public Collection<SongStruct> getResult() {
        return songRespons;
    }
}
