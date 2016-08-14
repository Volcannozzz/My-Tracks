import java.util.*;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/
public class Checker {
    public boolean checkBST(TreeNode root) {
        // write code here
        
        if(root==null)
            return true;
        
        if(root.left!=null)
            {
            if(root.left.val>root.val)
                return false;
            if(root.left.right!=null&&root.left.right.val>root.val)
                return false;
        }
        
        if(root.right!=null)
            {
            if(root.right.val<root.val)
                return false;
            if(root.right.left!=null&&root.right.left.val<root.val)
                return false;
        }
        
        return checkBST(root.left)&&checkBST(root.right);
        
        
        
        
        
        
    }
}