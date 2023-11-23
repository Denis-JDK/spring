package com.base;

import org.reflections.Reflections;

import java.util.Set;

public class JavaConfig implements Config{

    private Reflections scanner; //подтянули зависимость в мавен

    public JavaConfig(String packageToScan){this.scanner=new Reflections(packageToScan);} //настроили сканеры на нужный пакет и можем с файлами работать из пакета
    @Override
    public <T> Class<? extends T> getImplClass(Class<T> ifc) {
        Set<Class<? extends T>> classes = scanner.getSubTypesOf(ifc); // и возвращаем нужную имплементацию интерфейса
        if (classes.size() !=1){
            throw new RuntimeException(ifc + " has 0 or more than one impl");
        }
        return classes.iterator().next();
    }
}
