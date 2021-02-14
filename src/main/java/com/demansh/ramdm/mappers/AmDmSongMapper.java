package com.demansh.ramdm.mappers;

import com.demansh.ramdm.struct.AuthorResponse;
import com.demansh.ramdm.struct.SongResponse;
import com.github.demansh.jamdm.Song;
import org.springframework.stereotype.Service;

@Service
public class AmDmSongMapper implements SongMapper {
    private final String TEMPLATE = "<html><head></head><body>" +
            "<h1>%s - %s</h1>" +
            "<br>" +
            "%s" +
            "</body></html>";

    @Override
    public SongResponse toResponse(Song song) {
        return new SongResponse(
                song,
                new AuthorResponse(song.author()),
                song.text());
    }

    @Override
    public String toHtml(Song song) {
        return String.format(
                TEMPLATE,
                song.author().name(),
                song.name(),
                song.text());
    }
}
