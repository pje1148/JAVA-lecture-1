
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
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
    
    
   public int countGenes(String dna){
       int count = 0;
       int startIndex = 0;
       while(true){
        String currGene = findGene(dna, startIndex);
        if(currGene.isEmpty()){
            break;
        }
        startIndex = dna.indexOf(currGene, startIndex) + currGene.length();
        count++;
        }
       return count;
    }
   
   public void testCountGenes(){
       String test1 = "ATGAAATAAATGBBBTAGATGCCCTGA";
       String test2 = "ATGAAA";
       String test3 = "ATGAAATAABBATGBBBTAGCCATGCCCTGAATGAAATAABBATGBBBTAGCCATGCCCTGA";
       
       System.out.println(countGenes(test1) + " genes appears in " + test1);
       System.out.println(countGenes(test2) + " genes appears in " + test2);
       System.out.println(countGenes(test3) + " genes appears in " + test3);
    }
}
