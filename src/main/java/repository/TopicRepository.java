package repository;

import model.Topic;

import java.util.ArrayList;
import java.util.List;

/**
 * In-memory repository for topics.
 */
public class TopicRepository {

    private final List<Topic> topics = new ArrayList<>();

    public TopicRepository() {
        topics.add(new Topic(101, 1, "Variables and Control Flow", "Types, loops, and branching."));
        topics.add(new Topic(102, 1, "Objects and Classes", "Encapsulation and methods."));

        topics.add(new Topic(201, 2, "Ancient Civilizations", "Mesopotamia, Egypt, and Greece."));
        topics.add(new Topic(202, 2, "Industrial Revolution", "Factories, labor, and innovation."));

        topics.add(new Topic(301, 3, "Arrays and Lists", "Indexed collections and growth."));
        topics.add(new Topic(302, 3, "Trees and Graphs", "Hierarchies and networks."));
    }

    public List<Topic> findAll() {
        return topics;
    }

    public Topic findById(int id) {
        for (Topic topic : topics) {
            if (topic.getId() == id) {
                return topic;
            }
        }
        return null;
    }

    public List<Topic> findByCourseId(int courseId) {
        List<Topic> results = new ArrayList<>();
        for (Topic topic : topics) {
            if (topic.getCourseId() == courseId) {
                results.add(topic);
            }
        }
        return results;
    }
}
