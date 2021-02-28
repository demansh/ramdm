package com.demansh.ramdm.controllers;

import com.demansh.ramdm.songssource.services.SongService;
import com.demansh.ramdm.songssource.struct.SongStruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("authors/{authorPathName}/songs")
public class SongController {
    private final SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("/{pathName}/{id}")
    public String getSong(
            @PathVariable String authorPathName,
            @PathVariable String pathName,
            @PathVariable String id,
            Model model) {
        SongStruct song = songService.getSong(id, pathName, authorPathName);
        model.addAttribute("authorName", song.getAuthor().getName());
        model.addAttribute("authorUri", song.getAuthor().getUri());
        model.addAttribute("songName", song.getName());
        model.addAttribute("songText", song.getText());
        return "song-template";
    }
}
