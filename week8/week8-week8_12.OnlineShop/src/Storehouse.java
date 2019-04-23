
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Storehouse {
    private Map<String, Integer> prices;
    private Map<String, Integer> stocks;
    
    public Storehouse(){
        this.prices = new HashMap<>();
        this.stocks = new HashMap<>();
    }
    
    public void addProduct(String product, int price, int stock){
        this.prices.put(product, price);
        this.stocks.put(product, stock);
    }
    
    public int price(String product){
        if(this.prices.containsKey(product)){
            return this.prices.get(product);
        }else{
            return -99;
        }        
    }
    
    public int stock(String product){
        if(this.stocks.containsKey(product)){
            return this.stocks.get(product);
        }else{
            return 0;
        } 
    }
    
    public boolean take(String product){
        if(this.stocks.containsKey(product) && this.stocks.get(product) > 0){
            this.stocks.put(product, this.stocks.get(product)-1);
            return true;
        }
        
        return false;
    }
    
    public Set<String> products(){
        return this.prices.keySet();
    }

}
