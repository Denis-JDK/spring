package com.base;

public interface Config {
    <T> Class<? extends T> getImplClass(Class<T> ifc); //приходит интерфейс
}
