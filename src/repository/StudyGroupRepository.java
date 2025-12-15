package repository;

import model.StudyGroup;

import java.util.ArrayList;
import java.util.List;

public class StudyGroupRepository {
    private final List<StudyGroup> groups = new ArrayList<>();

    public void add(StudyGroup group) {
        groups.add(group);
    }

    public List<StudyGroup> findAll() {
        return groups;
    }

    public StudyGroup findById(int id) {
        for (StudyGroup g : groups) {
            if (g.getId() == id) return g;
        }
        return null;
    }
}
