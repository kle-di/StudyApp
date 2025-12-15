package app;

import model.Flashcard;
import model.FlashcardDeck;
import model.StudyProgress;
import service.FlashcardService;
import service.ProgressService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        FlashcardService flashcardService = new FlashcardService();
        ProgressService progressService = new ProgressService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== All-in-One Studying Tool ===");

        // -------- LOGIN (simulated) --------
        System.out.print("Enter user id: ");
        String userId = scanner.nextLine();

        // -------- CREATE FLASHCARD DECK --------
        System.out.print("Create flashcard deck title: ");
        String title = scanner.nextLine();
        FlashcardDeck deck = flashcardService.createDeck(title, userId);

        System.out.println("Deck created with ID: " + deck.getId());

        // -------- ADD FLASHCARDS --------
        while (true) {
            System.out.print("Add flashcard? (yes/no): ");
            String choice = scanner.nextLine();

            if (!choice.equalsIgnoreCase("yes")) {
                break;
            }

            System.out.print("Question: ");
            String question = scanner.nextLine();

            System.out.print("Answer: ");
            String answer = scanner.nextLine();

            flashcardService.addFlashcard(deck.getId(), question, answer);
            System.out.println("Flashcard added.");
        }

        // -------- STUDY MODE --------
        System.out.println("\n--- Study Mode ---");
        for (Flashcard card : deck.getCards()) {
            System.out.println("Q: " + card.getQuestion());
            System.out.print("Press ENTER to see answer...");
            scanner.nextLine();
            System.out.println("A: " + card.getAnswer());
            System.out.println();
        }

        int studiedCount = flashcardService.getFlashcardCount(deck.getId());
        System.out.println("You studied " + studiedCount + " flashcards.");

        // -------- RECORD FLASHCARD PROGRESS --------
        progressService.recordFlashcards(userId, studiedCount);

        // -------- QUIZ SIMULATION --------
        System.out.print("\nSimulate quiz completion? (yes/no): ");
        String quizChoice = scanner.nextLine();

        if (quizChoice.equalsIgnoreCase("yes")) {
            progressService.recordQuizCompletion(userId);
            System.out.println("Quiz marked as completed!");
        }

        // -------- PROGRESS SUMMARY --------
        StudyProgress progress = progressService.getProgress(userId);

        System.out.println("\n--- Progress Summary ---");
        System.out.println("User ID: " + userId);
        System.out.println("Flashcards studied: " + progress.getFlashcardsStudied());
        System.out.println("Quizzes completed: " + progress.getQuizzesCompleted());

        System.out.println("\n=== Session Ended ===");
        scanner.close();
    }
}
