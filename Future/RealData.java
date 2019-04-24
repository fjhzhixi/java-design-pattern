public class RealData implements Data{
	// 真正数据的内容
	private final String content;
	public RealData(int count, char c) {
		System.out.println("making RealData ( " + count + c + " ) start......");
		char[] buffer = new char[count];
		for (int i = 0; i < count; i++) {
			buffer[i] = c;
			// 创建时间长一点使效果明显
			try {
				Thread.sleep(100);
			}catch(InterruptedException e){}
		}
		System.out.println("making RealData ( " + count + c + " ) end......");
		this.content = new String(buffer);
	}

	public String getContent() {
		return this.content;
	}
}