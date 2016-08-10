import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
 * @author vayne
 * 
 * 多线程实现缓存的小demo
 */
class Cachend
{
	volatile Map<String, String> cachmap = new HashMap<String, String>();//加volatile关键字保证可见性。

	ReadWriteLock rwLock = new ReentrantReadWriteLock();//这个读写锁要定义在方法外面，使得每一个线程用的是同一个读写锁。
	public  String getS(String key)						//如果定义在方法内部，就是跟方法栈有关的读写锁。这样可能不是同一个锁。
	{
		rwLock.readLock().lock();
		String value = null;
		try
		{
			value = cachmap.get(key);

			if (cachmap.get(key) == null)//这里要重新获得key对应的value值
			{
				rwLock.readLock().unlock();
				rwLock.writeLock().lock();
				try
				{
					if (cachmap.get(key) == null)//这里也是
					{
						value = "" + Thread.currentThread().getName();

						cachmap.put(key, value);

						System.out.println(Thread.currentThread().getName()  + "  put the value ::::" + value);
					}
				} finally
				{
					rwLock.readLock().lock();   //将锁降级，这里跟下一句的顺序不能反。
					rwLock.writeLock().unlock();//关于这里的顺序问题，下面我会提到。
				}
			}

		} finally
		{
			rwLock.readLock().unlock();
		}

		return cachmap.get(key);
	}
}

public class CachendDemo
{
	public static void main(String[] args)
	{
		Cachend ca = new Cachend();
		for (int i = 0; i < 4; i++)
		{
			new Thread(new Runnable()
			{
				@Override
				public void run()
				{
					System.out.println(Thread.currentThread().getName()+"  "+ca.getS("demo1"));
					System.out.println(Thread.currentThread().getName()+"  "+ca.cachmap.entrySet());
				}
			}).start();
		}
	}
}
