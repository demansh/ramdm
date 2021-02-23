package com.demansh.ramdm.songssource.mappers;

import com.demansh.ramdm.songssource.struct.AuthorStruct;
import com.demansh.ramdm.songssource.struct.SongStruct;
import com.github.demansh.jamdm.Author;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class AmDmAuthorMapper implements Mapper<Author, AuthorStruct> {
    @Override
    public AuthorStruct toStruct(Author author) {
        Collection<SongStruct> songs = author.songs()
                .stream()
                .map(SongStruct::new)
                .collect(Collectors.toList());
        return new AuthorStruct(author, songs);
    }
}
