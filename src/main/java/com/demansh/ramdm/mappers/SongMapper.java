package com.demansh.ramdm.mappers;

import com.demansh.ramdm.struct.SongResponse;
import com.github.demansh.jamdm.Song;

public interface SongMapper {
    SongResponse toResponse(Song song);
}
