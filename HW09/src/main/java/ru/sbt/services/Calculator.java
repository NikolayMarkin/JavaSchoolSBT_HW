package ru.sbt.services;

import ru.sbt.cacheproxy.Cache;
import ru.sbt.cacheproxy.CacheType;

public interface Calculator {
    @Cache(cacheType = CacheType.FILE, fileNamePrefix = "cache_calc", zip=true, identityBy = {0, 2})
    int calc(String name, int arg1, int arg2);
}
