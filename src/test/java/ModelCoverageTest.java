import model.Course;
import model.Enrollment;
import model.Flashcard;
import model.FlashcardDeck;
import model.Material;
import model.MaterialType;
import model.Progress;
import model.Question;
import model.Quiz;
import model.Topic;
import model.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ModelCoverageTest {

    @Test
    void courseTopicAndEnrollmentExposeFields() {
        Course course = new Course(1, "Title", "Desc");
        Topic topic = new Topic(10, 1, "Topic", "Details");
        Enrollment enrollment = new Enrollment(5, "user-1", 1, "2024-01-01 10:00:00");

        assertEquals(1, course.getId());
        assertEquals("Title", course.getTitle());
        assertEquals("Desc", course.getDescription());
        assertEquals(10, topic.getId());
        assertEquals(1, topic.getCourseId());
        assertEquals("Topic", topic.getTitle());
        assertEquals("Details", topic.getDescription());
        assertEquals(5, enrollment.getId());
        assertEquals("user-1", enrollment.getUserId());
        assertEquals(1, enrollment.getCourseId());
        assertEquals("2024-01-01 10:00:00", enrollment.getEnrolledAt());
    }

    @Test
    void userUpdatesName() {
        User user = new User("Avery", "avery@example.com");

        user.updateName("Avery Updated");

        assertEquals("Avery Updated", user.getName());
        assertNotNull(user.getId());
    }

    @Test
    void flashcardDeckStoresCards() {
        FlashcardDeck deck = new FlashcardDeck(1, 100, "Deck");
        Flashcard card = new Flashcard("Front", "Back");

        deck.addCard(card);

        assertEquals(1, deck.getCards().size());
        assertEquals("Deck", deck.getTitle());
        assertEquals(100, deck.getTopicId());
    }

    @Test
    void materialAndEnumExposeFields() {
        Material material = new Material(1, 10, MaterialType.READING, "Title", "Content");

        assertEquals(1, material.getId());
        assertEquals(10, material.getTopicId());
        assertEquals(MaterialType.READING, material.getType());
        assertEquals("Title", material.getTitle());
        assertEquals("Content", material.getContent());
        assertEquals(MaterialType.VIDEO, MaterialType.valueOf("VIDEO"));
    }

    @Test
    void quizAndQuestionStoreData() {
        Question question = new Question("Prompt", Arrays.asList("A", "B"), "A");
        Quiz quiz = new Quiz(2, 20, "Quiz");

        quiz.addQuestion(question);

        assertEquals(2, quiz.getId());
        assertEquals(20, quiz.getTopicId());
        assertEquals("Quiz", quiz.getTitle());
        assertEquals(1, quiz.getQuestions().size());
        assertEquals("Prompt", question.getPrompt());
        assertEquals("A", question.getCorrectAnswer());
        assertEquals(2, question.getOptions().size());
    }

    @Test
    void progressTracksMetrics() {
        Progress progress = new Progress("user-1");

        progress.recordTopicVisit();
        progress.addFlashcardsReviewed(3);
        progress.recordQuizResult(2, 3);
        progress.recordQuizResult(0, 0);
        progress.recordQuizResult(5, 3);

        assertEquals("user-1", progress.getUserId());
        assertEquals(1, progress.getTopicsVisited());
        assertEquals(3, progress.getFlashcardsReviewed());
        assertEquals(2, progress.getQuizzesTaken());
        assertEquals(5, progress.getCorrectAnswers());
    }
}
