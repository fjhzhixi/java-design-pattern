public class Main{
	public static void main(String[] args) {
		System.out.println("Main start......");
		Host host = new Host();
		// 发送请求之后可以立即返回凭证
		Data data1 = host.request(10, 'A');
		Data data2 = host.request(20, 'B');
		Data data3 = host.request(30, 'C');

		System.out.println("Main other job start.......");
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e){}
		System.out.println("Main other job end.......");

		System.out.println("data1 = " + data1.getContent());
		System.out.println("data2 = " + data2.getContent());
		System.out.println("data3 = " + data3.getContent());
		System.out.println("Main end.......");
	}
}