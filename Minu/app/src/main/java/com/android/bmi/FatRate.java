package com.android.bmi;

public class FatRate {

    //field
    public int color;
    public String state ;
    public String percentage;



    //constructor

    public FatRate(int color, String state, String percentage) {
        this.color = color;
        this.state = state;
        this.percentage = percentage;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

}
