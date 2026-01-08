package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * Collection of flashcards owned by a user.
 */
public class FlashcardDeck implements Iterable<Flashcard> {

    private final String id;
    private final String title;
    private final String ownerId;
    private final List<Flashcard> cards;

    public FlashcardDeck(String title, String ownerId) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.ownerId = ownerId;
        this.cards = new ArrayList<>();
    }

    public void addCard(Flashcard card) {
        cards.add(card);
    }

    public List<Flashcard> getCards() {
        return cards;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getOwnerId() {
        return ownerId;
    }

    @Override
    public Iterator<Flashcard> iterator() {
        return new FlashcardIterator();
    }

    private final class FlashcardIterator implements Iterator<Flashcard> {
        private int index;

        @Override
        public boolean hasNext() {
            return index < cards.size();
        }

        @Override
        public Flashcard next() {
            return cards.get(index++);
        }
    }
}

