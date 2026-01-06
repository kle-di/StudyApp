package service;

import model.Flashcard;

import java.util.ArrayList;
import java.util.List;

public class FlashcardDeckService {

    private final List<Flashcard> deck = new ArrayList<>();

    public void addFlashcard(String question, String answer) {
        Flashcard flashcard = new Flashcard(question, answer);
        deck.add(flashcard);
    }

    public List<Flashcard> getAllFlashcards() {
        return deck;
    }

    public Flashcard getFlashcard(int index) {
        if (index < 0 || index >= deck.size()) {
            throw new IndexOutOfBoundsException("Flashcard not found");
        }
        return deck.get(index);
    }

    public int size() {
        return deck.size();
    }
}


