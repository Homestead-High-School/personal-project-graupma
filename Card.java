import java.io.IOException;
public class Card{
    private String curColor; //red, blue, green, yellow, wild
    private int curNum; //0-9, 10==skip, 11== change direction, 12== +2, 13==change color, 14== change color +4


    public Card(String col, int num){
        curColor=col;
        curNum=num;
    }

    //getters
    public String getColor(){
        return curColor;
    }

    public int getNumber(){
        return curNum;
    }

    //setters
    public void setColor(String col){
        curColor=col; 
    }

    public void setNumber(int num){
        curNum=num; 
    }

    public String toString(){
        return curColor + " "  + curNum; 
    }

    
}