package wormgame.domain;

import java.util.ArrayList;
import java.util.List;
import wormgame.Direction;

public class Worm {
    private int originalX;
    private int originalY;
    private Direction originalDirection;
    private List<Piece> pieces;
    private boolean grow;

    public Worm(int originalX, int originalY, Direction originalDirection) {
        this.originalX = originalX;
        this.originalY = originalY;
        this.originalDirection = originalDirection;
        this.pieces = new ArrayList<Piece>();
        this.pieces.add(new Piece(originalX, originalY));
    }
    
    public Direction getDirection(){
        return this.originalDirection;
    }
    
    public void setDirection(Direction dir){
        this.originalDirection = dir;
    }
    
    public int getLength(){
        return this.pieces.size();
    }
    
    public List<Piece> getPieces(){
        return this.pieces;
    }
    
    public void move(){
        
        if(getLength() < 3){
            grow();
        }
        
        Piece head = head();
        
        int newX = head.getX();
        int newY = head.getY();
        
        if(this.originalDirection == Direction.RIGHT){
            newX++;
        }else if(this.originalDirection == Direction.LEFT){
            newX--;
        }else if(this.originalDirection == Direction.DOWN){
            newY++;
        }else{
            newY--;
        }
        
        this.pieces.add(new Piece(newX, newY));
        
        if(!this.grow){
            this.pieces.remove(0);
        }else{
            this.grow = false;
        }
    }
    
    public void grow(){         
        this.grow = true; 
    }
    
    public boolean runsInto(Piece piece){
        for(Piece p : this.pieces){
            if(p.getX() == piece.getX() && p.getY() == piece.getY()){
                return true;
            }
        }
        return false;
    }
    
    public boolean runsIntoItself(){
        for(Piece p1 : this.pieces){
            for(Piece p2 : this.pieces){
                
                if(p1 == p2){
                    continue;
                }
                
                if(p1.getX() == p2.getX() && p1.getY() == p2.getY()){
                    return true;
                }
                
            }           
        }
        
        return false;
    }
    
    public Piece head(){
        return this.pieces.get(this.pieces.size() - 1);
    }
}
