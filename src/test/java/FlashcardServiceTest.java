import model.FlashcardDeck;
import org.junit.jupiter.api.Test;
import repository.FlashcardDeckRepository;
import service.FlashcardService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlashcardServiceTest {

    @Test
    void returnsDecksByTopic() {
        FlashcardService service = new FlashcardService(new FlashcardDeckRepository());

        List<FlashcardDeck> decks = service.getDecksByTopic(101);

        assertEquals(1, decks.size());
        assertEquals(2, decks.get(0).getCards().size());
    }
}
