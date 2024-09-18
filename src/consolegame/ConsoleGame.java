/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consolegame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author walter n
 */
public class ConsoleGame {
private static final int MAX_GUESSES =3;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> Colours = initializeColours();
        
        do{
           playGame(scanner, Colours);
           System.out.print("Do you want to play again? (y/n):");
        }while (scanner.nextLine().equalsIgnoreCase("y"));
        
        System.out.println("Thanks for playing!");
    }
     
    public static List<String> initializeColours(){
        List<String> Colours = new ArrayList<>();
        
        Colours.add("Blue"); 
        Colours.add("Pink");
        Colours.add("Black");
        Colours.add("Red");
        Colours.add("Gold");
        Colours.add("Silver");
        Colours.add("Green");
        Colours.add("Purple");
        Colours.add("Orange");
        Colours.add("Yellow");
         System.out.println(Colours);
         return Colours;
    }
    
    private static void playGame(Scanner scanner, List<String> Colours){
        System.out.println("=== Guessing Game ===");
        
        Random random = new Random();
        int randomIndex = random.nextInt(Colours.size());
        
        int remainingGuesses = MAX_GUESSES;
        boolean wordGuessed = false;
        
        while ( remainingGuesses > 0 && !wordGuessed){
            System.out.println("Guess the word (remaining guesses: " + remainingGuesses + "):");
            String guess = scanner.nextLine();
            
            if(guess.equalsIgnoreCase("Yellow")){
                wordGuessed = true ;
                System.out.println("Congratulations! You guessed it right.");
            }
            
            else{
            remainingGuesses--;
            if (remainingGuesses>0){
                if (remainingGuesses == 2){
                    System.out.println("Incorrect guess. Here's a clue: First letter of the word is '" + "Yellow".charAt(0) + "'.");
                }
                
                else if( remainingGuesses ==1){
                    System.out.println("Incorrect guess. Here's another clue: The word has " + "Yellow".length() + "letters.");
                }
                System.out.println("Try again!");
            }
            else{
                System.out.println("Sorry, you're out of guesses. The word was '" + "Yellow" + "'.");
            }
            }
        }
        
        if(wordGuessed){
            Colours.remove("Yellow");
        }
        
        System.out.println("Number of items remaining in the list: " + Colours.size());
    }
    
}
