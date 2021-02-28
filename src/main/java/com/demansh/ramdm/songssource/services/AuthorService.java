package com.demansh.ramdm.songssource.services;

import com.demansh.ramdm.songssource.struct.AuthorStruct;

public interface AuthorService {
    AuthorStruct getAuthor(String authorPathName);
}
