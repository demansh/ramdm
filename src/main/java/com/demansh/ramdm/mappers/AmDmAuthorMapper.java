package com.demansh.ramdm.mappers;

import com.demansh.ramdm.struct.AuthorResponse;
import com.demansh.ramdm.struct.SongResponse;
import com.github.demansh.jamdm.Author;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class AmDmAuthorMapper implements AuthorMapper {
    @Override
    public AuthorResponse toResponse(Author author) {
        Collection<SongResponse> songs = author.songs()
                .stream()
                .map(SongResponse::new)
                .collect(Collectors.toList());
        return new AuthorResponse(author, songs);
    }
}
