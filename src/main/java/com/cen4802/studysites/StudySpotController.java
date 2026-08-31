package com.cen4802.studysites;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudySpotController {

    @GetMapping("/")
    public String home(
            @RequestParam(required = false) Boolean quietOnly,
            Model model) {

        List<StudySpot> spots = new ArrayList<>();

        spots.add(new StudySpot("Campus Library", "Library", 5));
        spots.add(new StudySpot("Student Center", "Campus", 3));
        spots.add(new StudySpot("Coffee Corner", "Coffee Shop", 4));
        spots.add(new StudySpot("Science Building Lounge", "Campus", 5));

        if (Boolean.TRUE.equals(quietOnly)) {
            spots.removeIf(spot -> spot.getQuietness() < 4);
        }

        model.addAttribute("spots", spots);
        model.addAttribute("quietOnly", quietOnly);

        return "index";
    }
}