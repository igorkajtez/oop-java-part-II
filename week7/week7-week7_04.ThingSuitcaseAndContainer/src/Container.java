
import java.util.ArrayList;

public class Container {

    private ArrayList<Suitcase> suitcases;
    private int maxWeightLimit;
    private int totalWeight;

    public Container(int maxWeightLimit) {
        this.maxWeightLimit = maxWeightLimit;
        this.suitcases = new ArrayList<Suitcase>();
        this.totalWeight = 0;
    }

    public void addSuitcase(Suitcase suitcase) {
        if (this.totalWeight + suitcase.totalWeight() > this.maxWeightLimit) {
            return;
        }
        this.suitcases.add(suitcase);
        this.totalWeight += suitcase.totalWeight();
    }
    
    public void printThings(){
        for(Suitcase suitcase : this.suitcases){
            suitcase.printThings();
        }
    }

    @Override
    public String toString() {
        return "" + this.suitcases.size() + " suitcases" + " (" + this.totalWeight + " kg)";
    }

}
