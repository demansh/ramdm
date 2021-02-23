package com.demansh.ramdm.songssource.mappers;

public interface Mapper<R, T> {
    T toStruct(R from);
}
