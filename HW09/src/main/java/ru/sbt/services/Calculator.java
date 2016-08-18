package ru.sbt.services;

import ru.sbt.cacheproxy.Cache;

public interface Calculator {
    @Cache
    int calc(int arg1, int arg2);
}
