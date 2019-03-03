
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {

    public int howMany(String stringa, String stringb){
        int count = 0;
        int startIndex = 0;
        while(true){
            int currIndex = stringb.indexOf(stringa, startIndex);
            if(currIndex == -1){
                break;
            } 
            count++;
            startIndex = currIndex + stringa.length();
        }   
    return count;
    }


    public void testHowMany(){
        String string1a = "A";
        String string1b = "TAA";
        String string2a = "Smart";
        String string2b = "SmartSmartSmart";
        String string3a = "ATA";
        String string3b = "ATATATATAT";
        
        System.out.println(string1a + " appears " + howMany(string1a, string1b) + " times in " + string1b);
        System.out.println(string2a + " appears " + howMany(string2a, string2b) + " times in " + string2b);
        System.out.println(string3a + " appears " + howMany(string3a, string3b) + " times in " + string3b);
    }
}


