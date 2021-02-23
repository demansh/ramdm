package com.demansh.ramdm.songssource.mappers;

import com.demansh.ramdm.songssource.struct.AuthorStruct;
import com.demansh.ramdm.songssource.struct.SongStruct;
import com.github.demansh.jamdm.Song;
import org.springframework.stereotype.Service;

@Service
public class AmDmSongMapper implements Mapper<Song, SongStruct> {
    @Override
    public SongStruct toStruct(Song song) {
        return new SongStruct(
                song,
                new AuthorStruct(song.author()),
                song.text());
    }
}
