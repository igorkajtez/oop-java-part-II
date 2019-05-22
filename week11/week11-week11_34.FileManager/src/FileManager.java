
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    public List<String> read(String file) throws FileNotFoundException {
        List<String> lines = new ArrayList<>();
        Scanner reader = new Scanner(new File(file));
        
        while(reader.hasNext()){
            lines.add(reader.nextLine());
        }
        
        return lines;
    }

    public void save(String file, String text) throws IOException {
        FileWriter fw = new FileWriter(file);
        fw.write(text);
        fw.close();
    }

    public void save(String file, List<String> texts) throws IOException {
        FileWriter fw = new FileWriter(file);
        
        for(String line : texts){
            fw.write(line + "\n");            
        }
        
        fw.close();
    }
}
