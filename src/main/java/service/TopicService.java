package service;

import model.Topic;
import repository.TopicRepository;

import java.util.List;

/**
 * Topic operations over the repository.
 */
public class TopicService {

    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public List<Topic> getTopicsByCourse(int courseId) {
        return topicRepository.findByCourseId(courseId);
    }

    public Topic getTopicById(int id) {
        return topicRepository.findById(id);
    }
}
