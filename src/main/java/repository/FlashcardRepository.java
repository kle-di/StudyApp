package repository;

import model.Flashcard;

import java.util.ArrayList;
import java.util.List;

public class FlashcardRepository {

    private final List<Flashcard> flashcards = new ArrayList<>();

    public void add(Flashcard flashcard) {
        flashcards.add(flashcard);
    }

    public List<Flashcard> findAll() {
        return flashcards;
    }

    public Flashcard findByIndex(int index) {
        if (index < 0 || index >= flashcards.size()) {
            return null;
        }
        return flashcards.get(index);
    }

    public int size() {
        return flashcards.size();
    }
}
