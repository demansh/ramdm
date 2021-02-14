package com.demansh.ramdm.controllers;

import com.demansh.ramdm.mappers.SearchMapper;
import com.demansh.ramdm.services.SearchService;
import com.demansh.ramdm.struct.SearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping("api/v1/search")
public class SearchController {
    private final SearchService searchService;
    private final SearchMapper searchMapper;

    @Autowired
    public SearchController(
            SearchService searchService,
            SearchMapper searchMapper) {
        this.searchService = searchService;
        this.searchMapper = searchMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public SearchResponse getSearch(
            @RequestParam(name = "q") String query,
            @RequestParam(name = "page", defaultValue = "1") String page) {
        return searchMapper.toResponse(searchService.getSearch(query, page));
    }
}
