public class Change {
    private char character;
    private char newCharacter;
    
    public Change(char fromCharacter, char toCharacter){
        this.character = fromCharacter;
        this.newCharacter = toCharacter;
    }
    
    public String change(String characterString){
        String newString = "";        
        for (int i = 0; i < characterString.length(); i++) {
            if(characterString.charAt(i) == this.character){
                newString += this.newCharacter;
            }else {
                newString += characterString.charAt(i);
            }            
        }        
        return newString;
    }
    
//    Shorter method
//    public String change(String characterString) {
//        return characterString.replace(this.character, this.newCharacter);
//    }

}
