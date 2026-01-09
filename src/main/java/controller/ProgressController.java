package controller;

import model.Progress;
import service.ProgressService;

/**
 * Controller for progress actions.
 */
public class ProgressController {

    private final ProgressService progressService;

    public ProgressController(ProgressService progressService) {
        this.progressService = progressService;
    }

    public Progress getProgress(String userId) {
        return progressService.getProgress(userId);
    }

    public void recordTopicVisit(String userId) {
        progressService.recordTopicVisit(userId);
    }

    public void recordFlashcardsReviewed(String userId, int count) {
        progressService.recordFlashcardsReviewed(userId, count);
    }

    public void recordQuizResult(String userId, int correct, int total) {
        progressService.recordQuizResult(userId, correct, total);
    }
}
