
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand implements Comparable<Hand>{
    private List<Card> cards;
    
    public Hand(){
        this.cards = new ArrayList<>();
    }
    
    public void add(Card card){
        this.cards.add(card);
    }
    
    public void print(){
       for(Card card : this.cards){
           System.out.println(card);
       } 
    }
    
    public void sort(){
        Collections.sort(this.cards);
    }
    
    public void sortAgainstSuit(){
        Collections.sort(this.cards, new SortAgainstSuitAndValue());
    }
    
    public int sumOfTheValues(){
        int sum = 0;
        
        for(Card card : this.cards){
            sum += card.getValue();
        }
        
        return sum;
    }

    @Override
    public int compareTo(Hand other) {
        return this.sumOfTheValues() - other.sumOfTheValues();
    }

}
