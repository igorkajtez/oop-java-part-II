package containers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ContainerHistory {
    private List<Double> history;

    public ContainerHistory() {
        this.history = new ArrayList<>();
    }
    
    public void add(double situation){
        this.history.add(situation);
    }
    
    public void reset(){
        this.history.clear();
    }
    
    public double maxValue(){
        if(this.history.isEmpty()){
            return 0;
        }
        
        return Collections.max(this.history);
        
    }
    
    public double minValue(){
        if(this.history.isEmpty()){
            return 0;
        }
        
        return Collections.min(this.history);        
    }
    
    public double sum(){
        double sum = 0;
        for(double d : this.history){
            sum += d;
        }
        
        return sum;
    }
    
    public double average(){
        if(this.history.isEmpty()){
            return 0;
        }        
        
        return sum() / this.history.size();        
    }
    
    public double greatestFluctuation(){
        if(this.history.size() <= 1){
            return 0;
        }
        
        double fluctuation = 0;
        
        for (int i = 1; i < this.history.size(); i++) {
            double diff = Math.abs(this.history.get(i) - this.history.get(i - 1));
            
            if (diff > fluctuation) {
                fluctuation = diff;
            }            
        }
        
        return fluctuation;
    }
    
    public double variance(){
        if(this.history.size() <= 1){
            return 0;
        }
        
        double average = average();
        double variance = 0;
        
        for (Double d : this.history) {
            variance += Math.pow((d - average), 2);
        }
        variance /= (this.history.size() - 1);
       
        return variance;
    }

    @Override
    public String toString() {
        return this.history.toString();
    }
    
    
    
    

}
