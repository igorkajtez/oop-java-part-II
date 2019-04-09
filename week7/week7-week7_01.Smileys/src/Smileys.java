
public class Smileys {

    public static void main(String[] args) {
        printWithSmileys("Method");
        printWithSmileys("Beerbottle");
        printWithSmileys("Interface");        
    }
    
    private static void printWithSmileys(String characterString){
        String middleString = createMiddleString(characterString);
        int number = middleString.length() / 2 + 2;
        
        printLine(number);        
        System.out.println(":)" + middleString + ":)");        
        printLine(number);
    }
    
    private static void printLine(int number){        
        for(int i = 0; i < number; i++){
            System.out.print(":)");
        }
        System.out.println("");        
    }
    
    private static String createMiddleString(String characterString){
        String result = " " + characterString + " ";
        if(characterString.length() % 2 == 1){
            return result + " ";
        }
        return result;
    }

}
