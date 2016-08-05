
public class FourThreadIncJDecJ
{

	private int j = 0;   //将j作为主类的成员变量，
	
	public static void main(String[] args)
	{
		FourThreadIncJDecJ demo = new FourThreadIncJDecJ();//实例化一个主类对象，一是可以方便创建内部类对象，二是可以得到一个j数据
		
		Inc incRunnable = demo.new Inc();                       //这里应当注意，内部类对象的创建依赖于寄生的那个主类的对象！
		Dec decRunnable = demo.new Dec();
		
		for(int i = 0;i<2;i++)
		{
			
			Thread thread = new Thread(incRunnable);
			thread.start();
			
			thread = new Thread(decRunnable);
			thread.start();
			
			
		}
		
	}
	
	//increment Operation
	public synchronized void IncOp()
	{
		j++;
		
		System.out.println(Thread.currentThread().getName()+"+ inc :"+j);
	}
	
	//Dec Operation
	public synchronized void DecOp()
	{
		j--;
		System.out.println(Thread.currentThread().getName()+"+ dec :"+j);
	}
	
	
	
	class Inc implements Runnable
	{
		
		@Override
		public void run()
		{
			IncOp();
		}
	}
	
	class Dec implements Runnable
	{
		@Override
		public void run()
		{
			DecOp();
		}
	}
}
