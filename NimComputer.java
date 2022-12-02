import java.util.Random;
/**
 * Class for the different moves the computer can play based on their difficulty. 
 * @author Tony Gonzalez
 * @version 7/26/22
 */
public class NimComputer 
{
    /**
     * Generates random legal move the computer plays on 'stupid' mode. 
     * @param pile Current size of pile. 
     * @return Returns the randomly generated amount to remove. 
     */
    public int StupidGuess(int pile)
    {
        Random generator = new Random();
        int guess = 1 + (generator.nextInt(pile) / 2); //Random legal move

        return guess; 
    }

    /**
     * Computer takes off enough marbles to make the size of the pile a power of two minus 1.
     * @param pile Current size of pile.
     * @return Returns the generated amount to remove. 
     */
    public int SmartGuess(int pile)
    {
        Random generator = new Random();
        int guess;
        int difference;
 
        if(pile > 2) //If pile is greater than a power of two 
        {
            do
            {
                guess = 1 + (generator.nextInt(pile) / 2);
                difference = pile - guess;
            }while((difference != 3) && (difference != 7) && (difference != 15) && (difference != 31) && (difference != 63));
        }
        else //Random legal move if pile is less than a power of two 
        {
            guess = 1 + (generator.nextInt(pile) / 2); 
        }
        return guess;
    }
}
