package com.cen4802.studysites;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class StudySpotServiceTest {

    private final StudySpotService service = new StudySpotService();

    @Test
    void ratingFiveIsQuietEnough() {
        StudySpot spot = new StudySpot("Campus Library", "Library", 5);

        assertTrue(service.isQuietEnough(spot));
    }

    @Test
    void ratingFourIsQuietEnough() {
        StudySpot spot = new StudySpot("Coffee Corner", "Coffee Shop", 4);

        assertTrue(service.isQuietEnough(spot));
    }

    @Test
    void ratingThreeIsNotQuietEnough() {
        StudySpot spot = new StudySpot("Student Center", "Campus", 3);

        assertFalse(service.isQuietEnough(spot));
    }
}