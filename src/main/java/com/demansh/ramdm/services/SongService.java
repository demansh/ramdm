package com.demansh.ramdm.services;

import com.github.demansh.jamdm.Song;

public interface SongService {
    Song getSong(String id, String pathName, String authorPathName);
}
