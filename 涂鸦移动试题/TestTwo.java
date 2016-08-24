package tuyamobile;

import java.util.ArrayList;
import java.util.List;

/*
 * @author 黄斌
 * 建立一组映射关系
 * 例如：数组索引：1  2  3  4  5  6  7  8  9  10 11 12
 * 对应的值：          1  2  3  1  2  3  4  2  1  2  5  3
 * 这样可以使用递推关系
 */
public class TestTwo
{

	public int getRes(int n)
	{

		int[] a = new int[10000];

		a[0] = 0;
		a[1] = 1;
		a[2] = 2;
		
		for(int i = 2;i<=n;i++){
			if(judge(i)){
				a[i] = 1;
				continue;
			}
			ArrayList<Integer> list = new ArrayList<>();
			for(int x = 1;x<=i/2;x++){
				list.add(a[x]+a[i-x]);
			}
			
			a[i] = getMin(list);
		}

		return a[n];
	}
	
	public int getMin(List<Integer> list){
		
		int min = list.get(0);
		for(Integer value:list){
			if(value<min){
				min = value;
			}
		}
		
		return min;
		
	}

	public boolean judge(int n)
	{

		double a = Math.sqrt(n);

		int b = (int) a;

		if (b * b == n)
			return true;
		return false;
	}
	
	
	//测试
	public static void main(String[] args)
	{
		int n = 5;
		System.out.println(new TestTwo().judge(4));
		System.out.println(new TestTwo().getRes(2));
		System.out.println(new TestTwo().getRes(3));
		System.out.println(new TestTwo().getRes(4));
		System.out.println(new TestTwo().getRes(5));
		System.out.println(new TestTwo().getRes(6));
		System.out.println(new TestTwo().getRes(7));
		System.out.println(new TestTwo().getRes(8));
		System.out.println(new TestTwo().getRes(9));
		System.out.println(new TestTwo().getRes(10));
		System.out.println(new TestTwo().getRes(11));
		System.out.println(new TestTwo().getRes(12));
		System.out.println(new TestTwo().getRes(13));
	}
}
