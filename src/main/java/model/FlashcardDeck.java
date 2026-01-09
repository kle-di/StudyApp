package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Flashcard deck tied to a topic.
 */
public class FlashcardDeck {

    private final int id;
    private final int topicId;
    private final String title;
    private final List<Flashcard> cards = new ArrayList<>();

    public FlashcardDeck(int id, int topicId, String title) {
        this.id = id;
        this.topicId = topicId;
        this.title = title;
    }

    public void addCard(Flashcard card) {
        cards.add(card);
    }

    public int getId() {
        return id;
    }

    public int getTopicId() {
        return topicId;
    }

    public String getTitle() {
        return title;
    }

    public List<Flashcard> getCards() {
        return Collections.unmodifiableList(cards);
    }
}
