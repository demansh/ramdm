package com.demansh.ramdm.services;

import com.github.demansh.jamdm.Search;
import com.github.demansh.jamdm.amdm.AmDmSearch;
import org.springframework.stereotype.Service;

@Service
public class AmDmSearchService implements SearchService {
    @Override
    public Search getSearch(String query, String page) {
        return new AmDmSearch(query, String.format("page%s",page));
    }
}
