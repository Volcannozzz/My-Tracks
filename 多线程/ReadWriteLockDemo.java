import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo
{

	public static void main(String[] args)
	{
		DefQueue queue = new DefQueue();
		for (int i = 1; i < 10; i++)
		{
			//启动线程进行读操作
			new Thread(new Runnable()
			{
				@Override
				public void run()
				{
					while (true)
					{
						queue.get();
					}
				}

			}).start();

			//启动线程进行写操作
			new Thread(new Runnable()
			{
				@Override
				public void run()
				{
					while(true)
					{
						queue.put(new Random().nextInt(10000));
					}
				}
			}).start();
		}
	}

}

class DefQueue
{
	private int data;
	ReadWriteLock rwLock = new ReentrantReadWriteLock();

	public void get()
	{
		rwLock.readLock().lock();//加读锁
		try
		{
			System.out.println(Thread.currentThread().getName() + "be ready to get data");
			Thread.sleep((long) (Math.random() * 1000));

			System.out.println(Thread.currentThread().getName() + "get the data:    " + data);

		} catch (InterruptedException e)
		{
			e.printStackTrace();
		} finally
		{
			rwLock.readLock().unlock();//释放读锁
		}
	}

	public void put(int data)
	{
		rwLock.writeLock().lock();//加写锁

		try
		{
			System.out.println(Thread.currentThread().getName() + " be ready to write data");

			Thread.sleep((long) (Math.random() * 1000));

			this.data = data;

			System.out.println(Thread.currentThread().getName() + " has wrote the data:  "+data);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		} finally
		{
			rwLock.writeLock().unlock();//释放写锁
		}

	}
}
