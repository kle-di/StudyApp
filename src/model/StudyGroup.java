package model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class StudyGroup {

    private String id;
    private String name;
    private Set<String> memberIds;

    public StudyGroup(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.memberIds = new HashSet<>();
    }

    public void addMember(User user) {
        memberIds.add(user.getId());
    }

    public boolean isMember(User user) {
        return memberIds.contains(user.getId());
    }

    public String getName() {
        return name;
    }
}
