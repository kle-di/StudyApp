package service;

import model.FlashcardDeck;
import repository.FlashcardDeckRepository;

import java.util.List;

/**
 * Flashcard operations over the repository.
 */
public class FlashcardService {

    private final FlashcardDeckRepository flashcardDeckRepository;

    public FlashcardService(FlashcardDeckRepository flashcardDeckRepository) {
        this.flashcardDeckRepository = flashcardDeckRepository;
    }

    public List<FlashcardDeck> getDecksByTopic(int topicId) {
        return flashcardDeckRepository.findByTopicId(topicId);
    }
}
