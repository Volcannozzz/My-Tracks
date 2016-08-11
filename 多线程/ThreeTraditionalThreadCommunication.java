import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author vayne 
 */
public class ThreeTraditionalThreadCommunication
{
	final static ThreeBusiness buse = new ThreeBusiness();

	public static void main(String[] args)
	{
		new Thread(new Runnable()//启动线程一
		{

			@Override
			public void run()
			{
				// TODO Auto-generated method stub
				for (int i = 0; i < 100; i++)
				{
					buse.sub1(i);
				}

			}
		}).start();

		new Thread(new Runnable()//启动线程三
		{

			@Override
			public void run()
			{
				// TODO Auto-generated method stub
				for (int i = 0; i < 100; i++)
				{
					buse.sub3(i);
				}

			}
		}).start();

		for (int i = 0; i < 100; i++)//启动线程2
		{
			buse.main(i);
		}
	}

}

// 业务逻辑类
class ThreeBusiness
{

	public  volatile int bsub = 1;

	Lock lock = new ReentrantLock();

	Condition condition1 = lock.newCondition();

	Condition condition2 = lock.newCondition();

	Condition condition3 = lock.newCondition();

	public void sub1(int i)//线程一执行的任务
	{
		lock.lock();
		try
		{
			while (bsub != 1)
			{
				try
				{
					condition1.await();//因为condition1而等待
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for (int j = 0; j < 5; j++)
			{
				System.out.println("sub1 sub1 sub1:::" + j + ", loop" + i);
			}

			bsub = 2;
			condition2.signal();//给因为condition2而等待的线程发苏醒信号
		} finally
		{
			lock.unlock();
		}

	}

	public void main(int i)//线程二执行的任务
	{
		lock.lock();

		try
		{
			while (bsub != 2)
			{
				try
				{
					condition2.await();//因为condition2等待
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			for (int j = 0; j < 10; j++)
			{
				System.out.println("main222:::::::" + j + ",  loop   " + i);
			}
			bsub = 3;
			condition3.signal();//给因为condition3而等待的线程发送苏醒信号
		} finally

		{
			lock.unlock();
		}
	}

	public void sub3(int i)//线程三执行的任务
	{
		lock.lock();
		try
		{
			while (bsub != 3)
			{
				try
				{
					condition3.await();//因为condition3而等待
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for (int j = 0; j < 5; j++)
			{
				System.out.println("sub3 sub3 sub3::" + j + ", loop" + i);
			}

			bsub = 1;
			condition1.signal();//给因为condition1而等待的线程发送苏醒信号
		} finally
		{
			lock.unlock();
		}

	}
}
