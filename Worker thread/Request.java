import java.util.Random;
// 表示请求的类，应该是一个不可变对象，一旦创建不再改变
public class Request {
	private final String name;	// 委托者姓名
	private final int num;		// 请求的编号
	private static final Random random = new Random();

	public Request(String name, int num) {
		this.name = name;
		this.num = num;
	}
	// 模拟请求的执行
	public void execute() {
		System.out.println(Thread.currentThread().getName() + " excute " + this);
		try {
			Thread.sleep(random.nextInt(1000));
		} catch (InterruptedException e){}

	}
 	
	public String toString() {
		return ("[ Request from " + name + " No." + num + " ]");
	}
}