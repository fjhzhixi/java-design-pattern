public class Main {
	public static void main(String[] args) {
		System.out.println("Main start.......");
		try {
			CountupThread t = new CountupThread();
			t.start();

			Thread.sleep(10000);

			//发送终止信号
			System.out.println("Main set shutDown...");
			t.shutDown();

			t.join();
		}catch(InterruptedException e){}
		System.out.println("Main end.......");
	}
}