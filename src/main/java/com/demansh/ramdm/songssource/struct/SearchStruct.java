package com.demansh.ramdm.songssource.struct;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Collection;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SearchStruct implements Serializable {
    private static final long serialVersionUID = -7316794772120959641L;
    private final Collection<SongStruct> songResponse;

    public SearchStruct(Collection<SongStruct> songResponse) {
        this.songResponse = songResponse;
    }

    public Collection<SongStruct> getResult() {
        return songResponse;
    }
}
