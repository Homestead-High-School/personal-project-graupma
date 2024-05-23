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
            for(int x = 0; x < 13; x++){
                drawingPile.push(new Card(col, x));
            }
        }
        //add black 13 and 14, color changers - 4 color changers, 4 +4 & change
        for(int j = 0; j < 5; j++ ){
            drawingPile.push(new Card("black", 13));
            drawingPile.push(new Card("black", 14) );
        }
        //shuffle the drawing pile and create an empty discard pile
        shuffle(drawingPile);
        discardPile = new Stack<>();
        playerHand = new ArrayList<>();
        compHand = new ArrayList<>();

        //deal 7 cards to both player and computer
        for(int h = 0; h < 8; h++){
            playerHand.add(drawingPile.pop());
            compHand.add(drawingPile.pop()); 
        }
        printPlayerHand();
        printCompHand();


        //top card of discard pile
        discardPile.push(drawingPile.pop());
        center = discardPile.peek();  

        System.out.println(center.toString()); 
        //players turn first
        turn = true;
    }

    
//helper method that shuffles the pile
    private void shuffle(Stack<Card> pile){
        Collections.shuffle(pile);
        
    }

    //method that prints all of the cards in the drawing pile
    public void printDeck(){
        Stack<Card> stack = new Stack<Card>();
        String temp = "[";
        while(!drawingPile.isEmpty()){
            temp += drawingPile.peek().toString() + ", ";
            stack.push(drawingPile.pop());
        }
        temp = temp.substring(0, temp.length()-2) + "]";
        while(!stack.isEmpty()){
            drawingPile.push(stack.pop());
        }
        System.out.println(temp);
    } 
//prints the players hand 
    public void printPlayerHand(){
       String temp ="Player Hand: [";
        for(int i=0; i<playerHand.size()-1; i++){
            temp+=playerHand.get(i).toString() + ", ";
        }
        temp+=playerHand.get(playerHand.size()-1).toString() + "]";
        System.out.println(temp);
    }
//prints computer hand
    public void printCompHand(){
        String temp = "Computer Hand: [";
        for(int i = 0; i < compHand.size(); i++){
            temp += compHand.get(i).toString() + ", ";
        }
        temp = temp.substring(0, temp.length()-2) + "]";
        System.out.println(temp);
    }

    
    public boolean validPlay(Card c){
        if(c.getColor().equals(center.getColor()) || c.getNumber() == center.getNumber()){
            return true;
        }
        return false;
    }
    
    public void changeColor(String col){
        center.setColor(col); 
    }

    public void changeNumber(int num){
        center.setNumber(num);
    }

    public void changeCenter(Card cent){
        center=cent; 
    }

    public void changeCurrentPerson(){
        if(center.getNumber() <= 0){
            turn = !turn;
        }
        else if(center.getNumber() == )
    }

    public void drawCard(){
        if(turn){
            playerHand.add(drawingPile.pop()); 
        }
        else
            compHand.add(drawingPile.pop());
    }

    public void changeCurrentPerson(){
        if(center.getNumber() <= 9){
            turn = !turn;
        }
        //changes who's turn it is based on the number of the card
        //skips whoevers turn is next
        else if(center.getNumber() == 10){
            if(turn){
                System.out.println("Player's turn was skipped!");
            }
            else{
                System.out.println("Computer's turn was skipped!");
            }
        }
        //reverses the direction of the game
        else if(center.getNumber() == 11){
            if(turn){
                System.out.println("Direction was reversed back to Player");
            }
            else{
                System.out.println("Direction was reversed back to Computer");
            }
        }
        //forces whoevers next to draw 2 cards, then skips their turn
        else if(center.getNumber() == 12){
            turn = !turn;
            if(turn){
                System.out.println("Player must draw 2 cards");
            }
            else{
                System.out.println("Computer must draw 2 cards");
            } 
            drawCard();
            drawCard();
            turn = !turn;
        }
        //prints out whos turn it currently is
        if(turn){
            System.out.println("Player's turn");
        }
        else{
            System.out.println("Computer's turn");
        }
    }
 
 
    public void drawCard(){
        if(turn){
            playerHand.add(drawingPile.pop());
        }
        else{
            compHand.add(drawingPile.pop());
        }
    }
 


    
}
