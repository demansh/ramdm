package com.demansh.ramdm.songssource.mappers;

import com.demansh.ramdm.songssource.struct.SongResponse;
import com.github.demansh.jamdm.Song;

public interface SongMapper {
    SongResponse toResponse(Song song);
}
