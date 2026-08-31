package com.cen4802.studysites;

public class StudySpot {

    private String name;
    private String type;
    private int quietness;

    public StudySpot(String name, String type, int quietness) {
        this.name = name;
        this.type = type;
        this.quietness = quietness;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getQuietness() {
        return quietness;
    }
}