package com.base;

import lombok.SneakyThrows;

public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig("com.base");

    public static ObjectFactory getInstance(){
        return ourInstance;
    }

    private ObjectFactory(){

    }

    @SneakyThrows
    public <T> T createObject(Class<T> type){
        Class<? extends T> implClass = type;
        if (type.isInterface()){
            implClass = config.getImplClass(type);
        }
                T t = implClass.getDeclaredConstructor().newInstance();
        //todo
        return t;
    }
}
