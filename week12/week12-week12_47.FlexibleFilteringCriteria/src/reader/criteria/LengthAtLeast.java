package reader.criteria;
public class LengthAtLeast implements Criterion{
    int length;

    public LengthAtLeast(int length) {
        this.length = length;
    }

    @Override
    public boolean complies(String line) {       
        return line.length() >= this.length;
    }
    
    
    
    

}
