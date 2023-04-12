package com.parim.model;

public class Time {
    private static int sec = 0;

    public static void updateSec(){
        sec++;
    }
    public static int getSec() {
        return sec;
    }

    public static void setSec(int sec) {
        Time.sec = sec;
    }
}
