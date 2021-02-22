package com.demansh.ramdm.songssource.mappers;

import com.demansh.ramdm.songssource.struct.AuthorResponse;
import com.demansh.ramdm.songssource.struct.SongResponse;
import com.github.demansh.jamdm.Song;
import org.springframework.stereotype.Service;

@Service
public class AmDmSongMapper implements SongMapper {
    @Override
    public SongResponse toResponse(Song song) {
        return new SongResponse(
                song,
                new AuthorResponse(song.author()),
                song.text());
    }
}
