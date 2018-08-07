import java.util.concurrent.Semaphore;

public class ThreadTest implements Runnable {
	static Semaphore mutex = new Semaphore(1);
	@Override
	public void run() {
		try {
			mutex.acquire();
			for(int i=0; i<20 ; i++){
				System.out.println("Thread name: "+Thread.currentThread().getName()+" "+i);
			}
			mutex.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
