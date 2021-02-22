package com.demansh.ramdm.controllers;

import com.demansh.ramdm.mappers.AuthorMapper;
import com.demansh.ramdm.services.AuthorService;
import com.demansh.ramdm.struct.AuthorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("authors")
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
    public String getAuthor(@PathVariable String authorPathName, Model model) {
        AuthorResponse author = authorMapper
                .toResponse(authorService.getAuthor(authorPathName));
        model.addAttribute("songs", author.getSongs());
        model.addAttribute("authorName", author.getName());
        return "author-template";
    }
}
