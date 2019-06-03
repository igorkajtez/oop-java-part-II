package reference.domain;
public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }

     @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()){
            return false;
        }
        return this.name.equals(obj.toString()); 
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
    
    
    
    

}
