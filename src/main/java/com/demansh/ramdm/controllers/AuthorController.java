package com.demansh.ramdm.controllers;

import com.demansh.ramdm.mappers.AuthorMapper;
import com.demansh.ramdm.services.AuthorService;
import com.demansh.ramdm.struct.AuthorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping("api/v1/authors")
public class AuthorController {
    private final AuthorService authorService;
    private final AuthorMapper authorMapper;

    @Autowired
    public AuthorController(
            AuthorService authorService,
            AuthorMapper authorMapper) {
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("/{authorPathName}")
    public AuthorResponse getSong(@PathVariable String authorPathName) {
        return authorMapper.toResponse(authorService.getAuthor(authorPathName));
    }
}
