import java.util.*;

public class Joseph {
    public int getResult(int n, int m) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            list.add(i+1);
        }
        int flag = 0;//用来判断是否需要出局
        int index = 0;//list的索引
        while(list.size()!=1){
            
            flag++;
            if(flag == m){
                list.remove(index);
                index--;
                flag = 0;//重置计数器
            }
            
            if(index==(list.size()-1)){//到达最后一位，那么重置index
                index = 0;
            }else{
                index++;
            }
            
        }
        
        return list.get(0);
    }
}