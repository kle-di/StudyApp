// service/StudyGroupService.java
package service;

import model.StudyGroup;
import repository.StudyGroupRepository;

import java.util.*;

public class StudyGroupService {

    private final StudyGroupRepository groupRepository;

    // groupId -> memberUserIds
    private final Map<Integer, Set<Integer>> members = new HashMap<>();
    private int nextGroupId = 1;

    public StudyGroupService(StudyGroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public StudyGroup createGroup(String name, String description) {
        StudyGroup group = new StudyGroup(nextGroupId++, name, description);
        groupRepository.add(group);
        members.put(group.getId(), new HashSet<>());
        return group;
    }

    public void joinGroup(int groupId, int userId) {
        if (groupRepository.findById(groupId) == null) throw new IllegalArgumentException("Group not found");
        members.computeIfAbsent(groupId, k -> new HashSet<>()).add(userId);
    }

    public Set<Integer> getMembers(int groupId) {
        return Collections.unmodifiableSet(members.getOrDefault(groupId, Collections.emptySet()));
    }
}
