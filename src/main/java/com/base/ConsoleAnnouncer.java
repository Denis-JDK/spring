package com.base;

public class ConsoleAnnouncer implements Announcer {
    public void announce(String s) {
        System.out.println(s);
    }
}
