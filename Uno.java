import java.util.*;
public class Uno {
    Stack<Card> drawingPile;
    Stack<Card> discardPile;
    ArrayList<Card> playerHand; 
    ArrayList<Card> compHand;
    //int cardsLeft; -what is this referring to
    Card center; //top of the discard pile
    boolean turn; //true= player, false==computer

    //in constructor need to initialize drawing pile to have all 112 cards and then from there go and deal- remove from drawing pile and place in hand
    public Uno(){
        drawingPile = new Stack<>(); 
        String[] colors = {"red", "yellow", "green", "blue"};

        //adds cards to drawingPile in 4 colors and numbers 1-12
        for(int i = 0; i < colors.length; i++){
            String col = colors[i];
            for(int x = 0; i < 13; x++){
                drawingPile.push(new Card(col, x));
            }
        }
    
        //add black 13 and 14, color changers - 4 color changers, 4 +4 & change
        for(int i = 0; i < 5; i++ ){
            drawingPile.push(new Card("black", 13));
            drawingPile.push(new Card("black", 14) );
        }
        //shuffle the drawing pile and create an empty discard pile
        shuffle(drawingPile);
        discardPile = new Stack<>();

        
        playerHand = new ArrayList<>();
        compHand = new ArrayList<>();

        //deal 7 cards to both player and computer
        for(int i=0; i<8; i++){
            playerHand.add(drawingPile.pop());
            compHand.add(drawingPile.pop()); 
        }

        //top card of discard pile
        discardPile.push(drawingPile.pop());
        center= discardPile.peek();  

        //players turn first
        turn=true;
    }

    
//helper method that shuffles the pile
    private void shuffle(Stack<Card> pile){
        printDeck();
        Collections.shuffle(pile);
        printDeck();
    }

    //method that prints all of the cards in the drawing pile
    public void printDeck(){
        Stack<Card> stack = new Stack<Card>();
        System.out.println(drawingPile.isEmpty());
        while(drawingPile.isEmpty()){
            System.out.print(drawingPile.peek());
            stack.push(drawingPile.pop());
        }
        while(stack.isEmpty()){
            drawingPile.push(stack.pop());
        }
    } 
}
