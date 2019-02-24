import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int totalPoints = 0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()){
            totalPoints = totalPoints + 1;
            prevPt = currPt;
        }
        return totalPoints;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double aveLength = getPerimeter(s) / getNumPoints(s);
        return aveLength;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        Point prevPt = s.getLastPoint();
        double largestSide = 0.0;
        for (Point currPt : s.getPoints()){
            double currDist = prevPt.distance(currPt);
            if(largestSide > currDist) {
                continue;
            }else {
                largestSide = currDist;
            }
            prevPt = currPt;
        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
        // Put code here
        Point prevPt = s.getLastPoint();
        int largestx = prevPt.getX();
        for (Point currPt : s.getPoints()){
            if(largestx > currPt.getX()) {
                continue;
            }else {
                largestx = currPt.getX();
            }
            prevPt = currPt;
        }
        return largestx;
    }
   
    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0.0;
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            if(largestPerim > getPerimeter(s)){
                continue;
            }else{
                largestPerim = getPerimeter(s);
            }
        }
        return largestPerim;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0.0;
        File temp = null;
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            if(largestPerim > getPerimeter(s)){
                continue;
            }else{
                largestPerim = getPerimeter(s);
                temp = f;
            }
        // replace this code
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int numPoints = getNumPoints(s);
        System.out.println("numpoints = " + numPoints);
        double averageLength = getAverageLength(s);
        System.out.println("averagelength = " + averageLength);
        double largestLength = getLargestSide(s);
        System.out.println("largest side length = " + largestLength);
        double largestx = getLargestX(s);
        System.out.println("largest x value = " + largestx);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = getLargestPerimeterMultipleFiles();
        System.out.println("largest perimeter = " + largestPerim);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        //DirectoryResource dr = new DirectoryResource();
        String largestPerimFile = getFileWithLargestPerimeter();
        System.out.println("file with largest perimeter = " + largestPerimFile);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testFileWithLargestPerimeter();
    }
}
