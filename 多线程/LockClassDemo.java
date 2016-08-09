import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 
 * 利用Lock类的DEMO
 * 
 */
public class LockClassDemo
{
	public static void main(String[] args)
	{
		Out out = new Out();

		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				while (true)
				{
					try
					{
						Thread.sleep(10);
					} catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					out.output("vayne");
				}
			}
		}).start();

		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				while (true)
				{
					try
					{
						Thread.sleep(10);
					} catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					out.output("Kalinux and csdn blog");
				}
			}
		}).start();

		System.out.println("main Thread over!!!");

	}

}

class Out
{
	Lock lock = new ReentrantLock();

	public void output(String string)
	{
		lock.lock();
		try
		{
			for (int i = 0; i < string.length(); i++)
			{
				System.out.print(string.charAt(i));
			}
			System.out.println();
		} finally
		{
			lock.unlock();
		}
	}
}
