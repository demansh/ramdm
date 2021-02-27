package com.demansh.ramdm.songssource.services;

import com.github.demansh.jamdm.Song;
import com.github.demansh.jamdm.amdm.AmDmSong;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class AmDmSongService implements SongService {
    @Cacheable("songs")
    @Override
    public Song getSong(String id, String pathName, String authorPathName) {
        return new AmDmSong(id, pathName, authorPathName);
    }
}
