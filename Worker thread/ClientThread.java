import java.util.Random;
public class ClientThread extends Thread {
	private final Channel channel;
	private static final Random random = new Random();

	public ClientThread(String name, Channel channel) {
		super(name);
		this.channel = channel;
	}
	// 不断向共享对象中添加元素
	public void run() {
		try {
			for (int i = 1; true; i++) {
				Request request = new Request(getName(), i);
				channel.putRequest(request);
				Thread.sleep(random.nextInt(1000));
			}
		} catch (InterruptedException e) {

		}
	}
}