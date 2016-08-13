package Graphics;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 
 * @author vayne 子线程执行3次，主线程执行5次，然后如此循环20次;
 */
public class BlockingQueueDemo
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
				for (int i = 0; i < 20; i++)
				{
					buse.sub(i);
				}

			}
		}).start();

		for (int i = 0; i < 20; i++)
		{
			buse.main(i);
		}
		System.out.println("*************************");
	}

}

// 业务逻辑类
class Business
{

	ArrayBlockingQueue<Integer> queue1 = new ArrayBlockingQueue<>(1);
	ArrayBlockingQueue<Integer> queue2 = new ArrayBlockingQueue<>(1); // 2个阻塞队列，首先向2中放入一个元素，
	// 先是sub线程放的时候阻塞，然后main往1中放一个并继续执行，执行完毕取出2里面的元素让sub得以执行，
	// 2再取出1中的元素让main得以执行，如此往复

	{
		try
		{
			queue2.put(1);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sub(int i)
	{
		try
		{
			queue2.put(1);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int j = 0; j < 3; j++)
		{
			System.out.println("sub sub sub" + j + ", loop" + i);
		}

		try
		{
			queue1.take();
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void main(int i)
	{
		try
		{
			queue1.put(1);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int j = 0; j < 5; j++)
		{
			System.out.println("main" + j + ",  loop   " + i);
		}

		try
		{
			queue2.take();
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
