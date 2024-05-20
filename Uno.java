import java.util.*;

public class Uno {
    Map<String, Card> drawingPile;
    Map<String, Card> discardPile;
    Map<String, Card> playerHand; 
    Map<String, Card> compHand;
    int cardsLeft; //what is this referring to
    String centerCol; //top of the discard pile- should this be a Card variable instead with centerNum?
    int centerNum;
    boolean turn; //true= player, false==computer




//in constructor need to initialize drawing pile to have all 112 cards and then from there go and deal- remove from drawing pile and place in hand
public Uno(){
    drawingPile= new TreeMap<>(); 

    
    String[] colors = {"red", "blue", "green", "yellow"};

    //adds cards to drawingPile in 4 colors and numbers 1-12
    for(int i=0; i<colors.length; i++){
String col=colors[i];
for(int i=0; i<13; i++){
    drawingPile.put(col.substring(0,1) + i, new Card(col, i));
}


}
//add black 13 and 14, color changers - 4 color changers, 4 +4 & change
for(int i=0; i<5; i++ ){
drawingPile.put("b"+ 13, new Card("black", 13));
drawingPile.put("b"+ 14, new Card("black", 14) );
}

discardPile= new TreeMap<>();

//still need to deal cards to player and computer. random and then check if thats already been given?




}




}
