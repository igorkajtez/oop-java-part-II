package wordinspection;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("src/shortList.txt");
        WordInspection inspection = new WordInspection(file);
        System.out.println("Number of words: " + inspection.wordCount());
        System.out.println("Words containing Z: " + inspection.wordsContainingZ());
        System.out.println("Words ending in L: " + inspection.wordsEndingInL());
        System.out.println("Palindromes: " + inspection.palindromes());
        System.out.println("Words with all vowels: " + inspection.wordsWhichContainAllVowels());

    }
}
