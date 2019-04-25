
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Printer {
    private File file;
    private List<String> lines;

    public Printer(String filename) throws FileNotFoundException {
        this.file = new File(filename);
        Scanner reader = new Scanner(file);
        this.lines = new ArrayList<>();
        
        while(reader.hasNextLine()){
            lines.add(reader.nextLine());
        }
        
    }
    
    public void printLinesWhichContain(String word) throws FileNotFoundException{
        
        for(String line : this.lines){
            if(word.isEmpty() || line.contains(word)){
                System.out.println(line);
            }
        }
    }
    
    

}
