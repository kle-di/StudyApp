package model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class StudyGroup {
    private int id;
    private String name;
    private String description;

    public StudyGroup(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
}
