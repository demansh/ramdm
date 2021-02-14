package com.demansh.ramdm.controllers;

import com.demansh.ramdm.mappers.SongMapper;
import com.demansh.ramdm.services.SongService;
import com.demansh.ramdm.struct.SongResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping("api/v1/authors/{authorPathName}/songs")
public class SongController {
    private final SongService songService;
    private final SongMapper songMapper;

    @Autowired
    public SongController(SongService songService, SongMapper songMapper) {
        this.songService = songService;
        this.songMapper = songMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("/{pathName}/{id}")
    public SongResponse getSong(
            @PathVariable String authorPathName,
            @PathVariable String pathName,
            @PathVariable String id) {
        return songMapper.toResponse(
                songService.getSong(id, pathName, authorPathName)
        );
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("/{pathName}/{id}/html")
    public String getHtmlSong(
            @PathVariable String authorPathName,
            @PathVariable String pathName,
            @PathVariable String id) {
        return songMapper
                .toHtml(songService.getSong(id, pathName, authorPathName));
    }
}
