package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MindfulDictionary {
    private Map<String, String> dictionary;
    private Map<String, String> reverseDictionary;
    private File file;

    public MindfulDictionary() {
        this.dictionary = new HashMap<>();
        this.reverseDictionary = new HashMap<>();
    }
    
    public MindfulDictionary(String file){
        this();
        this.file = new File(file);
    }
    
    public void add(String word, String translation){
        if(!this.dictionary.containsKey(word)){
            this.dictionary.put(word, translation);
            this.reverseDictionary.put(translation, word);
        }
    }
    
    public String translate(String word){
        
        if(this.dictionary.containsKey(word)){
            return this.dictionary.get(word);
        }
        
        if(this.reverseDictionary.containsKey(word)){
            return this.reverseDictionary.get(word);
        } 
        
        return null;
    }
    
    public void remove(String word){
        if(this.dictionary.containsKey(word)){
            String translation = this.dictionary.get(word);
            this.dictionary.remove(word);
            this.reverseDictionary.remove(translation);
        }
        
        if(this.reverseDictionary.containsKey(word)){
            String translation = this.reverseDictionary.get(word);
            this.reverseDictionary.remove(word);
            this.dictionary.remove(translation);
        }
    }
    
    public boolean load() {
        try{
            Scanner reader = new Scanner(this.file);
        
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                String[] parts = line.split(":");
            
                add(parts[0], parts[1]);
            }
            
        }catch(FileNotFoundException exc){
            return false;
        }
        
        return true;
    }
    
    public boolean save(){
        try{
            FileWriter fw = new FileWriter(this.file);
            
            for(String word : this.dictionary.keySet()){
                fw.write(word + ":" + this.dictionary.get(word) + "\n");
            }
            
            fw.close();
            
        }catch(IOException exc){
            return false;
        }
        
        return true;
    }
    
    
    

}
