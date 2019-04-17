
public class RegistrationPlate {

    private final String regCode;
    private final String country;

    public RegistrationPlate(String country, String regCode) {
        this.regCode = regCode;
        this.country = country;
    }
    
    public String getRegCode(){
        return this.regCode;
    }
    
    public String getCountry(){
        return this.country;
    }

    @Override
    public String toString() {
        return country + " " + regCode;
    }  

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        
        if(this.getClass() != obj.getClass()){
            return false;
        }
        
        RegistrationPlate compared = (RegistrationPlate)obj;
        
        if(this.regCode == null || !this.regCode.equals(compared.getRegCode())){
            return false;
        }
        
        if(this.country == null || !this.country.equals(compared.getCountry())){
            return false;
        }
        
        return true;        
    }

    @Override
    public int hashCode() {
        if(this.country == null){
            return 1;
        }
        if(this.regCode == null){
            return 2;
        }
        
        return this.country.hashCode() + this.regCode.hashCode();
    }
    
    

}
