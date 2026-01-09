import model.Progress;
import org.junit.jupiter.api.Test;
import repository.ProgressRepository;
import service.ProgressService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgressServiceTest {

    @Test
    void recordsProgressForUser() {
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
    void clampsQuizResultsToTotal() {
        ProgressRepository repository = new ProgressRepository();
        ProgressService service = new ProgressService(repository);

        service.recordQuizResult("user-2", 5, 3);

        Progress progress = service.getProgress("user-2");
        assertEquals(1, progress.getQuizzesTaken());
        assertEquals(3, progress.getCorrectAnswers());
    }
}
