package wordinspection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordInspection {
    private File file;
    private List<String> words;

    public WordInspection(File file) throws FileNotFoundException {
        this.file = file;
        this.words = new ArrayList<>();
        readFile();
        
    }
    
    public void readFile() throws FileNotFoundException{
        Scanner reader = new Scanner(this.file, "UTF-8");
        while(reader.hasNext()){
            String word = reader.nextLine();
            this.words.add(word);
        }
        
        
    }
    
    public int wordCount() throws FileNotFoundException{               
        return this.words.size();
    }
    
    public List<String> wordsContainingZ() throws FileNotFoundException{
        List<String> wordsWithZ = new ArrayList<>();
        
        for(String word : this.words){
            if(word.contains("z")){
                wordsWithZ.add(word);
            }
        }        
        
        return wordsWithZ;
    }
    
    public List<String> wordsEndingInL(){
        List<String> wordsEndingWithL = new ArrayList<>();
        
        for(String word : this.words){
            if(word.endsWith("l")){
                wordsEndingWithL.add(word);
            }
        } 
        
        return wordsEndingWithL;        
    }
    
    public List<String> palindromes(){
        List<String> palindromes = new ArrayList<>();
        
        for(String word : this.words){
            String palindrome = "";
            
            for(int i = word.length()-1; i >= 0; i--){
                palindrome += word.charAt(i);                
            } 
            
            if(word.equals(palindrome)){
                palindromes.add(word);
            }
        }
        
        return palindromes;
    }
    
    public List<String> wordsWhichContainAllVowels(){
        List<String> wordsWithAllVowels = new ArrayList<>();
        
        for(String word : this.words){   
            char[] vowels = "aeiouyäö".toCharArray();
            boolean allVowels = true;
            
            for(char vowel : vowels){
                if(!word.contains("" + vowel)){
                    allVowels = false;
                    break;
                }
            }
            
            if(allVowels){
                wordsWithAllVowels.add(word);
            }           
        }
        
        return wordsWithAllVowels;
    }
    

}
