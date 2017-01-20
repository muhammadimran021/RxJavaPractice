package com.example.muhammad.practiceapp;

/**
 * Created by Muhammad on 1/20/2017.
 */

public class model {


    public static int Adimn = 0;
    public static int Moderator = 1;
    public static int Guest = 2;


    private int level;
    private String name;

    public model(int level, String name) {
        this.level = level;
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
