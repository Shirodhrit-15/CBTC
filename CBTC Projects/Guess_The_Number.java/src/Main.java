import java.util.Random;
import java.util.Scanner;

class Guessthenumbergame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1; // Define the lower bound of the number range.
        int upperBound = 100; // Define the upper bound of the number range.
        int generatedNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int attempts = 0;
        int maxAttempts = 10; // Set a maximum number of attempts.
        int score = 0;

        System.out.println("Welcome to Guess the Number Game!");
        System.out.println("I've picked a number between " + lowerBound + " and " + upperBound + ". Try to guess it!");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == generatedNumber) {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                score += maxAttempts - attempts + 1; // Calculate and update the score.
                break;
            } else if (userGuess < generatedNumber) {
                System.out.println("Try again! Your guess is too low.");
            } else {
                System.out.println("Try again! Your guess is too high.");
            }

            if (attempts < maxAttempts) {
                System.out.println("You have " + (maxAttempts - attempts) + " attempts left.");
            } else {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + generatedNumber);
            }
        }

        System.out.println("Your final score: " + score);
        scanner.close();
    }
}
