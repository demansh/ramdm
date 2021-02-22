package com.demansh.ramdm.songssource.mappers;

import com.demansh.ramdm.songssource.struct.AuthorResponse;
import com.github.demansh.jamdm.Author;

public interface AuthorMapper {
    AuthorResponse toResponse(Author author);
}
