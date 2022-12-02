import java.util.Random;
import java.util.Scanner;
/**
 * The game of Nim.
 * @author Tony Gonzalez
 * @version 7/26/22
 */
public class Nim
{
    /**
     * Generates random values to determine pile size, who plays first, and computer difficulty.
     * Starts game based on who the program generated to play first, and the difficulty of the computer.
     * Lets user input the amount they want to remove from the pile and print resulting amount. 
     * Uses 'StupidMove' or 'SmartMove' methods from NimComputer class to have the computer remove amount from pile.
     * Continues game until pile is 0.
     * Prints whoever won the game.
     * Exits game and print thank you message. 
     * @param args
     */
    public static void main(String[] args) 
    {
        //Random number generators 
        Random generator = new Random();
        int pile = 10 + generator.nextInt(91);
        int firstTurn = generator.nextInt(2);
        int computerDifficulty = generator.nextInt(2);

        //Scanners
        Scanner input = new Scanner(System.in);
    
        //Create new computer object
        NimComputer computer = new NimComputer();

        //Instace variables 
        int humanGuess;
        int computerGuess;

        System.out.println("The size of the pile is " + pile + " marbles.");
        
        outerloop: //Entire game code 
        switch(firstTurn)
        {
            case 0: //firstTurn == 0, human plays first 

            switch(computerDifficulty)
            {
                case 0: //computerDifficulty == 0, computer plays stupid
                    System.out.print("You have been chosen to play first. Your opponent's difficulty is 'stupid.' Goodluck!");
                    do 
                    {
                        System.out.print("\nPlease enter how many marbles you would like to remove from the pile: "); //Start game
                        humanGuess = input.nextInt();

                        while(pile != 1 && !(humanGuess <= pile/2) || humanGuess < 1) //input validation 
                        {
                            System.out.print("Invalid input. The pile has " + pile + " marbles. Please enter an integer between 1 and half the size of the pile: ");
                            humanGuess = input.nextInt();
                        }

                        if(pile - humanGuess == 0) //Check to see if this was a winning turn
                        {
                            System.out.println("Congratulations! You have won the game!");
                            break;
                        }
                        else //Continue playing if it was not a winning turn 
                        {
                            pile -= humanGuess;
                            System.out.println("You took out " + humanGuess + " marbles. The pile now has " + pile + " marbles.");
                        }
                        
                        computerGuess = computer.StupidGuess(pile); //Computer guess 
                        
                        if(pile - computerGuess == 0) //Check to see if this was a winning turn
                        {
                            System.out.println("Your opponent took out the last marble and you have lost.");
                            break;
                        }
                        else //Continue playing if it was not a winning turn 
                        {
                            pile -= computerGuess;
                            System.out.println("Your opponent took out " + computerGuess + " marbles. The pile now has " + pile + " marbles.");
                        }
                    }while(pile != 0); //End once pile is empty 

                break outerloop; //Terminate entire game once it is over

                case 1: //computerDifficulty == 1, computer plays smart
                System.out.print("You have been chosen to play first. Your opponent's difficulty is 'smart.' Goodluck!");
                do
                {
                    System.out.print("\nPlease enter how many marbles you would like to remove from the pile: ");
                    humanGuess = input.nextInt();

                    while(pile != 1 && !(humanGuess <= pile/2) || humanGuess < 1) //input validation 
                    {
                        System.out.print("Invalid input. The pile has " + pile + " marbles. Please enter an integer between 1 and half the size of the pile: ");
                        humanGuess = input.nextInt();
                    }

                    if(pile - humanGuess == 0) //Check to see if this was a winning turn
                    {
                        System.out.println("Congratulations! You have won the game!");
                        break;
                    }
                    else //Continue playing if it was not a winning turn 
                    {
                        pile -= humanGuess;
                        System.out.println("You took out " + humanGuess + " marbles. The pile now has " + pile + " marbles.");
                    }
                    
                    computerGuess = computer.SmartGuess(pile); //Computer guess 
                    
                    if(pile - computerGuess == 0) //Check to see if this was a winning turn
                    {
                        System.out.println("Your opponent took out the last marble and you have lost.");
                        break;
                    }
                    else //Continue playing if it was not a winning turn 
                    {
                        pile -= computerGuess;
                        System.out.println("Your opponent took out " + computerGuess + " marbles. The pile now has " + pile + " marbles.");
                    }
                }while(pile != 0);

            break outerloop;
            }

            case 1: //firstTurn == 1, computer plays first

            switch(computerDifficulty)
            {
                case 0: //computerDifficulty == 0, computer plays stupid
                    System.out.println("Your opponent has been chosen to play first. Your opponent's difficulty is 'stupid.' Goodluck!");
                    do
                    {
                        computerGuess = computer.StupidGuess(pile); //Computer guess 
                        
                        if(pile - computerGuess == 0) //Check to see if this was a winning turn
                        {
                            System.out.println("Your opponent took out the last marble and you have lost.");
                            break;
                        }
                        else //Continue playing if it was not a winning turn 
                        {
                            pile -= computerGuess;
                            System.out.println("Your opponent took out " + computerGuess + " marbles. The pile now has " + pile + " marbles.");
                        }

                        System.out.print("\nPlease enter how many marbles you would like to remove from the pile: ");
                        humanGuess = input.nextInt();

                        while(pile != 1 && !(humanGuess <= pile/2) || humanGuess < 1) //input validation 
                        {
                            System.out.print("Invalid input. The pile has " + pile + " marbles. Please enter an integer between 1 and half the size of the pile: ");
                            humanGuess = input.nextInt();
                        }

                        if(pile - humanGuess == 0) //Check to see if this was a winning turn
                        {
                            System.out.println("Congratulations! You have won the game!");
                            break;
                        }
                        else //Continue playing if it was not a winning turn 
                        {
                            pile -= humanGuess;
                            System.out.println("You took out " + humanGuess + " marbles. The pile now has " + pile + " marbles.");
                        }
                    }while(pile != 0);

                break outerloop;

                case 1: //computerDifficulty == 1, computer plays smart
                System.out.println("Your opponent has been chosen to play first. Your opponent's difficulty is 'smart.' Goodluck!");
                do
                {
                    computerGuess = computer.SmartGuess(pile); //Computer guess 
                    
                    if(pile - computerGuess == 0) //Check to see if this was a winning turn
                    {
                        System.out.println("Your opponent took out the last marble and you have lost.");
                        break;
                    }
                    else //Continue playing if it was not a winning turn 
                    {
                        pile -= computerGuess;
                        System.out.println("Your opponent took out " + computerGuess + " marbles. The pile now has " + pile + " marbles.");
                    }

                    System.out.print("\nPlease enter how many marbles you would like to remove from the pile: ");
                    humanGuess = input.nextInt();

                    while(pile != 1 && !(humanGuess <= pile/2) || humanGuess < 1) //input validation 
                    {
                        System.out.print("Invalid input. The pile has " + pile + " marbles. Please enter an integer between 1 and half the size of the pile: ");
                        humanGuess = input.nextInt();
                    }

                    if(pile - humanGuess == 0) //Check to see if this was a winning turn
                    {
                        System.out.println("Congratulations! You have won the game!");
                        break;
                    }
                    else //Continue playing if it was not a winning turn 
                    {
                        pile -= humanGuess;
                        System.out.println("You took out " + humanGuess + " marbles. The pile now has " + pile + " marbles.");
                    } 
                }while(pile != 0);

            break outerloop;
            }
        }
        System.out.println("Thank you for playing!"); //Marks end of program 
        input.close();
    }
}