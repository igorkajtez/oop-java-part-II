
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RingingCentre {
    private Map<Bird, List<String>> observations;
    

    public RingingCentre() {
        this.observations = new HashMap<Bird, List<String>>();
    }
    
    public void observe(Bird bird, String place){
        
        if(!this.observations.containsKey(bird)){
            this.observations.put(bird, new ArrayList<String>());
        }
        
        this.observations.get(bird).add(place);
        
    }
    
    public void observations(Bird bird){
        int timesObserved = 0;
        
        if(this.observations.containsKey(bird)){
            timesObserved = this.observations.get(bird).size();
        }
        
        System.out.println(bird + " observations: " + timesObserved);
        
        if(this.observations.containsKey(bird)){
            for(String place : this.observations.get(bird)){
                System.out.println(place);
            }
        }
        
        
    }
    
    

}
