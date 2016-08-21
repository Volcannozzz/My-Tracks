import java.util.*;

public class Parenthesis {
    public boolean chkParenthesis(String A, int n) {
        // write code here
        Stack<Character> stack = new Stack<Character>();
        
        return judge(A,stack,n);
    }
    
    public boolean judge(String string,Stack<Character> stack,int n){
        
        for(int i = 0;i<n;i++){
                    
            if(i==0){
            	stack.push(string.charAt(i));
            	continue;
       		}
            
            else if(!stack.isEmpty()&&stack.peek()=='('&&string.charAt(i)==')'){
                stack.pop();
            }
            else{
                stack.push(string.charAt(i));
            }
        }
        
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
        
    }
}