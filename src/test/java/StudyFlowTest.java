import controller.CourseController;
import controller.EnrollmentController;
import controller.FlashcardController;
import controller.MaterialController;
import controller.ProgressController;
import controller.QuizController;
import controller.TopicController;
import controller.UserController;
import model.Course;
import model.FlashcardDeck;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
public class StudyFlowTest {
    @Test
    void endToEndStudyFlowUpdatesProgress() {
        UserController userController = new UserController(new UserService(new UserRepository()));
        CourseController courseController = new CourseController(new CourseService(new CourseRepository()));
        TopicController topicController = new TopicController(new TopicService(new TopicRepository()));
        MaterialController materialController = new MaterialController(new MaterialService(new MaterialRepository()));
        FlashcardController flashcardController = new FlashcardController(new FlashcardService(new FlashcardDeckRepository()));
        QuizController quizController = new QuizController(new QuizService(new QuizRepository()));
        EnrollmentController enrollmentController = new EnrollmentController(new EnrollmentService(new EnrollmentRepository()));
        ProgressController progressController = new ProgressController(new ProgressService(new ProgressRepository()));

        User user = userController.listUsers().get(0);
        Course course = courseController.getCourseById(1);
        assertNotNull(course);
        enrollmentController.enroll(user.getId(), course.getId());

        Topic topic = topicController.listTopicsByCourse(course.getId()).get(0);
        progressController.recordTopicVisit(user.getId());

        assertFalse(materialController.listMaterialsByTopic(topic.getId()).isEmpty());

        FlashcardDeck deck = flashcardController.listDecksByTopic(topic.getId()).get(0);
        int reviewed = deck.getCards().size();
        progressController.recordFlashcardsReviewed(user.getId(), reviewed);

        Quiz quiz = quizController.listQuizzesByTopic(topic.getId()).get(0);
        int correct = quiz.getQuestions().size();
        progressController.recordQuizResult(user.getId(), correct, quiz.getQuestions().size());

        Progress progress = progressController.getProgress(user.getId());
        assertNotNull(progress);
        assertEquals(1, progress.getTopicsVisited());
        assertEquals(reviewed, progress.getFlashcardsReviewed());
        assertEquals(1, progress.getQuizzesTaken());
        assertEquals(correct, progress.getCorrectAnswers());
    }
}
