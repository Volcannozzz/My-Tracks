import java.util.*;

/*
public class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Point() {
        this.x = 0;
        this.y = 0;
    }
}*/
public class Bipartition {
    public double[] getBipartition(Point[] A, Point[] B) {
        // write code here
        double[] ac = getCenter(A);
        double[] bc = getCenter(B);
        
        double xl = (bc[1]-ac[1])/(bc[0]-ac[0]);
        
        double jj = (bc[1]-xl*bc[0]);
        
        double[] res = new double[2];
        res[1] = jj;
        res[0] = xl;
        
        return res;
        
        
    }
    
    public double[] getCenter(Point[] A){
        
        double x;
        double y;
        int sum = 0;
        
        for(int i =0;i<4;i++)
            {
            sum += A[i].x;
        }
        
        x = (double)sum/(double)4;
        
        sum=0;
        
        for(int i = 0;i<4;i++){
            sum+=A[i].y;
        }
        
        y = (double)sum/(double)4;
        
		double[] array=new double[2];
        array[0] = x;
        array[1] = y;
        
        return array;
        
    }
}