import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int maxRounds = 3;
        int totalScore = 0;

        System.out.println("Welcome to the Guess the Number Game!");
        System.out.println("You have " + maxRounds + " rounds to guess the number.");

        for (int round = 1; round <= maxRounds; round++) {
            System.out.println("Round " + round + " starts!");

            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10;
            int score = 0;

            boolean hasGuessed = false;

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess (1-100): ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You've guessed the number!");

                    // Scoring logic based on attempts
                    score = calculateScore(attempts, maxAttempts);
                    totalScore += score;

                    hasGuessed = true;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("The number is higher!");
                } else {
                    System.out.println("The number is lower!");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!hasGuessed) {
                System.out.println("Sorry, you've used all your attempts. The number was: " + numberToGuess);
            }

            System.out.println("Your score for this round: " + score);
            System.out.println("Total score so far: " + totalScore);
            System.out.println("-------------------------------");
        }

        System.out.println("Game over! Your final score is: " + totalScore);
        scanner.close();
    }

    // Method to calculate score based on attempts
    private static int calculateScore(int attempts, int maxAttempts) {
        int baseScore = 100; // Maximum score if guessed on the first attempt
        int score = baseScore - (attempts - 1) * (baseScore / maxAttempts);
        return Math.max(score, 0); // Ensure the score doesn't go negative
    }
}
