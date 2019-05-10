package containers;
public class ProductContainerRecorder extends ProductContainer{
    private ContainerHistory history;

    public ProductContainerRecorder(String productName, double capacity, double initialVolume) {
        super(productName, capacity);        
        this.history = new ContainerHistory();
        this.addToTheContainer(initialVolume);
    }
    
    public String history(){
        return this.history.toString();
    }

    @Override
    public void addToTheContainer(double amount) {
        super.addToTheContainer(amount); 
        this.history.add(super.getVolume());
    }

    @Override
    public double takeFromTheContainer(double amount) {
        double value = super.takeFromTheContainer(amount);
        this.history.add(this.getVolume());
        
        return value;        
    }
    
    public void printAnalysis(){
        System.out.println("Product: " + this.getName());
        System.out.println("History: " + history());
        System.out.println("Greatest product amount: " + this.history.maxValue());
        System.out.println("Smallest product amount: " + this.history.minValue());
        System.out.println("Average: " + this.history.average());
        System.out.println("Greatest change: " + this.history.greatestFluctuation());
        System.out.println("Variance: " + this.history.variance());
    }

}
