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
        int num = c.getNumber();
        if(c.getColor().equals(center.getColor()) || num == center.getNumber() || num == 13 || num == 14){
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
 
    public boolean checkWin(){
       if(playerHand.isEmpty() || compHand.isEmpty()){
           return true;
       }
       return false;
    }

    public boolean checkValidCard(Card c, ArrayList<Card> a){
        boolean ret = false;
        for(int i=0; i<a.size(); i++){
            if((a.get(i).getColor().equals(c.getColor())) && (a.get(i).getNumber() == (c.getNumber())))
            ret=true;
        }
        return ret;
    }

    public Card createTempCard(String p){
        String te=p.substring(0,1).toLowerCase();
        String col ="";
    

        if(te.equals("r"))
            col="red";
        else if( te.equals("y"))
            col="yellow";
        else if( te.equals("g"))
            col="green";
        else if( te.equals("b"))
            col="blue";
        else if( te.equals("w"))
            col="white";


        int tn= Integer.valueOf(p.substring(1));
        return new Card(col, tn);

    }

    public boolean checkValColor(String col){
        if(col.equals("r") || col.equals("y") || col.equals("b") || col.equals("g") || col.equals("w"))
            return true;
        else
            return false; 
        
    }

    public void rules(){
        System.out.println("\tObjective:");
        System.out.println("\t\tBe the first player to use all of your cards");
        System.out.println("\tRules:");
        System.out.println("\t\t1. Both players are dealt 7 cards at the start of the game");
        System.out.println("\t\t2. After cards have been dealt, a final card will be drawn and will act as both the bottom of the discard pile and as the card to base the first move on");
        System.out.println("\t\t3. The card played must match either the color or the number of the top card of the discard pile");
        System.out.println("\t\t4. A wild card may be played as any color and any number");
        System.out.println("\t\t5. If a skip is played, the next player's turn will be skipped");
        System.out.println("\t\t6. If a reverse is played, the next player's turn will be skipped");
        System.out.println("\t\t7. If a +2 is played, the next player must draw 2 cards and their turn will be skipped");
        System.out.println("\t\t8. If a wild card is played, the current player must choose a new color and their turn is over");
        System.out.println("\t\t9. If a wild +4 card is played, the current player must choose a new color, the next player must draw 4 cards, and the next player's turn is skipped");
    }
    
    public void play(){  
        printPlayerHand();
        System.out.println("The top card is: " + center.toString());
        Scanner temp = new Scanner(System.in);
        System.out.println("\tNumbers: 0-9, 10 = skip, 11 = reverse, 12 = +2, w13 = wild, w14 = wild +4");
        System.out.println("\tColors: red = r, yellow = y, green = g, blue = b, wild = w");
        System.out.println("What card would you like to play? (ex: r7 or draw)");
        String p= temp.nextLine();
        
        if(p.equalsIgnoreCase("draw")){
            drawCard();
        }

        Card played = createTempCard(p); 
        
        while(!checkValidCard(played, playerHand)){
            System.out.println("Error. please enter a valid card.");

            System.out.println("What card would you like to play? (ex: r7 or draw)");
        String p= temp.nextLine();
        
        if(p.equalsIgnoreCase("draw")){
            drawCard();
        }

        

        

        played = createTempCard(p); 
    }

    //now the card is a valid card in the hand

    if(validPlay(played)){
    //check what type of card it is and deal with it accordingly 
    if(played.getColor().equals("white")){
        Scanner myS= new Scanner(System.in);
        System.out.println("What color would you like to change it to? ");
        String colTemp= myS.nextLine();
        while(!checkValColor(colTemp)) {
            System.out.println("Error. Invalid color.");
            System.out.println("What color would you like to change it to? ");
            colTemp= myS.nextLine();
        }
        changeColor(colTemp); 

        if(played.getNumber()==14){
            turn = !turn;
            for(int i=0; i<4; i++){
                drawCard();
            }
            turn = !turn;
        }
    }
    center= played; 
    changeCurrentPerson(); 

    }

    }

    
}
