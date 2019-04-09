
import java.util.Scanner;

public class Reader {
    private Scanner reader;
    
    public Reader(){
        this.reader = new Scanner(System.in);
    }
    
    public String readString(){
        String s = this.reader.nextLine();
        return s;
    }
    
    public int readInteger(){
        int i = Integer.parseInt(this.reader.nextLine());
        return i;
    }

}
