
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class Part1 {

    public int findStopCodon(String dna, int startIndex, String stopCodon){
      int currIndex = dna.indexOf(stopCodon, startIndex);
      while(currIndex != -1){
        if((currIndex - startIndex) % 3 == 0){
         return currIndex;
        }
        else {
         currIndex = dna.indexOf(stopCodon,currIndex+1);
        }
        }
      return dna.length();
    }

    public String findGene(String dna, int where){
        int startIndex = dna.indexOf("ATG", where);
        if(startIndex == -1){
            return "";
        }
        else{
            int taaIndex = findStopCodon(dna, startIndex, "TAA");
            int tagIndex = findStopCodon(dna, startIndex, "TAG");
            int tgaIndex = findStopCodon(dna, startIndex, "TGA");
            int minIndex = Math.min(tgaIndex, Math.min(taaIndex, tagIndex));
            if(minIndex != dna.length()){
                return dna.substring(startIndex, minIndex+3);
            }
            else{
                return "";
            }
        }
    }

    
    

    public void printAllGenes(String dna){
        int count = 0;
        int startIndex = 0;
        while(true){
            String currGene = findGene(dna, startIndex);
            if(currGene.isEmpty()){
               break;
            }
            //System.out.println(currGene);
            startIndex = dna.indexOf(currGene, startIndex) + currGene.length();
            System.out.println(startIndex);
            count ++;
        }
        System.out.println(count);
    }
    
    public void testprintAllGenes(){
        FileResource fr = new FileResource();
        String dna = fr.asString();
        printAllGenes(dna);
    }
    
        public void testFindGene(){
        String test1 = "AAAAAATAA";
        String test2 = "ATGAAAAAATAA";
        String test3 = "ATGAAAAAATAATGA";
        String test4 = "ATGAAAAATGA";
        String test5 = "ATGAAAAAAA";
        
        System.out.println("The gene of DNA1 " + test1 + " is " + 
                            findGene(test1, 0));
        System.out.println("The gene of DNA2 " + test2 + " is " + 
                            findGene(test2, 0));
        System.out.println("The gene of DNA3 " + test3 + " is " + 
                            findGene(test3, 0));
        System.out.println("The gene of DNA4 " + test4 + " is " + 
                            findGene(test4, 0));
        System.out.println("The gene of DNA5 " + test5 + " is " + 
                            findGene(test5, 0));
    }

        public void testFindStopCodon(){
        String test1 = "ATGAAATAA";
        String test2 = "ATGAATAA";
        String test3 = "";
        String test4 = "ATGAAAAAATAG";
    
        System.out.println("The index of StopCodon is " + 
                        findStopCodon(test1, 0, "TAA"));
        System.out.println("The index of StopCodon is " + 
                        findStopCodon(test2, 0, "TAA"));
        System.out.println("The index of StopCodon is " + 
                        findStopCodon(test3, 0, "TAA"));                  
        System.out.println("The index of StopCodon is " + 
                        findStopCodon(test4, 0, "TAG"));                       
    }

}