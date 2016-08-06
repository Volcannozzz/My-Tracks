
public class DeadLockDemo
{
	public static void main(String[] args)
	{
		Object lock1 = new Object();
		Object lock2 = new Object();
		A a = new A(lock1, lock2);
		B b = new B(lock1, lock2);

		new Thread(a).start();
		new Thread(b).start();
		
		System.out.println("主线程末尾");
	}
}

class A implements Runnable
{
	Object lock1;
	Object lock2;

	A(Object lock1, Object lock2)
	{
		this.lock1 = lock1;
		this.lock2 = lock2;
	}

	public void cal()
	{
		synchronized (lock1)
		{
			System.out.println(lock1.toString());
			try
			{
				Thread.sleep(1000);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (lock2)
			{
				System.out.println(lock2.toString());
			}
		}
		
		System.out.println("A的cal运行结束");

	}

	@Override
	public void run()
	{
		cal();
	}
}

class B implements Runnable
{
	Object lock1;
	Object lock2;

	B(Object lock1, Object lock2)
	{
		this.lock1 = lock1;
		this.lock2 = lock2;
	}

	public void cal()
	{
		synchronized (lock2)
		{
			System.out.println(lock1.toString());
			try
			{
				Thread.sleep(1000);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (lock1)
			{
				System.out.println(lock2.toString());
			}
		}
		
		System.out.println("B的cal运行结束");

	}

	@Override
	public void run()
	{
		cal();
	}
}
