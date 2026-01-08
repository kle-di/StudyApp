package repository;

import model.Progress;

import java.util.ArrayList;
import java.util.List;

/**
 * In-memory repository for study progress.
 */
public class StudyProgressReposity {

    private final List<Progress> progresses = new ArrayList<>();

    public StudyProgressReposity() {
    }

    public void add(Progress progress) {
        progresses.add(progress);
    }

    public List<Progress> findAll() {
        return progresses;
    }

    public Progress findByUserId(String userId) {
        for (Progress p : progresses) {
            if (p.getUserId().equals(userId)) {
                return p;
            }
        }
        return null;
    }
}
