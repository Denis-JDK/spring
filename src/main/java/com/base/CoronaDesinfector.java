package com.base;

public class CoronaDesinfector {

    private Announcer announcer = ObjectFactory.getInstance().createObject(Announcer.class);
    private Policeman policeman = ObjectFactory.getInstance().createObject(Policeman.class);

    public void start(Room room){
        announcer.announce("Начинается дезинфекция, все на выход!");
        policeman.makePeopleLeavaRoom();
        desinfect(room);
        announcer.announce("Рискните зайти обратно");
            }
            private void desinfect(Room room){
                System.out.println("зачитывается молитва; 'корона изыди!' - молитва прочитана, вирус прогнали");
            }
}
