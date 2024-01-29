package com.nhnacademy.student;

public enum Gender {
    M("male"),
    F("female");

    private final String label;
    Gender(String label) {
        this.label=label;
    }
    public String getLabel(){return this.label;}
}
