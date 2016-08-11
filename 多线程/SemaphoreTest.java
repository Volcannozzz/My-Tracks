import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest
{
	public static void main(String[] args)
	{
		ExecutorService service = Executors.newCachedThreadPool();		// 规定一个线程池
		final Semaphore sp = new Semaphore(3);							// 允许最大并发数为3
		for (int i = 0; i < 10; i++)
		{																// 开启十个线程。
			Runnable runnable = new Runnable()
			{
				public void run()
				{
					try
					{
						sp.acquire();
					} catch (InterruptedException e1)
					{
						e1.printStackTrace();
					}
					System.out.println(
							"线程" + Thread.currentThread().getName() + "进入，当前已有" + (3 - sp.availablePermits()) + "个并发");
					try
					{
						Thread.sleep((long) (Math.random() * 10000));
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}
					System.out.println("线程" + Thread.currentThread().getName() + "即将离开");
					sp.release();
					// 下面代码有时候执行不准确，因为其没有和上面的代码合成原子单元
					System.out.println(
							"线程" + Thread.currentThread().getName() + "已离开，当前已有" + (3 - sp.availablePermits()) + "个并发");
				}
			};
			service.execute(runnable);
		}
		
		service.shutdown();
	}

}
