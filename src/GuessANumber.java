/*****************************************************************
 *****************************************************************
 GuessANumber.java by Jake Hubbard
 
 This program randomly generates a number between 1 and 100, 
 prompts the user to guess the number, and displays whether or not
 they guesses correctly.
 *****************************************************************
 *****************************************************************/
import java.util.Scanner;
import java.util.Random;

public class GuessANumber { 
	
    public static void main(String [] args) {
        Scanner scnr = new Scanner(System.in);  // Scanner object to obtain the user's guess.
        Random randGen = new Random();  // Random number generator object to create random number.
        int userValue;  // User's number guess
        int randomValue;  // Randomly generated number
        boolean hasWon;
        char gameStart;
        int counter;
        char gameReset;

        // Generates a random number between 1 and 100
        randomValue = randGen.nextInt(100) + 1;

        System.out.println("Welcome to the Guess a Number Game! \n");
        System.out.print("Would you like to play? (Y/N): ");
        gameStart = scnr.next().charAt(0);
   
        while (gameStart != 'Y' || gameStart != 'y') {
	        if (gameStart == 'N' || gameStart == 'n') {
	        	System.out.println("Goodbye!");
	        	System.exit(0);
	        }
	        else if (gameStart != 'N' || gameStart != 'n') {
	        	userValue = scnr.next().charAt(0);
	        	break;
	        }
	        else {
	        	System.out.println("ERROR - Please type enter Y or N to continue or quit:");
	        	userValue = scnr.next().charAt(0);
	        } // if
        } // while
        
        
        // Continues to evaluate the guess.
         
        hasWon = false;
        while (hasWon == false) {
        	// Prompts the user for a guess
        	System.out.print("Enter your guess between 1 and 100 (Type 0 to quit): ");
        	userValue = scnr.nextInt();
   
        	counter = 0;
	        // Checks to see if the guess is above or below the randomly generated number and adds to the total guesses.
	        while (userValue != randomValue) {
	        	// Displays an error if guess is not 1-100 or 0.
	            if (userValue < 0 || userValue > 100) {
	            	System.out.print("Error!  Please type a number between 1 and 100 or type 0 to quit: ");
	            } // if
	                
	            if (userValue == 0) {
	            	System.out.print("\nGoodbye");
	            	System.exit(0);
	            }
	            // Checks if the user's guess is below the random number
	            else if (userValue < randomValue) {
	                System.out.println("Your guess is too low!");
	                System.out.println("Please try again or type 0 to quit: ");
	            }
	            // Checks if the user's guess is above the random number
	            else if (userValue > randomValue) {
	            	System.out.println("Your guess is too high!");
	            	System.out.println("Please try again or type 0 to quit: ");
	            } // if
	            ++counter;
	            userValue = scnr.nextInt();
	        } // while
	        
	        // Checks if the user correctly guesses the random number
	        if (userValue == randomValue) {
	        	++counter;
	        	hasWon = true;
	        	System.out.println("Congratulaions!  You've guessed correctly!");
	        	System.out.println("It took you " + counter + " guesses.");
	        } // if
	        
        	do {
        		System.out.print("Would you like to play again? (Y/N): \n");
        		gameReset = scnr.next().charAt(0);
        		if (gameReset == 'Y' || gameReset == 'y') {
        			hasWon = true;
        			randomValue = randGen.nextInt(100) + 1;
	            } else if (gameReset == 'N' || gameReset == 'n') {
	            	System.out.println("Thanks for playing!");
	            	scnr.close();
	            	hasWon = true;
	            } 
	        } while (hasWon == false); // do while 
        } // while
        
    } // main
    
} // GuessANumber
