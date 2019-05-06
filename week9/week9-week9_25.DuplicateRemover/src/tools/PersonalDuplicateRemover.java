package tools;

import java.util.HashSet;
import java.util.Set;

public class PersonalDuplicateRemover implements DuplicateRemover{
    private Set<String> words;
    private int duplicates;

    public PersonalDuplicateRemover() {
        this.words = new HashSet<>();
        this.duplicates = 0;
    }

    @Override
    public void add(String characterString) {
        if(this.words.contains(characterString)){
            this.duplicates++;
        }
        this.words.add(characterString);
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        return this.duplicates;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        return this.words;
    }

    @Override
    public void empty() {
        this.duplicates = 0;
        this.words.clear();
    }

}
