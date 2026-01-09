import model.Course;
import model.Enrollment;
import model.FlashcardDeck;
import model.Material;
import model.Progress;
import model.Topic;
import model.User;
import org.junit.jupiter.api.Test;
import repository.CourseRepository;
import repository.EnrollmentRepository;
import repository.FlashcardDeckRepository;
import repository.MaterialRepository;
import repository.ProgressRepository;
import repository.QuizRepository;
import repository.TopicRepository;
import repository.UserRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RepositorySeedDataTest {

    @Test
    void courseRepositoryHasSeededData() {
        CourseRepository repository = new CourseRepository();
        List<Course> courses = repository.findAll();
        assertEquals(3, courses.size());
        assertEquals("World History", repository.findById(2).getTitle());
        assertNull(repository.findById(999));
    }

    @Test
    void topicRepositoryFindsByCourse() {
        TopicRepository repository = new TopicRepository();
        List<Topic> topics = repository.findByCourseId(1);
        assertEquals(2, topics.size());
        assertNotNull(repository.findById(101));
        assertNull(repository.findById(999));
    }

    @Test
    void materialRepositoryReturnsByTopic() {
        MaterialRepository repository = new MaterialRepository();
        List<Material> materials = repository.findByTopicId(101);
        assertEquals(2, materials.size());
        assertEquals(0, repository.findByTopicId(999).size());
    }

    @Test
    void flashcardDeckRepositoryReturnsDecks() {
        FlashcardDeckRepository repository = new FlashcardDeckRepository();
        List<FlashcardDeck> decks = repository.findByTopicId(101);
        assertEquals(1, decks.size());
        assertEquals(2, decks.get(0).getCards().size());
        assertEquals(0, repository.findByTopicId(999).size());
    }

    @Test
    void quizRepositoryReturnsQuizzes() {
        QuizRepository repository = new QuizRepository();
        assertEquals(1, repository.findByTopicId(101).size());
        assertEquals(1, repository.findByTopicId(201).size());
        assertEquals(0, repository.findByTopicId(999).size());
    }

    @Test
    void userRepositoryHasSeededUsers() {
        UserRepository repository = new UserRepository();
        List<User> users = repository.findAll();
        assertEquals(3, users.size());
        assertEquals("Riley", users.get(2).getName());
        assertNull(repository.findByEmail("missing@example.com"));
    }

    @Test
    void enrollmentRepositoryStoresAndFindsEnrollments() {
        EnrollmentRepository repository = new EnrollmentRepository();
        Enrollment enrollment = repository.enroll("user-1", 1);
        assertNotNull(enrollment);
        assertEquals(1, repository.findByUserId("user-1").size());
        assertNotNull(repository.enroll("user-1", 1));
        assertEquals(0, repository.findByUserId("user-2").size());
        assertFalse(repository.isEnrolled("user-2", 1));
    }

    @Test
    void progressRepositoryCreatesAndFindsProgress() {
        ProgressRepository repository = new ProgressRepository();
        Progress progress = repository.getOrCreate("user-1");
        assertNotNull(progress);
        assertNotNull(repository.findByUserId("user-1"));
        assertEquals(1, repository.findAll().size());
        assertNull(repository.findByUserId("missing"));
    }
}
