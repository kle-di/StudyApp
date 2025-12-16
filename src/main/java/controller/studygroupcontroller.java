
package controller;

import service.StudyGroupService;
import model.StudyGroup;
import model.Quizz;

public class studygroupcontroller {

    private final StudyGroupService studyGroupService;

    public studygroupcontroller(StudyGroupService studyGroupService) {
        this.studyGroupService = studyGroupService;
    }

    public StudyGroup createGroup(String name, String description) {
        return studyGroupService.createGroup(name, description);
    }

    public void joinGroup(int groupId, int userId) {
        studyGroupService.joinGroup(groupId, userId);
    }

    public void addQuizzToGroup(StudyGroup group, Quizz quiz) {
        studyGroupService.addQuizzToGroup(group, quiz);
    }
}

