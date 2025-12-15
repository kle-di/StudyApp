package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FlashcardDeck {

    private String id;
    private String title;
    private String ownerId;
    private List<Flashcard> cards;

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
}

