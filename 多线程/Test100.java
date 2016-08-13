import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

public class Test100
{

	public static void main(String[] args)
	{
		//queue的作用是充当生产者和消费者之间数据交换的容器
		SynchronousQueue<String> queue = new SynchronousQueue<>();
		
		//signal的作用是决定线程执行的秩序
		Semaphore signal = new Semaphore(1);
		for (int i = 0; i < 10; i++)
		{
			new Thread(new Runnable()
			{

				@Override
				public void run()
				{
					// TODO Auto-generated method stub
					try
					{
						signal.acquire();//得到通行证
						String input = queue.take();//取出数据

						String output = TestDo.doSome(input);

						System.out.println(Thread.currentThread().getName() + " : " + output);
						
						signal.release();
					} catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 

				}
			}).start();
		}
		
		for(int i = 0;i<10;i++)
		{
			try
			{
				queue.put(i+"");
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class TestDo
{
	public static String doSome(String input)
	{

		try
		{
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		String output = input + ":" + (System.currentTimeMillis() / 1000);
		return output;
	}
}
