package com.demansh.ramdm.struct;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.demansh.jamdm.Song;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SongResponse {
    private final Song song;
    private final AuthorResponse authorResponse;
    private final String text;

    public SongResponse(Song song, AuthorResponse authorResponse, String text) {
        this.song = song;
        this.authorResponse = authorResponse;
        this.text = text;
    }

    public SongResponse(Song song, AuthorResponse authorResponse) {
        this(song, authorResponse, null);
    }

    public SongResponse(Song song) {
        this(song, null, null);
    }

    public AuthorResponse getAuthor() {
        return authorResponse;
    }

    public String getName() {
        return song.name();
    }

    public String[] getLines() {
        return text == null ? null : text.split("\n");
    }

    public String getUri() {
        return String.format("api/v1/authors/%s/songs/%s/%s",
                song.author().pathName(),
                song.pathName(),
                song.id());
    }

    public String getHtml() {
        return String.format("api/v1/authors/%s/songs/%s/%s/html",
                song.author().pathName(),
                song.pathName(),
                song.id());
    }
}
