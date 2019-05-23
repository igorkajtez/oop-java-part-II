package game;

import java.util.Random;

public class PersonalBoard extends gameoflife.GameOfLifeBoard {

    public PersonalBoard(int width, int height){
        super(width, height);
    }

    @Override
    public void initiateRandomCells(double d){
        Random random = new Random();
        
        for(int i = 0; i < super.getWidth(); i++){
            for(int j = 0; j < super.getHeight(); j++){
                super.getBoard()[i][j] = random.nextDouble() <= d;
            }
        }      
    }

    @Override
    public boolean isAlive(int x, int y){
        try{
            return super.getBoard()[x][y];
        }catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
    }

    @Override
    public void turnToLiving(int x, int y){
        try{
            super.getBoard()[x][y] = true;
        }catch(ArrayIndexOutOfBoundsException e){
            
        }
    }

    @Override
    public void turnToDead(int x, int y){
        try{
            super.getBoard()[x][y] = false;
        }catch(ArrayIndexOutOfBoundsException e){
            
        }
    }

    @Override
    public int getNumberOfLivingNeighbours(int x, int y){
        int living = ((super.getBoard()[x][y] == true) ? -1 : 0);  
        for(int i = x-1; i <= x+1; i++){
            for(int j = y-1; j <= y+1; j++){
                try{
                    if(super.getBoard()[i][j])
                        living++;
                }catch(ArrayIndexOutOfBoundsException e){
                    
                }
            }
        }
        return living;        
    }

    @Override
    public void manageCell(int x, int y, int livingNeighbours){
        if(livingNeighbours < 2 || livingNeighbours > 3){
            turnToDead(x, y);
        } else if(livingNeighbours == 3){
            turnToLiving(x, y);
        }
    }

}
