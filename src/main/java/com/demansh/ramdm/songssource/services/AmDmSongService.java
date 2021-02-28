package com.demansh.ramdm.songssource.services;

import com.demansh.ramdm.songssource.mappers.Mapper;
import com.demansh.ramdm.songssource.struct.SongStruct;
import com.github.demansh.jamdm.Song;
import com.github.demansh.jamdm.amdm.AmDmSong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class AmDmSongService implements SongService {
    private final Mapper<Song, SongStruct> songMapper;

    @Autowired
    public AmDmSongService(Mapper<Song, SongStruct> songMapper) {
        this.songMapper = songMapper;
    }

    @Cacheable("songs")
    @Override
    public SongStruct getSong(
            String id,
            String pathName,
            String authorPathName) {
        return songMapper.toStruct(new AmDmSong(id, pathName, authorPathName));
    }
}
