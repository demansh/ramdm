package com.demansh.ramdm.mappers;

import com.demansh.ramdm.struct.AuthorResponse;
import com.github.demansh.jamdm.Author;

public interface AuthorMapper {
    AuthorResponse toResponse(Author author);
}
