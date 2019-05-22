
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        FileManager t = new FileManager();
        
        List<String> list = new ArrayList<>();
        list.add("First line");
        list.add("Second line");
        list.add("Third line");
        
        t.save("src/MyFile.txt", list);

    }
}
