
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {

    public String FindSimpleGene(String dna) {
        String result = "";
        int startIndex = dna.indexOf("ATG");
        if(startIndex == -1){
            return "";
        }
        int stopIndex = dna.indexOf("TAA", startIndex+3);
        if(stopIndex == -1){
            return "";
        }
        String ATGtoTAA = dna.substring(startIndex, stopIndex+3);
        if(ATGtoTAA.length() % 3 != 0){
            return "";
        } 
        result = ATGtoTAA;
        return result;
    }
    
    public void testSimpleGene() {
        String test1 = FindSimpleGene("ATCGTTT");
        String test2 = FindSimpleGene("CGTATGTTC");
        String test3 = FindSimpleGene("ACGTATTC");
        String test4 = FindSimpleGene("ATGCCGTATCTCTAA");
        String test5 = FindSimpleGene("ATGCCGTATCTTAA");
        
        System.out.println("For test 1, gene is " + test1);
        System.out.println("For test 2, gene is " + test2);
        System.out.println("For test 3, gene is " + test3);
        System.out.println("For test 4, gene is " + test4);
        System.out.println("For test 5, gene is " + test5);
    }
}    
