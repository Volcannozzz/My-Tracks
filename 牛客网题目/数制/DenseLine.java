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
public class DenseLine {
    public double[] getLine(Point[] p, int n) {
               HashMap<Line,Integer> lineNum=new HashMap<Line,Integer>();
       int max=0;
       double slope=Double.POSITIVE_INFINITY,intercept=0;
       //把所有线取出来求出斜率和截距,并用哈希图存储下线条和个数的键值对
       for(int i=0;i<n;i++){
           for(int j=0;j<n;j++){
               double k=(double)(p[j].y-p[i].y)/(p[j].x-p[i].x);
               double b=(double)(p[i].y-k*p[i].x);
               Line line=new Line(k,b);
               if(lineNum.containsKey(line)){
                   int num=lineNum.get(line)+1;
                   lineNum.put(line,num);
                   //不断调整最大值
                   if(num>max){
                       max=num;
                       slope=k;
                       intercept=b;
                   }
               }
               else
                   lineNum.put(line,1);
           }
       }
       return new double[]{slope,intercept};
        // write code here
    }
    
}
class Line{
        
        double k;
        double b;
        
        Line(double k,double b){
            this.k = k;
            this.b = b;
        }
        
        public boolean isEqualValue(double a,double b){
            
            return (Math.abs(a-b)<0.00001);
        }
        
        public boolean equals(Object object){
            
            if(object instanceof Line)
                {
                if(isEqualValue(k,((Line)object).k)&&isEqualValue(b,((Line)object).b))
                    return true;
                return false;
            }
            
            return super.equals(object);
        }
        
        public int hashCode(){
            String str = String.valueOf(k)+String.valueOf(b);
            return str.hashCode();
        }
        
    }