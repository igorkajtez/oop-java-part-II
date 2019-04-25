package application;

import java.util.Random;

public class Thermometer implements Sensor{
    private Random random = new Random();
    private boolean isOn;

    public Thermometer() {
        this.isOn = false;
    }

    @Override
    public boolean isOn() {
        return this.isOn;
    }

    @Override
    public void on() {
        this.isOn = true;
    }

    @Override
    public void off() {
        this.isOn = false;
    }

    @Override
    public int measure() {       
        if(!isOn()){
            throw new IllegalStateException();
        }
        
        int temp = random.nextInt(30 + 1 + 30) - 30;        
        return temp;
    }
    
    

}
