public class Host{
	public Data request(final int count, final char c) {
		System.out.println("request ( " + count + c + " ) start......");
		// 创建凭证类并立即返回
		final FutureData futureData = new FutureData();
		// 创建一个新的内部进程来处理真正的数据
		new Thread() {
			public void run() {
				RealData realData = new RealData(count, c);
				futureData.setRealData(realData);
			}
		}.start();
		System.out.println("request ( " + count + c + " ) end......");
		return futureData;
	}
}