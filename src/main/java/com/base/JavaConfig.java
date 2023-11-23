package com.base;

import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;

public class JavaConfig implements Config{

    private Reflections scanner; //подтянули зависимость в мавен
    private Map<Class, Class> ifc2ImplClass;

    public JavaConfig(String packageToScan, Map<Class, Class> ifc2ImplClass){
        this.ifc2ImplClass = ifc2ImplClass;
        this.scanner=new Reflections(packageToScan);} //настроили сканеры на нужный пакет и можем с файлами работать из пакета
    @Override
    public <T> Class<? extends T> getImplClass(Class<T> ifc) {
       return ifc2ImplClass.computeIfAbsent(ifc, aClass -> {
            Set<Class<? extends T>> classes = scanner.getSubTypesOf(ifc); // и возвращаем нужную имплементацию интерфейса
            if (classes.size() !=1){
                throw new RuntimeException(ifc + " has 0 or more than one impl please update your config");
            }
            return classes.iterator().next();
        });

    }
}
