package com.cen4802.studysites;

public class StudySpotService {

    public boolean isQuietEnough(StudySpot spot) {
    	return spot.getQuietness() >= 4;
    }
}