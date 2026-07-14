package za.ac.cput;


import java.util.Random;
import java.util.Scanner;

public class Game {

    //variables
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static final int MAX_ATTEMPTS = 5;

    private Scanner scanner;
    private Random random;

    //Constructor initializes scanner & random objects
    public Game() {
        scanner = new Scanner(System.in);
        random = new Random();
    }

    //The game starts and rounds are managed here
    public void startGame(Player player) {

        boolean playAgain = true;

        while (playAgain) {
            int roundScore = playRound();
            player.addScore(roundScore);

            System.out.println("\nRound Score: " + roundScore);
            System.out.println("Total score:" + player.getTotalscore());

            System.out.println("\nWould you like to play again? (y/n):");
            String answer = scanner.next().toLowerCase();

            playAgain = answer.equals("y");
        }

        System.out.println("\n=============");
        System.out.println("Thank you for playing" + player.getName());
        System.out.println("Final Score: " + player.getTotalscore());
    }

    private int playRound() {
        int secretNumber = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1 ) + MIN_NUMBER;
        int attemptsLeft = MAX_ATTEMPTS;

        System.out.println("\n==================");
        System.out.println("Guess a number between " + MIN_NUMBER + " and " + MAX_NUMBER);
        System.out.println("you have" + MAX_ATTEMPTS + " attempts left");
        System.out.println("===================");

        while (attemptsLeft > 0) {
            System.out.println("Your guess is: ");

            //Input Validation
           while(!scanner.hasNextInt()) {
                System.out.println("Invalid number, enter a number:");
                scanner.next();
            }

            int guess = scanner.nextInt();

            if(guess < MIN_NUMBER || guess > MAX_NUMBER) {
                System.out.println("please enter a number between " + MIN_NUMBER + " and " + MAX_NUMBER);
                continue;
            }

            if (guess == secretNumber) {
                System.out.println("Congratulations! You win!");
                return attemptsLeft * 5;
            }

            if (guess < secretNumber) {
                System.out.println("Number is too low, try again");
            }else {
                System.out.println("Number is too high, try again");
            }

            attemptsLeft--;
            System.out.println("Attempts remaining: " + attemptsLeft);
        }

        System.out.println("\nYou dont have enough attempts left");
        System.out.println("Your guess is: " + secretNumber);

        return 0;
    }

}
