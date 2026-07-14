package za.ac.cput;


import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("====================");
        System.out.println("Welcome to NumberGuessingGame");
        System.out.println("====================");

        //Ask a player for their firstName//
        System.out.println("Enter your first name: ");
        String playerName = sc.nextLine();

        //Create a player object
        Player player = new Player(playerName);

        //Create a game object
        Game game = new Game();

        //Start the game
        game.startGame(player);


        }
    }
