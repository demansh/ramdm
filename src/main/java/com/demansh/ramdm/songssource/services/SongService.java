package com.demansh.ramdm.songssource.services;

import com.demansh.ramdm.songssource.struct.SongStruct;

public interface SongService {
    SongStruct getSong(String id, String pathName, String authorPathName);
}
