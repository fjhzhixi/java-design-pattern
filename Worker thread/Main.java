public class Main {
	public static void main(String[] args) {
		Channel channel = new Channel(5);
		channel.startWorkers();
		new ClientThread("capitalists-1", channel).start();
		new ClientThread("capitalists-2", channel).start();
		new ClientThread("capitalists-3", channel).start();
	}
}