package com.androidlec.quiz8;

public class ManU {


    // Field
    private String back;
    private int icon;
    private String comment;
    private String nation;
    private int icon1;
    private String age;
    private String name;
    private String game;


    // Constructor


//    public ManU(String back, int icon, String comment,int icon1) {
//        this.back = back;
//        this.icon = icon;
//        this.comment = comment;
//        this.icon1 = icon1;
//    }

    public ManU(String back, int icon, String comment, int icon1, String age, String name, String game) {
        this.back = back;
        this.icon = icon;
        this.comment = comment;
        this.icon1 = icon1;
        this.age = age;
        this.name = name;
        this.game = game;
    }

    public ManU() {

    }


    // getter setter

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public int getIcon1() {
        return icon1;
    }

    public void setIcon1(int icon1) {
        this.icon1 = icon1;
    }
}





