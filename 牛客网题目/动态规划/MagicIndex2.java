import java.util.*;

public class MagicIndex {
    public boolean findMagicIndex(int[] A, int n) {
        // write code here
        if(find(A,0,n-1)!=-1)
            return true;
        
        return false;
        
    }
    
    public int find(int[] array,int start,int end){
        if(start>end||start<0||end>=array.length){
            return -1;
        }
        int mid = (start+end)/2;
        int midV = array[mid];
        if(midV==mid){
            return midV;
        }
        int leftIndex = Math.min(mid-1,midV);
        int rightIndex = Math.max(mid+1,midV);
        
        int left = find(array,start,leftIndex);
        
        if(left>=0)
            return left;
        
        int right = find(array,rightIndex,end);
        
        return right;
        
        
        
        
    }
}