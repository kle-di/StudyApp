package repository;

import model.StudyProgress;

import java.util.ArrayList;
import java.util.List;

public class StudyProgressReposity {

    private final List<StudyProgress> progresses = new ArrayList<>();

    public void add(StudyProgress progress) {
        progresses.add(progress);
    }

    public List<StudyProgress> findAll() {
        return progresses;
    }

    public StudyProgress findByUserAndQuizz(int userId, int quizzId) {
        for (StudyProgress p : progresses) {
            if (p.getUserId() == userId && p.getQuizzId() == quizzId) {
                return p;
            }
        }
        return null;
    }
}
