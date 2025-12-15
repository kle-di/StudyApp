package repository;

import model.FlashcardDeck;

import java.util.ArrayList;
import java.util.List;

public class FlashcardDeckRepository {

    private final List<FlashcardDeck> decks = new ArrayList<>();

    public void add(FlashcardDeck deck) {
        decks.add(deck);
    }

    public List<FlashcardDeck> findAll() {
        return decks;
    }

    public FlashcardDeck findById(String id) {
        for (FlashcardDeck d : decks) {
            if (d.getId().equals(id)) {
                return d;
            }
        }
        return null;
    }
}

