package com.demansh.ramdm.songssource.mappers;

import com.demansh.ramdm.songssource.struct.SearchResponse;
import com.github.demansh.jamdm.Search;

public interface SearchMapper {
    SearchResponse toResponse(Search search);
}
