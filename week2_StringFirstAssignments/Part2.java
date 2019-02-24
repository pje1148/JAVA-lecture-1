
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {

    public String FindSimpleGene(String dna, String startCodon, String stopCodon) {
        String result = "";
        int startIndex = dna.indexOf(startCodon);
        if(startIndex == -1){
            return "";
        }
        int stopIndex = dna.indexOf(stopCodon, startIndex+3);
        if(stopIndex == -1){
            return "";
        }
        String gene = dna.substring(startIndex, stopIndex+3);
        if(gene.length() % 3 != 0){
            return "";
        } 
        String allUpper = dna.toUpperCase();
        String allLower = dna.toLowerCase();
        if(allUpper != dna && allLower != dna){
            return "Input should be all uppercase or all lowercase";
        }
        result = gene;
        return result;
    }
    
    public void testSimpleGene() {
         //How can you define startCodon and stopCodon at first, and then 
         //make them apply to all tests below?
        
        String test1 = FindSimpleGene("ATCGTTT", "ATG", "TAA");
        String test2 = FindSimpleGene("CGTATGTTC", "ATG", "TAA");
        String test3 = FindSimpleGene("ACGTATTC", "ATG", "TAA");
        String test4 = FindSimpleGene("atgccgtAtctctaa", "atg", "taa");
        String test5 = FindSimpleGene("ATGCCGTATCTTAA", "ATG", "TAA");
        
        System.out.println("For test 1, gene is " + test1);
        System.out.println("For test 2, gene is " + test2);
        System.out.println("For test 3, gene is " + test3);
        System.out.println("For test 4, gene is " + test4);
        System.out.println("For test 5, gene is " + test5);
    }
}    
