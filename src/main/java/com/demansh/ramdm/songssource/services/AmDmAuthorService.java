package com.demansh.ramdm.songssource.services;

import com.github.demansh.jamdm.Author;
import com.github.demansh.jamdm.amdm.AmDmAuthor;
import org.springframework.stereotype.Service;

@Service
public class AmDmAuthorService implements AuthorService {
    @Override
    public Author getAuthor(String authorPathName) {
        return new AmDmAuthor(authorPathName);
    }
}
