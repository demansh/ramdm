package com.demansh.ramdm.controllers;

import com.demansh.ramdm.songssource.services.AuthorService;
import com.demansh.ramdm.songssource.struct.AuthorStruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("authors")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("/{authorPathName}")
    public String getAuthor(@PathVariable String authorPathName, Model model) {
        AuthorStruct author = authorService.getAuthor(authorPathName);
        model.addAttribute("songs", author.getSongs());
        model.addAttribute("authorName", author.getName());
        return "author-template";
    }
}
