import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int lowRange = 1;
        int highRange = 100;
        int possibleGuesses;
        int yourGuess = 0;
        int playerAnswer = 0;
        int countNumTurns = 1;

        int prevValue = 0;

        while (playerAnswer != 1) {
            possibleGuesses = highRange + lowRange - 1;
            yourGuess = (int) Math.ceil(possibleGuesses / 2);

            // If no changes since previous turn or
            // if there are already 7 turns (maximum)
            if (prevValue == yourGuess || countNumTurns == 7) {

                // Stop guessing, result is defined
                break;
            }

            System.out.printf("Is your age %d ?\n", yourGuess);
            System.out.printf("1 - Yes\n2 - Guess a lower age\n3 - Guess a higher age\nAction: ");
            playerAnswer = input.nextInt();

            if(playerAnswer == 3)
                lowRange = yourGuess + 1;

            if(playerAnswer == 2)
                highRange = yourGuess - 1;

            if (playerAnswer == 1)
                break;

            countNumTurns++;

            // Remember previous guess
            prevValue = yourGuess;
        }

        System.out.printf("I guessed your age in %d turns !\n", countNumTurns);
        System.out.printf("Age: %d\n", yourGuess);

    }
}