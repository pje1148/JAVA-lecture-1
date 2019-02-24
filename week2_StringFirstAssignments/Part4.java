import edu.duke.*;
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part4 {
    public String getyoutubelink(){
        URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        String result = "";
        for (String s : ur.words()){
           String lowerS = s.toLowerCase();
           int youtubeindex = lowerS.indexOf("youtube.com");
           int firstQuotIndex = lowerS.indexOf("\"");
           int secondQuotIndex = lowerS.indexOf("\"", firstQuotIndex+1);
            if(youtubeindex != -1){
                String URL = s.substring(firstQuotIndex+1, secondQuotIndex);
                result = result + "\n" + URL;
            }
       }
    
    return result;
    }
    
    
    public void testgetyoutubelink(){
        String result = getyoutubelink();
        System.out.println(result);
    }
}
