package tuyamobile;

/**
 * 
 * @author huangbin
 * 
 *         基本思想：动态规划
 * 
 *         每次从头结点向后查找奇数节点，如果找到，那么向前移动，然后继续重复该种操作。
 *
 */
class Node
{
	public Node next;
	public int value;
	public Node(int value){
		this.value = value;
	}
}

public class TestOne
{

	public Node swap(Node list)
	{
		if(list==null){
			return null;
		}
		Node[] a = new Node[1];
		a[0] = list;
		
		int Ocount = 0;//偶节点计数
		int length = 0;//长度计数
		
		Node temp = list;
		while(temp!=null){
			length++;
			if(jO(temp))
				Ocount++;
			
			temp = temp.next;
		}
		boolean flag = true;
		int need = length-Ocount+1;//需要操作的次数
		System.out.println("****");
		Node pren = list;
		int preflag = 0;
		for(int i = 0;i<need;i++){
			swap2(a[0],a,flag,pren,preflag);
			pren = a[0];
		}
		

		return a[0];
	}
	/**
	 * 
	 * @param flag a[0]中存储首节点，只有首节点发生交换时才需要重新调整a[0]的值，flag的值是是否需要调整a[0]的判断依据。
	 * @param list,以一对节点进行操作，list代表该对节点的第一个节点
	 * @param a，只有一个元素的数组，用于保存链表的首节点（因为在操作过程中，list可能不断后移，因此需要保存首节点）
	 * @return  boolean， 代表操作是否成功。
	 */

	public boolean swap2(Node list, Node[] a,boolean flag,Node pren,int preflag)// 用boolean判断是否到达尾部
	{

		// 这里将本节点和下一节点为空的情况拦截。如果有一个为空的情况出现，说明到达尾部，停止操作。
		if (list == null)
			return true;
		if (list.next == null)
			return true;

		/**
		 * 下面是非空情况的讨论，共分四种情况，奇奇、偶偶、奇偶的情况都采取后移一个节点 而偶奇的情况采取交换处理。
		 */
		// 偶偶，则后移。
		if (jO(list.next) && jO(list))
		{
			if(preflag==0||preflag==1){
				
			}else{
				pren = pren.next;
			}
			preflag++;
			list = list.next;
			flag = false;
		}

		
		// 奇X的情况均后移。
		if (!jO(list))
		{
			if(preflag==0||preflag==1){
				
			}else{
				pren = pren.next;
			}
			preflag++;
			list = list.next;
			flag =false;
		}
		

		// 偶奇，则交换。
		if ((list!=null)&&(list.next!=null)&&!jO(list.next) && jO(list))
		{
			Node end = list.next.next;//存第三个节点
			Node pre = list;//存第一个节点
			list = list.next;
			list.next = pre;
			pre.next = end;
			if(preflag!=0){
			pren.next = list;
			}else{
				pren = list;
			}
			if(flag){
			a[0] = list;//只有出现交换的情况，才需要重新确定首节点。
			flag = false;
			}
		}
		
		preflag++;
		
		// 一次调整完毕,再次开始调整。
		return swap2(list, a,flag,pren,preflag);

	}

	
//奇偶判断的辅助方法
	public boolean jO(Node node)
	{
		if (node.value % 2 == 0)
		{
			return true;
		}
		return false;
	}
	
	//测试
	
	public static void main(String[] args)
	{
		Node e1 = new Node(73);
		Node e2 = new Node(70);
		e1.next = e2;
		
		System.out.println((new TestOne().swap(e1)).value);
	}

}
