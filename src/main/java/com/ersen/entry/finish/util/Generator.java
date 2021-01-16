package com.ersen.entry.finish.util;

import java.util.Random;

public class Generator {

    private final static String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String randomWord(int count) {
        StringBuilder word = new StringBuilder();
        Random rnd = new Random();
        for (int i = 0; i < count; i++) {
            word.append(LETTERS.charAt(rnd.nextInt(LETTERS.length())));
        }
        return word.toString();
    }

    public static void main(String[] args) {
        System.out.println(randomWord(5));
    }
}
