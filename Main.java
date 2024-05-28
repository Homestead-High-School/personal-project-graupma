import java.util.*;
public class Main {
    public static void main(String[] args){

        //creates an instance of the uno game and prints the rules of uno
        Uno game = new Uno();
        System.out.println("Welcome to Uno! The rules are as follows:");
        game.rules();

        //asks the user if they are ready to begin the game, but starts the game regardless of their answer
        Scanner input = new Scanner(System.in);
        System.out.println("Ready to start (y/n)? ");
        String ready = input.nextLine();
        if(ready.toLowerCase().equals("n")){
            System.out.println("Pity!");
        }

        //begins the actual game
        System.out.println("Commencing sequence...");
        game.play();

        //asks the user if they would like to play again, and keeps asking until the option they enter is equal to either "y" or "n"
        System.out.println("Would you like to play again (y/n)? ");
        ready = input.nextLine();
        while(!ready.toLowerCase().equals("y") && !ready.toLowerCase().equals("n")){
            System.out.println("Invalid option. Would you like to play again (y/n)? ");
            ready = input.nextLine();
        }

        //until the user enters "n", the game is played repeatedly
        while(ready.toLowerCase().equals("y")){
            //prints out the rules of a new uno instance and begins the game
            System.out.println("Great! The rules are as follows:");
            Uno nGame = new Uno();
            nGame.rules();
            nGame.play();

            //reasks the user if they would like to play again, and keeps asking until they enter either "y" or "n"
            System.out.println("Would you like to play again (y/n)? ");
            ready = input.nextLine();
            while(!ready.toLowerCase().equals("y") && !ready.toLowerCase().equals("n")){
                System.out.println("Invalid option. Would you like to play again (y/n)? ");
                ready = input.nextLine();
            }
        }
        
        //thanks the user for playing :)
        System.out.println("Thanks for playing!");
    }
}
