package com.demansh.ramdm.songssource.struct;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.demansh.jamdm.Song;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SongStruct {
    private final Song song;
    private final AuthorStruct authorStruct;
    private final String text;

    public SongStruct(Song song, AuthorStruct authorStruct, String text) {
        this.song = song;
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
        return song.name();
    }

    public String getText() {
        return text;
    }

    public String getUri() {
        return String.format("/authors/%s/songs/%s/%s",
                song.author().pathName(),
                song.pathName(),
                song.id());
    }
}
