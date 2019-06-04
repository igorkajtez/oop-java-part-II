package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    private Worm worm;
    private Apple apple;
    private Random random;

    public WormGame(int width, int height) {
        super(1000, null);

        this.width = width;
        this.height = height;
        this.continues = true;
        
        this.worm = new Worm(width/2, height/2, Direction.DOWN);        
        this.apple = new Apple(new Random().nextInt(this.width), new Random().nextInt(this.height));
        
        while(this.worm.runsInto(this.apple)){
            this.apple = new Apple(new Random().nextInt(this.width), new Random().nextInt(this.height));
        }

        addActionListener(this);
        setInitialDelay(2000);
    }


    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!continues) {
            return;
        }
        
        this.worm.move();
        
        if(this.worm.runsInto(this.apple)){
            this.worm.grow();
            
            while(this.worm.runsInto(this.apple)){
                this.apple = new Apple(new Random().nextInt(this.width), new Random().nextInt(this.height));
            }
            
        }else if(this.worm.runsIntoItself()){
            this.continues = false;
        }else if(this.worm.head().getX() == this.width || this.worm.head().getX() < 0){
            this.continues = false;
        }else if(this.worm.head().getY() == this.height || this.worm.head().getY() < 0){
            this.continues = false;
        }
        
        this.updatable.update();
        setDelay(1000 / this.worm.getLength());

    }
    
    public Worm getWorm(){
        return this.worm;
    }
    
    public void setWorm(Worm worm){
        this.worm = worm;
    }
    
    public Apple getApple(){
        return this.apple;
    }
    
    public void setApple(Apple apple){
        this.apple = apple;
    }

}
