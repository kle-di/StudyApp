package service;

import model.Flashcard;
import model.FlashcardDeck;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages flashcard decks in memory.
 */
public class FlashcardService implements FlashcardServicePort {

    private final Map<String, FlashcardDeck> decks = new HashMap<>();

    public FlashcardService() {
    }

    @Override
    public FlashcardDeck createDeck(String title, String ownerId) {
        FlashcardDeck deck = new FlashcardDeck(title, ownerId);
        decks.put(deck.getId(), deck);
        return deck;
    }

    @Override
    public void addFlashcard(String deckId, String question, String answer) {
        FlashcardDeck deck = decks.get(deckId);
        if (deck == null) {
            throw new RuntimeException("FlashcardDeck not found");
        }
        deck.addCard(new Flashcard(question, answer));
    }

    @Override
    public FlashcardDeck getDeck(String deckId) {
        return decks.get(deckId);
    }

    @Override
    public int getFlashcardCount(String deckId) {
        FlashcardDeck deck = decks.get(deckId);
        if (deck == null) {
            return 0;
        }
        return deck.getCards().size();
    }
}
