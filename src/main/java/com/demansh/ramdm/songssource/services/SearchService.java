package com.demansh.ramdm.songssource.services;

import com.github.demansh.jamdm.Search;

public interface SearchService {
    Search getSearch(String query, String page);
}
