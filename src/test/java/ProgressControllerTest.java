import controller.ProgressController;
import model.Progress;
import org.junit.jupiter.api.Test;
import repository.ProgressRepository;
import service.ProgressService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgressControllerTest {

    @Test
    void recordsProgressFromController() {
        ProgressController controller = new ProgressController(new ProgressService(new ProgressRepository()));

        controller.recordTopicVisit("user-1");
        controller.recordFlashcardsReviewed("user-1", 2);
        controller.recordQuizResult("user-1", 1, 2);

        Progress progress = controller.getProgress("user-1");
        assertEquals(1, progress.getTopicsVisited());
        assertEquals(2, progress.getFlashcardsReviewed());
        assertEquals(1, progress.getQuizzesTaken());
        assertEquals(1, progress.getCorrectAnswers());
    }
}
