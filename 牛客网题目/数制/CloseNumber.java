import java.util.*;

public class CloseNumber {
    public int[] getCloseNumber(int x) {
        // write code here
 		int[] a = new int[2];
        
        a[1] = getbig(x);
        a[0] = getsmall(x);
        
        return a;
        
    }
    
    public int getbig(int x)
        {
        int c0 = 0;
        int c11= 0;
        int temp1 = x;
        int temp2 = x;
        //得到拖尾0的个数
        while((temp1&1)==0&&(temp1!=0))
            {
            c0++;
            temp1>>=1;
        }
        //得到拖尾0左边1的个数
        while(((temp1&1)==1)&&(temp1!=0))
            {
            c11++;
            temp1>>=1;
        }
        
        int p  =c0+c11;
        
        temp2|=(1<<p);  //最右边非拖尾0置为1
        
        temp2&=~((1<<p)-1);//p右方所有位清零
        
        temp2|=(1<<(c11-1))-1;
        
        return temp2;
        
    }
    
    public int getsmall(int x)
        {
        
        int temp1 = x;
        int temp2 = x;
        
        int c1 = 0;//拖尾1的个数
        int c00 = 0;//拖尾1左边连续0的个数
        
        while((temp1&1)==1){
            
            c1++;
            temp1>>=1;
            
        }
        
        while((temp1&1)==0&&(temp1!=0)){
            c00++;
            temp1>>=1;
        }
        
        int p = c1+c00;
        
        temp2&=((~0)<<(p+1));
        
        int mask = (1<<(c1+1))-1;
        
        temp2|=mask<<(c00-1);
        
		return temp2;        
        
    }
}