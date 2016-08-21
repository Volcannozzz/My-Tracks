import java.util.*;

public class MagicIndex {
    public boolean findMagicIndex(int[] A, int n) {
        // write code here
        if(findOne(A,0,n-1)!=-1)
            return true;
        return false;
    }
    public int findOne(int[] array,int start,int end){
        int mid = (start+end)/2;
        
        if(end<start||start<0||end>array.length)
            return -1;
        
        if(array[mid]==mid)
            return mid;
        if(array[mid]>mid)
            return findOne(array,start,mid-1);
        
        return findOne(array,mid+1,end);
    }
}