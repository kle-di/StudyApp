package repository;

import model.Flashcard;
import model.FlashcardDeck;

import java.util.ArrayList;
import java.util.List;

/**
 * In-memory repository for flashcard decks.
 */
public class FlashcardDeckRepository {

    private final List<FlashcardDeck> decks = new ArrayList<>();

    public FlashcardDeckRepository() {
        FlashcardDeck javaBasics = new FlashcardDeck(1, 101, "Variables and Types");
        javaBasics.addCard(new Flashcard("Which keyword creates a constant in Java?", "final"));
        javaBasics.addCard(new Flashcard("What does if/else control?", "Branching"));
        decks.add(javaBasics);

        FlashcardDeck oopBasics = new FlashcardDeck(2, 102, "Classes and Objects");
        oopBasics.addCard(new Flashcard("What stores data in a class?", "Fields"));
        oopBasics.addCard(new Flashcard("What groups behavior in a class?", "Methods"));
        decks.add(oopBasics);

        FlashcardDeck historyDeck = new FlashcardDeck(3, 201, "Ancient Civilizations");
        historyDeck.addCard(new Flashcard("Which river supported Ancient Egypt?", "The Nile"));
        historyDeck.addCard(new Flashcard("What was a key city of ancient Greece?", "Athens"));
        decks.add(historyDeck);

        FlashcardDeck dataStructures = new FlashcardDeck(4, 301, "Arrays and Lists");
        dataStructures.addCard(new Flashcard("Arrays have a fixed or dynamic size?", "Fixed"));
        dataStructures.addCard(new Flashcard("Lists grow by adding what?", "Elements"));
        decks.add(dataStructures);
    }

    public List<FlashcardDeck> findByTopicId(int topicId) {
        List<FlashcardDeck> results = new ArrayList<>();
        for (FlashcardDeck deck : decks) {
            if (deck.getTopicId() == topicId) {
                results.add(deck);
            }
        }
        return results;
    }
}
