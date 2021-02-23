package com.demansh.ramdm.songssource.struct;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.demansh.jamdm.Author;

import java.util.Collection;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthorStruct {
    private final Author author;
    private final Collection<SongStruct> songs;

    public AuthorStruct(Author author,
                        Collection<SongStruct> songs) {
        this.author = author;
        this.songs = songs;
    }

    public AuthorStruct(Author author) {
        this(author, null);
    }

    public String getName() {
        return author.name();
    }

    public Collection<SongStruct> getSongs() {
        if (songs == null) {
            return null;
        }
        return songs;
    }

    public String getUri() {
        return String.format("/authors/%s", author.pathName());
    }
}
