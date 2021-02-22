package com.demansh.ramdm.songssource.struct;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.demansh.jamdm.Author;

import java.util.Collection;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthorResponse {
    private final Author author;
    private final Collection<SongResponse> songs;

    public AuthorResponse(Author author,
                          Collection<SongResponse> songs) {
        this.author = author;
        this.songs = songs;
    }

    public AuthorResponse(Author author) {
        this(author, null);
    }

    public String getName() {
        return author.name();
    }

    public Collection<SongResponse> getSongs() {
        if (songs == null) {
            return null;
        }
        return songs;
    }

    public String getUri() {
        return String.format("/authors/%s", author.pathName());
    }
}
