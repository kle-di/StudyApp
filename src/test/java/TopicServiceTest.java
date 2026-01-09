import model.Topic;
import org.junit.jupiter.api.Test;
import repository.TopicRepository;
import service.TopicService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TopicServiceTest {

    @Test
    void returnsTopicsByCourse() {
        TopicService service = new TopicService(new TopicRepository());

        List<Topic> topics = service.getTopicsByCourse(1);

        assertEquals(2, topics.size());
        assertEquals("Variables and Control Flow", topics.get(0).getTitle());
    }

    @Test
    void returnsNullForUnknownTopic() {
        TopicService service = new TopicService(new TopicRepository());

        assertNull(service.getTopicById(999));
    }
}
