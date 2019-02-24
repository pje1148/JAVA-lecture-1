
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {

    public boolean twoOccurrences(String stringa, String stringb){
        boolean result = true;
        int firstIndex = stringb.indexOf(stringa);
        if(firstIndex == -1){
            return false;
        }
        int secondIndex = stringb.indexOf(stringa, firstIndex+stringa.length());
        if(secondIndex == -1){
            return false;
        } 
        return result;
    }
    
    public void testtwoOccurrences(){
        boolean test1 = twoOccurrences("ab", "ababab");
        boolean test2 = twoOccurrences("ab", "aba");
        boolean test3 = twoOccurrences("ab", "ab");
        boolean test4 = twoOccurrences("ab", "abcd");
        
        System.out.println(test1);
        System.out.println(test2);
        System.out.println(test3);
        System.out.println(test4);
    }

    public String lastPart(String stringa, String stringb){
        String result = "";
        int firstIndex = stringb.indexOf(stringa);
        if(firstIndex !=
        
        
        
    }
}