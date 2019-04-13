
import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> words;
    
    public Dictionary(){
        this.words = new HashMap<String, String>();
    }
    
    public String translate(String word){
        String translated = this.words.get(word);
        if(translated == null){
            return null;
        }
        
        return translated;
    }
    
    public void add(String word, String translation){
        this.words.put(word, translation);
    }
    
    public int amountOfWords(){
        return this.words.size();
    }
    
    public ArrayList<String> translationList(){
       ArrayList<String> list = new ArrayList<String>();
       
       for(String key : this.words.keySet()){
           list.add(key + " = " + this.words.get(key));
       }
       return list;
    }

}
