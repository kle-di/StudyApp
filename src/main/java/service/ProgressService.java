package service;

import model.Progress;

import java.util.HashMap;
import java.util.Map;

/**
 * Tracks progress for multiple users.
 */
public class ProgressService {

    private final Map<String, Progress> progressMap = new HashMap<>();

    public ProgressService() {
    }

    private Progress getOrCreate(String userId) {
        return progressMap.computeIfAbsent(userId, Progress::new);
    }

    public void recordFlashcards(String userId, int count) {
        Progress progress = getOrCreate(userId);
        progress.addFlashcards(count);
    }

    public void recordQuizCompletion(String userId) {
        Progress progress = getOrCreate(userId);
        progress.incrementQuizes();
    }

    public Progress getProgress(String userId) {
        return progressMap.get(userId);
    }
}
