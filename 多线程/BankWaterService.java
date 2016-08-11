import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BankWaterService implements Runnable
{

	// 屏障
	private CyclicBarrier barrier = new CyclicBarrier(4);
	// 线程池
	private ExecutorService pool = Executors.newFixedThreadPool(4);
	// 保存结果的map
	private ConcurrentHashMap<String, Integer> order = new ConcurrentHashMap<>();

	private void count()
	{
		for (int i = 0; i < 4; i++)
		{
			Runnable action = new Runnable()
			{

				@Override
				public void run()
				{
					// TODO Auto-generated method stub
					order.put(Thread.currentThread().getName(), 4);// 模拟计算出的结果放入map
					try
					{
						barrier.await();
					} catch (Exception e)
					{
						// TODO: handle exception
					}
				}
			};

			pool.execute(action);

		}

		pool.shutdown();
	}

	@Override
	public void run()
	{
		int result = 0;
		for (Entry<String, Integer> entry : order.entrySet())
		{
			result += entry.getValue();// 新开启线程对结果进行统计
		}

		System.out.println("总结果："+result);
	}

	public static void main(String[] args)
	{
		BankWaterService service = new BankWaterService();
		service.count();
		new Thread(service).start();
	}

}
