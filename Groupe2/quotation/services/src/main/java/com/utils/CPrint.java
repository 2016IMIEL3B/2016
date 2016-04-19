package com.utils;

/**
 * Created by tlemaillet on 23/03/16 for com.group.two.root.
 */
public class CPrint {
    private static char escape = 27;
    private static String reset = "[0m";

    public static void red(String s){
        System.out.println(escape + "[31m" + s + escape + reset);
    }
    public static void cyan(String s){
        System.out.println(escape + "[36m" + s + escape + reset);
    }
    public static void green(String s){
        System.out.println(escape + "[32m" + s + escape + reset);
    }


}
