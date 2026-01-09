package controller;

import model.Topic;
import service.TopicService;

import java.util.List;

/**
 * Controller for topic actions.
 */
public class TopicController {

    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    public List<Topic> listTopicsByCourse(int courseId) {
        return topicService.getTopicsByCourse(courseId);
    }

    public Topic getTopicById(int id) {
        return topicService.getTopicById(id);
    }
}
