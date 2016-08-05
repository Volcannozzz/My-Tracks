
public class ManyCenjoyOneob
{

	public static void main(String[] args)
	{
		//第一种方式
		AllenjoyOb demo = new AllenjoyOb();
		
		Thread th1 = new Thread(demo);
		Thread th2 = new Thread(demo);
		
		th1.start();
		th2.start();
		
		//第二种方式
		int data = 0;
		
		Thread thA = new Thread(new XXXX2(data));
		Thread thB = new Thread(new XXXX2(data));
		
		thA.start();
		thB.start();
	}
	
}
//第一种方式使用的类代码
class AllenjoyOb implements Runnable
{
	
	private int data = 0;
	
	@Override
	public void run()
	{
		increment();
		
	}
	
	private void increment()
	{
		data++;
	}
}

//第二种方式使用的类的代码
class XXXX2 implements Runnable
{
	private int data2 = 0;
	public XXXX2(int data2)
	{
		this.data2 = data2;
	}
	
	@Override
	public void run()
	{
		increment2();
	}
	
	private void increment2()
	{
		data2++;
	}
}