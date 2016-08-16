import java.util.*;

/*
public class UndirectedGraphNode {
    int label = 0;
    UndirectedGraphNode left = null;
    UndirectedGraphNode right = null;
    ArrayList<UndirectedGraphNode> neighbors = new ArrayList<UndirectedGraphNode>();

    public UndirectedGraphNode(int label) {
        this.label = label;
    }
}*/
public class Path {
    public boolean checkPath(UndirectedGraphNode a, UndirectedGraphNode b) {
        // write code here
        
			return check(a,b)||check(b,a);
    }
    
    public boolean check(UndirectedGraphNode a ,UndirectedGraphNode b)
        {
                if(a==b)
            {
            return true;
        }
        
        if(a==null||b==null)
            return false;
        
        Stack<UndirectedGraphNode> stack = new Stack<>();
        HashMap<UndirectedGraphNode,Boolean> map = new HashMap<>();
        
        stack.push(a);//从a开始
        map.put(a,true);//将a置为已遍历状态。
        
        while(!stack.empty())
            {
            UndirectedGraphNode currentnode = stack.pop();

			//下面从邻接表入手
            if(currentnode.neighbors!=null){
            for(int i = 0;i<currentnode.neighbors.size();i++)
                {
                UndirectedGraphNode node = currentnode.neighbors.get(i);
                
                if(node!=null)
                    {
                    if(node==b)
                        {
                        return true;
                    }
                    //如果栈里没有该点或该点没有遍历过
                    if(map.get(node)==null||!map.get(node))
                        {
                        stack.push(node);
                        map.put(node,true);
                    }
                }
            }
            }
            
            
            
        }
        return false;
    }
}