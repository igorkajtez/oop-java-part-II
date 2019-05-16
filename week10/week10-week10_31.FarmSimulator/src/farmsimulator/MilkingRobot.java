package farmsimulator;
public class MilkingRobot {
    private BulkTank tank;
    
    public BulkTank getBulkTank(){
        return this.tank;
    }
    
    public void setBulkTank(BulkTank tank){
        this.tank = tank;
    }
    
    public void milk(Milkable milkable){
        if(this.tank == null){
            throw new IllegalStateException("The MilkingRobot hasn't been installed");
        }
        
        double milk = milkable.milk();
        this.tank.addToTank(milk);
    }
    
    

}
