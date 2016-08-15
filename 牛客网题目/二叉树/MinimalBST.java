package newcoder;

import java.util.*;

public class MinimalBST
{
	public int buildMinimalBST(int[] vals)
	{
		// write code here
		int length = vals.length;
		int count = 0;
		while (length != 1)
		{
			length = length >> 1;
			count++;
		}
		return ++count;
	}

	public Node getMiniBst(int[] vals, int start, int end)
	{
		if (start > end)// start==end的情况也是一层节点，因此不能加入这个条件。
		{
			return null;
		}

		int mid = start + (end - start) / 2;
		Node root = new Node(vals[mid]);

		root.left = getMiniBst(vals, start, mid - 1);// 构建左子树
		root.right = getMiniBst(vals, mid + 1, end);// 构建右子树

		return root;
	}
}

class Node
{
	Node left;
	Node right;
	Node parent;
	int val;

	Node(int val)
	{
		this.val = val;
	}
}