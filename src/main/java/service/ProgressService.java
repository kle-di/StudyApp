package service;

import model.StudyProgress;

import java.util.HashMap;
import java.util.Map;

public class ProgressService {

    private Map<String, StudyProgress> progressMap = new HashMap<>();

    private StudyProgress getOrCreate(String userId) {
        return progressMap.computeIfAbsent(userId, StudyProgress::new);
    }

    public void recordFlashcards(String userId, int count) {
        StudyProgress progress = getOrCreate(userId);
        progress.addFlashcards(count);
    }

    public void recordQuizCompletion(String userId) {
        StudyProgress progress = getOrCreate(userId);
        progress.incrementQuizzes();
    }

    public StudyProgress getProgress(String userId) {
        return progressMap.get(userId);
    }
}
