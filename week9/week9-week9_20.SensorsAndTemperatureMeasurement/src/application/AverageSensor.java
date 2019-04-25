package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor{
    private List<Sensor> sensors;
    private List<Integer> averages;

    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.averages = new ArrayList<>();
    }

    @Override
    public boolean isOn() {
        for(Sensor sensor : this.sensors){
            if(sensor.isOn()){
                return true;
            }
        }
        return false;
    }

    @Override
    public void on() {
        for(Sensor sensor : this.sensors){
            sensor.on();
        }
    }

    @Override
    public void off() {
        for(Sensor sensor : this.sensors){
            sensor.off();
        }
    }

    @Override
    public int measure() {
        
        if(this.sensors.isEmpty()){
            throw new IllegalStateException();
        }
        
        if(!this.isOn()){
            throw new IllegalStateException();
        }        
        
        int avg = 0;
        for(Sensor sensor : this.sensors){
            avg += sensor.measure();
        }
        
        avg /= this.sensors.size();
        this.averages.add(avg);
        return avg;
    }
    
    public void addSensor(Sensor additional){
        this.sensors.add(additional);
    }
    
    public List<Integer> readings(){
        return this.averages;
    }
    
    

}
