package com.demansh.ramdm.songssource.services;

import com.demansh.ramdm.songssource.mappers.Mapper;
import com.demansh.ramdm.songssource.struct.SearchStruct;
import com.github.demansh.jamdm.Search;
import com.github.demansh.jamdm.amdm.AmDmSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class AmDmSearchService implements SearchService {
    private final Mapper<Search, SearchStruct> searchMapper;

    @Autowired
    public AmDmSearchService(Mapper<Search, SearchStruct> searchMapper) {
        this.searchMapper = searchMapper;
    }

    @Cacheable("searches")
    @Override
    public SearchStruct getSearch(String query, String page) {
        return searchMapper.toStruct(
                new AmDmSearch(query, String.format("page%s",page)));
    }
}
