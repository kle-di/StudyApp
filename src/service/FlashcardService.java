package service;

import model.Flashcard;
import model.FlashcardDeck;

import java.util.HashMap;
import java.util.Map;

public class FlashcardService {

    private Map<String, FlashcardDeck> decks = new HashMap<>();

    public FlashcardDeck createDeck(String title, String ownerId) {
        FlashcardDeck deck = new FlashcardDeck(title, ownerId);
        decks.put(deck.getId(), deck);
        return deck;
    }

    public void addFlashcard(String deckId, String question, String answer) {
        FlashcardDeck deck = decks.get(deckId);
        if (deck != null) {
            deck.addCard(new Flashcard(question, answer));
        }
    }

    public FlashcardDeck getDeck(String deckId) {
        return decks.get(deckId);
    }
}
