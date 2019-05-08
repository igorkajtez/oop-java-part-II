
public class Bird {

    private String name;
    private String latinName;
    private int ringingYear;

    public Bird(String name, String latinName, int ringingYear) {
        this.name = name;
        this.latinName = latinName;
        this.ringingYear = ringingYear;
    }

    @Override
    public boolean equals(Object obj) {
        
        Bird other = (Bird)obj;
        
        if(this.latinName==null){
            return false;
        }
        
        return this.latinName.equals(other.latinName) && this.ringingYear==other.ringingYear;        
    }

    @Override
    public int hashCode() {
        if(this.latinName==null){
            return this.ringingYear;
        }
        
        return this.latinName.hashCode() + this.ringingYear;
    }
    
    
    
    


    @Override
    public String toString() {
        return this.latinName + " (" + this.ringingYear + ")";
    }
}


