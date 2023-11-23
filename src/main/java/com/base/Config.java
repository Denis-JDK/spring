package com.base;

import org.reflections.Reflections;

public interface Config {
    <T> Class<? extends T> getImplClass(Class<T> ifc); //приходит интерфейс

    Reflections getScanner();


}
