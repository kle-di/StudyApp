import model.Course;
import model.Enrollment;
import model.FlashcardDeck;
import model.Material;
import model.Progress;
import model.Quiz;
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
import service.CourseService;
import service.EnrollmentService;
import service.FlashcardService;
import service.MaterialService;
import service.ProgressService;
import service.QuizService;
import service.TopicService;
import service.UserService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServiceDirectoryTest {

    @Test
    void courseServiceCoversLookups() {
        CourseService service = new CourseService(new CourseRepository());
        List<Course> courses = service.getAllCourses();
        assertEquals(3, courses.size());
        assertEquals("Java Fundamentals", service.getCourseById(1).getTitle());
        assertNull(service.getCourseById(999));
    }
    @Test
    void enrollmentServiceCoversEnrollments() {
        EnrollmentService service = new EnrollmentService(new EnrollmentRepository());
        Enrollment first = service.enroll("user-1", 1);
        Enrollment second = service.enroll("user-1", 1);
        assertNotNull(first);
        assertNotNull(second);
        assertEquals(first.getId(), second.getId());
        assertTrue(service.isEnrolled("user-1", 1));
        assertEquals(1, service.getEnrollmentsByUser("user-1").size());
    }
    @Test
    void flashcardServiceCoversDecks() {
        FlashcardService service = new FlashcardService(new FlashcardDeckRepository());

        List<FlashcardDeck> decks = service.getDecksByTopic(101);

        assertEquals(1, decks.size());
        assertEquals(2, decks.get(0).getCards().size());
    }
    @Test
    void materialServiceCoversMaterials() {
        MaterialService service = new MaterialService(new MaterialRepository());
        List<Material> materials = service.getMaterialsByTopic(101);
        assertEquals(2, materials.size());
    }

    @Test
    void progressServiceCoversProgress() {
        ProgressRepository repository = new ProgressRepository();
        ProgressService service = new ProgressService(repository);

        service.recordTopicVisit("user-1");
        service.recordFlashcardsReviewed("user-1", 3);
        service.recordQuizResult("user-1", 2, 3);

        Progress progress = service.getProgress("user-1");
        assertEquals(1, progress.getTopicsVisited());
        assertEquals(3, progress.getFlashcardsReviewed());
        assertEquals(1, progress.getQuizzesTaken());
        assertEquals(2, progress.getCorrectAnswers());
    }

    @Test
    void quizServiceCoversQuizzes() {
        QuizService service = new QuizService(new QuizRepository());

        List<Quiz> quizzes = service.getQuizzesByTopic(101);

        assertEquals(1, quizzes.size());
        assertEquals("Java Basics", quizzes.get(0).getTitle());
    }

    @Test
    void topicServiceCoversTopics() {
        TopicService service = new TopicService(new TopicRepository());

        List<Topic> topics = service.getTopicsByCourse(1);

        assertEquals(2, topics.size());
        assertEquals("Variables and Control Flow", topics.get(0).getTitle());
        assertNull(service.getTopicById(999));
    }

    @Test
    void userServiceCoversUsers() {
        UserService service = new UserService(new UserRepository());

        List<User> users = service.getAllUsers();

        assertEquals(3, users.size());
        assertEquals("avery@example.com", service.getUserByEmail("avery@example.com").getEmail());
        assertNull(service.getUserByEmail("missing@example.com"));
    }
}
