package service;

import model.Flashcard;
import model.FlashcardDeck;

import java.util.HashMap;
import java.util.Map;

public class FlashcardService {

    private Map<String, FlashcardDeck> decks = new HashMap<>();

    // Krijon nje deck
    public FlashcardDeck createDeck(String title, String ownerId) {
        FlashcardDeck deck = new FlashcardDeck(title, ownerId);
        decks.put(deck.getId(), deck);
        return deck;
    }

    // Shton flashcard ne deck
    public void addFlashcard(String deckId, String question, String answer) {
        FlashcardDeck deck = decks.get(deckId);
        if (deck == null) {
            throw new RuntimeException("FlashcardDeck not found");
        }
        deck.addCard(new Flashcard(question, answer));
    }

    // Merr nje deck
    public FlashcardDeck getDeck(String deckId) {
        return decks.get(deckId);
    }

    // Numeron flashcards (funksionalitet REAL)
    public int getFlashcardCount(String deckId) {
        FlashcardDeck deck = decks.get(deckId);
        if (deck == null) {
            return 0;
        }
        return deck.getCards().size();
    }
}
