/**
 * 
 */
package dp.singleton;

/**
 * @author DhanunjayaY
 *
 */
public class SingletonTest implements Runnable{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*Singleton s = new Singleton();
		Singleton s1 = new Singleton();*/
		
		/*Singleton s = Singleton.getInstance();
		Singleton s1 = Singleton.getInstance();
		
		System.out.println(s.hashCode());
		System.out.println(s1.hashCode());*/
		
		SingletonTest st = new SingletonTest();
		SingletonTest st2 = new SingletonTest();
		SingletonTest st3 = new SingletonTest();
		
		Thread t = new Thread(st);
		Thread t2 = new Thread(st2);
		Thread t3 = new Thread(st3);
		Thread t4 = new Thread(st2);
		Thread t5 = new Thread(st3);
		Thread t6 = new Thread(st);
		
		t.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		
	}

	@Override
	public void run() {
		for(int i = 0 ; i< 5; i++){
			System.out.println(Thread.currentThread().getName() 
					+ " ===" + Singleton.getInstance().hashCode());
		}
		
	}

}
