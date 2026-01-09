package service;

import model.Progress;
import repository.ProgressRepository;

/**
 * Progress operations over the repository.
 */
public class ProgressService {

    private final ProgressRepository progressRepository;

    public ProgressService(ProgressRepository progressRepository) {
        this.progressRepository = progressRepository;
    }

    public Progress getProgress(String userId) {
        return progressRepository.getOrCreate(userId);
    }

    public void recordTopicVisit(String userId) {
        progressRepository.getOrCreate(userId).recordTopicVisit();
    }

    public void recordFlashcardsReviewed(String userId, int count) {
        progressRepository.getOrCreate(userId).addFlashcardsReviewed(count);
    }

    public void recordQuizResult(String userId, int correct, int total) {
        progressRepository.getOrCreate(userId).recordQuizResult(correct, total);
    }
}
