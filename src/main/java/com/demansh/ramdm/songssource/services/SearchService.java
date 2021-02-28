package com.demansh.ramdm.songssource.services;

import com.demansh.ramdm.songssource.struct.SearchStruct;

public interface SearchService {
    SearchStruct getSearch(String query, String page);
}
