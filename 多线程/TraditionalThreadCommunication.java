/**
 * 
 * @author vayne 子线程执行15次，主线程执行50次，然后如此循环100次;
 */
public class TraditionalThreadCommunication
{
	final static Business buse = new Business();
	public static void main(String[] args)
	{
		new Thread(new Runnable()
		{
			
			@Override
			public void run()
			{
				// TODO Auto-generated method stub
				for(int i = 0;i<100;i++)
				{
					buse.sub(i);
				}
				
			}
		}).start();
		
		for(int i =0;i<100;i++)
		{
			buse.main(i);
		}
	}

}

// 业务逻辑类
class Business
{

	public boolean bsub = false;

	public synchronized void sub(int i)
	{
		while (!bsub)
		{
			try
			{
				this.wait();
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int j = 0; j < 15; j++)
		{
			System.out.println("sub sub sub" + j + ", loop" + i);
		}

		bsub = false;

		this.notify();

	}

	public synchronized void main(int i)
	{
		while (bsub)
		{
			try
			{
				this.wait();
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		for (int j = 0; j < 50; j++)
		{
			System.out.println("main" + j+",  loop   "+i);
		}
		bsub=true;
		this.notify();
	}
}
