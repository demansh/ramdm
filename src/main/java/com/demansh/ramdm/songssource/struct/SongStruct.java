package com.demansh.ramdm.songssource.struct;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.demansh.jamdm.Song;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SongStruct implements Serializable {
    private static final long serialVersionUID = -34537571908624770L;
    private final String songName;
    private final String songPathName;
    private final String authorPathName;
    private final String songId;
    private final AuthorStruct authorStruct;
    private final String text;

    public SongStruct(Song song, AuthorStruct authorStruct, String text) {
        this.songName = song.name();
        this.songPathName = song.pathName();
        this.authorPathName = song.author().pathName();
        this.songId = song.id();
        this.authorStruct = authorStruct;
        this.text = text;
    }

    public SongStruct(Song song, AuthorStruct authorStruct) {
        this(song, authorStruct, null);
    }

    public SongStruct(Song song) {
        this(song, null, null);
    }

    public AuthorStruct getAuthor() {
        return authorStruct;
    }

    public String getName() {
        return songName;
    }

    public String getText() {
        return text;
    }

    public String getUri() {
        return String.format("/authors/%s/songs/%s/%s",
                authorPathName,
                songPathName,
                songId);
    }
}
