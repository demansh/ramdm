package com.demansh.ramdm.mappers;

import com.demansh.ramdm.struct.SearchResponse;
import com.github.demansh.jamdm.Search;

public interface SearchMapper {
    SearchResponse toResponse(Search search);
}
