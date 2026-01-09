import controller.CourseController;
import controller.EnrollmentController;
import controller.FlashcardController;
import controller.MaterialController;
import controller.ProgressController;
import controller.QuizController;
import controller.TopicController;
import controller.UserController;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ControllerIntegrationTest {

    @Test
    void controllersReturnSeededData() {
        UserController userController = new UserController(new UserService(new UserRepository()));
        CourseController courseController = new CourseController(new CourseService(new CourseRepository()));
        TopicController topicController = new TopicController(new TopicService(new TopicRepository()));
        MaterialController materialController = new MaterialController(new MaterialService(new MaterialRepository()));
        FlashcardController flashcardController = new FlashcardController(new FlashcardService(new FlashcardDeckRepository()));
        QuizController quizController = new QuizController(new QuizService(new QuizRepository()));
        ProgressController progressController = new ProgressController(new ProgressService(new ProgressRepository()));
        assertEquals(3, userController.listUsers().size());
        assertNotNull(userController.findByEmail("avery@example.com"));
        assertEquals(3, courseController.listCourses().size());
        assertEquals(2, topicController.listTopicsByCourse(1).size());
        assertNotNull(topicController.getTopicById(101));
        assertEquals(2, materialController.listMaterialsByTopic(101).size());
        assertEquals(1, flashcardController.listDecksByTopic(101).size());
        assertEquals(1, quizController.listQuizzesByTopic(101).size());
        assertNotNull(progressController.getProgress("user-1"));
        progressController.recordTopicVisit("user-1");
        progressController.recordFlashcardsReviewed("user-1", 3);
        progressController.recordQuizResult("user-1", 2, 3);
    }
    @Test
    void enrollmentControllerTracksEnrollments() {
        EnrollmentController enrollmentController = new EnrollmentController(
                new EnrollmentService(new EnrollmentRepository()));
        assertTrue(enrollmentController.enroll("user-1", 1).getId() > 0);
        assertTrue(enrollmentController.isEnrolled("user-1", 1));
        assertEquals(1, enrollmentController.listEnrollmentsByUser("user-1").size());
    }
    @Test
    void courseControllerFindsCourseById() {
        CourseController courseController = new CourseController(new CourseService(new CourseRepository()));
        assertNotNull(courseController.getCourseById(1));
        assertEquals("Java Fundamentals", courseController.getCourseById(1).getTitle());
    }
}
