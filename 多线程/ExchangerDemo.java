import java.util.concurrent.Exchanger;

public class ExchangerDemo
{

	public static void main(String[] args)
	{
		Exchanger<String> intermediary = new Exchanger<>();

		new Thread(new Runnable()
		{
			String data = "$1000";

			@Override
			public void run()
			{
				// TODO Auto-generated method stub
				System.out.println(Thread.currentThread().getName() + " say : I hava money: " + data + " , i want MAC");

				try
				{
					String goods = (String) intermediary.exchange(data);// 这里进行交换，在这里等待，直到第二个线程执行exchange（）方法
					Thread.sleep((long) (Math.random() * 1000));

					System.out.println(Thread.currentThread().getName() + " say :Now,I have : " + goods);

				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}).start();

		new Thread(new Runnable()
		{
			String goods = "MAC";

			@Override
			public void run()
			{
				System.out.println(Thread.currentThread().getName() + " say : Yes,i have : " + goods);

				try
				{
					String money = (String) intermediary.exchange(goods);// 与上面相同
					Thread.sleep((long) (Math.random() * 1000));//

					System.out.println(Thread.currentThread().getName() + " say: I get the " + money);
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}).start();
	}
}
