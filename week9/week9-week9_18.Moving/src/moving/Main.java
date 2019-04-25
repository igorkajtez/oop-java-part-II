package moving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import moving.domain.Box;
import moving.domain.Item;
import moving.domain.Thing;
import moving.logic.Packer;

public class Main {

    public static void main(String[] args) {
        List<Thing> things = new ArrayList<Thing>();
        things.add(new Item("passport", 2));
        things.add(new Item("toothbrash", 1));
        things.add(new Item("book", 4));
        things.add(new Item("circular saw", 8));

        Packer packer = new Packer(10);

        List<Box> boxes = packer.packThings(things);

        System.out.println("number of boxes: " + boxes.size());

        for (Box box : boxes) {
            System.out.println("  things in the box: " + box.getVolume() + " dm^3");
        }
        
        
    }
}