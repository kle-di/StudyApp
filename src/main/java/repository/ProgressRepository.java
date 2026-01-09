package repository;

import model.Progress;

import java.util.ArrayList;
import java.util.List;

/**
 * In-memory repository for progress tracking.
 */
public class ProgressRepository {

    private final List<Progress> progressEntries = new ArrayList<>();

    public Progress getOrCreate(String userId) {
        Progress progress = findByUserId(userId);
        if (progress == null) {
            progress = new Progress(userId);
            progressEntries.add(progress);
        }
        return progress;
    }

    public Progress findByUserId(String userId) {
        for (Progress progress : progressEntries) {
            if (progress.getUserId().equals(userId)) {
                return progress;
            }
        }
        return null;
    }

    public List<Progress> findAll() {
        return progressEntries;
    }
}
