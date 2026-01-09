package controller;

import model.FlashcardDeck;
import service.FlashcardService;

import java.util.List;

/**
 * Controller for flashcard actions.
 */
public class FlashcardController {

    private final FlashcardService flashcardService;

    public FlashcardController(FlashcardService flashcardService) {
        this.flashcardService = flashcardService;
    }

    public List<FlashcardDeck> listDecksByTopic(int topicId) {
        return flashcardService.getDecksByTopic(topicId);
    }
}
