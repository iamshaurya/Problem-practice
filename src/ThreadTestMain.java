/**
 * 
 */

/**
 * @author Shaurya
 *
 */
public class ThreadTestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread testThread1 = new Thread(new ThreadTest(), "testThread1");
		Thread testThread2 = new Thread(new ThreadTest(), "testThread2");
		testThread1.start();
		testThread2.start();
	}

}
