import java.util.*;

public class AddSubstitution {
    public int calc(int a, int b, int type) {
        // write code here
        if(type==1)
            return mul(a,b);
        
        else if(type==0)
            return division(a,b);
        
        else
            return subtraction(a,b);
        
    }
    
    public int subtraction(int a,int b){
        return a+(-b);
    }
    
    public int mul(int a,int b){
        
        int res = 0;
        for(int i = 0;i<b;i++){
            res+=a;
        }
        return res;
    }
    
    public int division(int a,int b){
        
        int i = 0;
        int res=0;
        for(i = 0;res <a;i++){
            
            res+=b;
            
        }
        
        return --i;
        
        
    }
}