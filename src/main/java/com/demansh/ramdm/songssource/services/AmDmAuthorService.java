package com.demansh.ramdm.songssource.services;

import com.demansh.ramdm.songssource.mappers.Mapper;
import com.demansh.ramdm.songssource.struct.AuthorStruct;
import com.github.demansh.jamdm.Author;
import com.github.demansh.jamdm.amdm.AmDmAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class AmDmAuthorService implements AuthorService {
    private final Mapper<Author, AuthorStruct> authorMapper;

    @Autowired
    public AmDmAuthorService(Mapper<Author, AuthorStruct> authorMapper) {
        this.authorMapper = authorMapper;
    }

    @Cacheable("authors")
    @Override
    public AuthorStruct getAuthor(String authorPathName) {
        return authorMapper.toStruct(new AmDmAuthor(authorPathName));
    }
}
