import java.util.*;

public class Queens {
    public int nQueens(int n) {
        // write code here
        int[] res = new int[1];
        int[] location = new int[n+1];
        getRes(n,1,location,res);
        return res[0];
        
    }
    
    
    //n是皇后总数，i代表列，location数组用于存储每一列皇后的位置，res用来统计方法总数
    public void getRes(int n,int i,int[] location,int[] res){
        
        if(i>n){
            res[0]++;
            return;
        }
        for(int j = 1;j<=n;j++){
            location[i] = j;
            if(judge(location,i)){
                getRes(n,i+1,location,res);
            }
        }
        
    }
    
    //判断是否冲突
    public boolean judge(int[] location,int i ){
        
        for(int j = 1;j<i;j++){
            if(location[j]==location[i]||(location[i]-location[j]==i-j)||(location[i]-location[j]==j-i)){
                return false;
            }
        }
        
        return true;
        
    }
}