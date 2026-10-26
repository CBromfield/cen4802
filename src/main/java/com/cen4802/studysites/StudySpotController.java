package com.cen4802.studysites;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudySpotController {

    private static final Logger logger =
            LoggerFactory.getLogger(StudySpotController.class);

    private final StudySpotService studySpotService = new StudySpotService();

    @GetMapping("/")
    public String home(
            @RequestParam(required = false) Boolean quietOnly,
            @RequestParam(required = false) String testError,
            Model model) {

        logger.info("Study Spot Finder homepage accessed");

        List<StudySpot> spots = new ArrayList<>();

        spots.add(new StudySpot("Campus Library", "Library", 5));
        spots.add(new StudySpot("Student Center", "Campus", 3));
        spots.add(new StudySpot("Coffee Corner", "Coffee Shop", 4));
        spots.add(new StudySpot("Science Building Lounge", "Campus", 5));

        logger.debug("Loaded {} study spots", spots.size());

        if (Boolean.TRUE.equals(quietOnly)) {
            logger.info("Quiet-study filter applied");

            spots.removeIf(spot ->
                    !studySpotService.isQuietEnough(spot));

            logger.debug("Filtered results contain {} study spots",
                    spots.size());
        }

        if (quietOnly == null) {
            logger.debug("Quiet-study filter was not selected");
        }

        if ("true".equalsIgnoreCase(testError)) {
            logger.warn("Invalid test request received");

            try {
                throw new IllegalArgumentException(
                        "Demonstration error: invalid test request");
            } catch (IllegalArgumentException e) {
                logger.error("Application detected an invalid request", e);
            }
        }

        model.addAttribute("spots", spots);
        model.addAttribute("quietOnly", quietOnly);

        return "index";
    }
}