package movable;

import java.util.ArrayList;
import java.util.List;

public class Group implements Movable{
    private List<Movable> group;

    public Group() {
        this.group = new ArrayList<>();                
    }
    
    public void addToGroup(Movable movable){
        this.group.add(movable);
        
    }

    @Override
    public String toString() {
        String output = "";
        for(Movable movable : this.group){
            output += movable.toString() + "\n";
        }
        return output;
    }

    @Override
    public void move(int dx, int dy) {
        for(Movable movable : this.group){
            movable.move(dx, dy);
        }
    }

}
