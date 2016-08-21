package ru.sbt.services;

import ru.sbt.cacheproxy.Cache;
import ru.sbt.cacheproxy.CacheType;

import java.util.List;

public interface ListGenerator {
    @Cache(cacheType = CacheType.IN_MEMORY, listSize = 10)
    List<Integer> generate(int  count);
}
