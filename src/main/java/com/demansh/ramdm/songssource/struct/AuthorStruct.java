package com.demansh.ramdm.songssource.struct;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.demansh.jamdm.Author;

import java.io.Serializable;
import java.util.Collection;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthorStruct implements Serializable {
    private static final long serialVersionUID = 5098970251992320524L;
    private final String authorName;
    private final String authorPathName;
    private final Collection<SongStruct> songs;

    public AuthorStruct(Author author, Collection<SongStruct> songs) {
        this.authorName = author.name();
        this.authorPathName = author.name();
        this.songs = songs;
    }

    public AuthorStruct(Author author) {
        this(author, null);
    }

    public String getName() {
        return authorName;
    }

    public Collection<SongStruct> getSongs() {
        if (songs == null) {
            return null;
        }
        return songs;
    }

    public String getUri() {
        return String.format("/authors/%s", authorPathName);
    }
}
