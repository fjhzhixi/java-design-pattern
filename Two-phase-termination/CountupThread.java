public class CountupThread extends Thread {
	private int counter = 0;
	// 标记是否收到终止请求
	private volatile boolean shutDownRequest = false;
	// 终止请求
	public void shutDown() {
		this.shutDownRequest = true;
		interrupt();		
	}
	public boolean isShutDown() {
		return shutDownRequest;
	}

	public void run() {
		try {
			while(!isShutDown()) {
				doWork();
			}
		}catch(InterruptedException e) {
		}finally {
			doShutdown();
		}
	}
	private void doWork() throws InterruptedException{
		counter++;
		System.out.println("doWork: counter is " + counter);
		Thread.sleep(500);
	}
	private void doShutdown() {
		System.out.println("doShutdown: counter is " + counter);
	}
}