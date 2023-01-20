import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;
import javax.xml.validation.Validator;

import java.util.Random;
import java.util.InputMismatchException;

/** A number guessing game. */
public class Game {
  public static void main(String[] args) {
    System.out.println("Welcome to the Guessing Game!");

    Scanner input = new Scanner(System.in);

    // Get user's name
    System.out.println("Enter your name:");
    String name = input.nextLine();
    // Test that everything works
    System.out.println(name +", I'm thinking of a number between 0 and 100");

    //Create an instance of the Random object
    Random rand = new Random();

    //Call method nextInt and pass in upper range (exclusive)
    int number = rand.nextInt(101); // 101 to be inclusive //bound is automatically created by VSCode
    System.out.println("Try to guess the number!");

    int guessCounter = 1;
    int guess = -1;
    Boolean stillPlay = true;


    while (stillPlay == true) {
      int playAgain = 2;
      while (guess != number ) {
        System.out.println("What is your guess?");
        Boolean validGuess = false;
          try {
            guess = input.nextInt();
            if (guess > -1 && guess < 10) {
              validGuess = true;
            } else {
              System.out.println("Please enter a number between 1-100");
            }
          } catch(InputMismatchException e) {
            String badInput = input.next();
            System.out.println(badInput + " is not a valid number, try again");
          }
        // }
        if (validGuess) {
          guessCounter++;
          if (guess < number ) {
            System.out.println("That's too low, please try again:");
          } else {
            System.out.println("That's too high, please try again:");
          }
        }
      }

      System.out.println("The number was " + number);
      System.out.println("It took you " + guessCounter + " times to guess this number");

      System.out.println("Enter 1 to play again, or 0 to quit");

      while (playAgain != 1 && playAgain != 0) {
        try {
          playAgain = input.nextInt();

          if (playAgain == 0) {
            stillPlay = false;
          } else if (playAgain == 1) {
            number = rand.nextInt(101);
            guess = -1;
          } else {
            System.out.println("Please enter 1 to play again, or 0 to quit");
            playAgain = input.nextInt();
          }

        } catch (InputMismatchException e) {
          String invalidInput = input.next();
          System.out.println(invalidInput + " is invalid. Please enter a number(0 or 1)");
          }
      }
    }
    System.out.println("Thanks for playing! Have a nice day");
  }
}