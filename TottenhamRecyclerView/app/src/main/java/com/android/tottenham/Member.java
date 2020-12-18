package com.android.tottenham;

public class Member {
    private String member;
    private int icon;
    private String number;

    public Member(String member, int icon, String number) {
        this.member = member;
        this.icon = icon;
        this.number = number;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
