package boxes;

import java.util.ArrayList;
import java.util.List;

public class OneThingBox extends Box{
    private List<Thing> things;

    public OneThingBox() {
        this.things = new ArrayList<>();
    }

    @Override
    public void add(Thing thing) {
        if(this.things.size() < 1){
            this.things.add(thing);
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return this.things.contains(thing);
    }
    
    

}
