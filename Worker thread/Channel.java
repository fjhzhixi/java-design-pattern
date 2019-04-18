import java.util.ArrayList;
// 委托中与工作者共享的中间对象
public class Channel {
	private static final int MAX_REQUEST = 100;
	private final ArrayList<Request> requestQueue;
	private final WorkerThread[] threadPool;

	public Channel(int threadNum) {
		requestQueue = new ArrayList<>();
		threadPool = new WorkerThread[threadNum];
		for (int i = 0; i < threadNum; i++ ) {
			threadPool[i] = new WorkerThread("Work " + i, this);
		}
	}

	// 激活线程池开始工作
	public void startWorkers() {
		for (int i = 1; i < threadPool.length; i++) {
			threadPool[i].start();
		}
	}
	// 委托者放入请求
	public synchronized void putRequest(Request request) {
		// 当请求达到最大数量时等待
		while(requestQueue.size() >= MAX_REQUEST) {
			try {
				wait();
			} catch (InterruptedException e) {

			}
		}
		requestQueue.add(request);
		notifyAll();
	}

	//工作者取走请求执行
	public synchronized Request takeRequest() {
		while(requestQueue.size() <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {

			} 
		}
		Request request = requestQueue.get(0);
		requestQueue.remove(0);
		notifyAll();
		return request;
	}
}