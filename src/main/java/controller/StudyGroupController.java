package controller;

import model.Quiz;
import model.StudyGroup;
import service.StudyGroupService;

/**
 * Controller for study group actions.
 */
public class StudyGroupController {

    private final StudyGroupService studyGroupService;

    public StudyGroupController(StudyGroupService studyGroupService) {
        this.studyGroupService = studyGroupService;
    }

    public StudyGroup createGroup(String name, String description) {
        return studyGroupService.createGroup(name, description);
    }

    public void joinGroup(int groupId, int userId) {
        studyGroupService.joinGroup(groupId, userId);
    }

    public void addQuizToGroup(StudyGroup group, Quiz quiz) {
        studyGroupService.addQuizToGroup(group, quiz);
    }
}

