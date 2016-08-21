import java.util.*;

public class Permutation {
    public ArrayList<String> getPermutation(String A) {
        // write code here
        if(A==null){
            return null;
        }
        ArrayList<String> per = new ArrayList<String>();
        
        if(A.length()==0){
            
            per.add("");
            return per;
            
        }
        
        char first = A.charAt(0);
        
        String remainer = A.substring(1);
        
        ArrayList<String> words = getPermutation(remainer);
        
        for(String word:words){
            for(int i = 0;i<=word.length();i++){
                String s = insertCharAt(word,first,i);
                per.add(s);
            }
			
        }
        Collections.sort(per);
        Collections.reverse(per);
        
        return per;
    }
    
    public String insertCharAt(String word,char c,int i ){
        String start = word.substring(0,i);
        String end = word.substring(i);
        return start+c+end;
    }
}