import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * @author Vayne
 * 
 * Executors是线程池框架的一个工具类
 * 
 * 
 */
public class FixedThreadPoolDemo
{
	public static void main(String[] args)
	{
		ExecutorService pool = Executors.newFixedThreadPool(2);

		// 定义一个循环，添加5个任务
		for (int i = 0; i < 5; i++)
		{
			int flag = i;
			pool.execute(new Runnable()
			{
				@Override
				public void run()
				{
					for(int j = 0;j<6;j++)
					{
						try
						{
							Thread.sleep(10);
						} catch (InterruptedException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName()+" "+flag+" "+" `s loop : "+j);
					}
				}
			});
		}
		
		pool.shutdown();

	}
}
