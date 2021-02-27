package com.demansh.ramdm.songssource.services;

import com.github.demansh.jamdm.Search;
import com.github.demansh.jamdm.amdm.AmDmSearch;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class AmDmSearchService implements SearchService {
    @Cacheable("searches")
    @Override
    public Search getSearch(String query, String page) {
        return new AmDmSearch(query, String.format("page%s",page));
    }
}
