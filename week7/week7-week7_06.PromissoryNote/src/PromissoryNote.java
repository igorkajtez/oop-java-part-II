
import java.util.HashMap;

public class PromissoryNote {
    private HashMap<String, Double> map;
    
    public PromissoryNote(){
        this.map = new HashMap<String, Double>();
    }
    
    public void setLoan(String toWhom, double value){
        this.map.put(toWhom, value);
    }
    
    public double howMuchIsTheDebt(String whose){
        Double value = map.get(whose);        
        if(value == null){
            return 0;
        }
        
        return value;
    }

}
