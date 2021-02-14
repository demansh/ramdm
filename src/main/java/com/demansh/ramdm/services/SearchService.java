package com.demansh.ramdm.services;

import com.github.demansh.jamdm.Search;

public interface SearchService {
    Search getSearch(String query, String page);
}
