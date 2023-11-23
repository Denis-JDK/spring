package com.base;

import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;

public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config;

    public static ObjectFactory getInstance(){
        return ourInstance;
    }

    private ObjectFactory(){ //настройка не в коде а как бы в конфигурации которую мы можем передавать на исполнение с разной имплементацией интерфейса policeman
      config =  new JavaConfig("com.base", new HashMap<>(Map.of(Policeman.class, AngryPoliceman.class)));
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
