package farmsimulator;

import java.util.Random;

public class Cow implements Milkable, Alive{
    private double udderCapacity; 
    private String name;
    private double amount;
    
    private static final String[] NAMES = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};

    public Cow() {
        this(NAMES[new Random().nextInt(NAMES.length)]);        
    }
    
    public Cow(String name) {
        this.name = name;
        this.udderCapacity = new Random().nextInt(26) + 15;
        this.amount = 0;
    }
    
    public String getName(){
        return this.name;
    }
    
    public double getCapacity(){   
        return this.udderCapacity;
    }
    
    public double getAmount(){
        return this.amount;
    }

    @Override
    public String toString() {
        return this.name + " " + Math.ceil(this.amount) + "/" + Math.ceil(this.udderCapacity);
    }

    @Override
    public double milk() {
        double milkToBeProcessed = this.amount;
        this.amount = 0;
        return milkToBeProcessed;
        
    }

    @Override
    public void liveHour() {
        double  min = 0.7;
        double  max = 2.0;
        double milkPerHour = new Random().nextDouble() * (max - min) + min;
        
        if(this.amount + milkPerHour < this.getCapacity()){
            this.amount += milkPerHour;
        }else {
            this.amount = this.udderCapacity;
        }
        
    }
    
    
    

    

}
