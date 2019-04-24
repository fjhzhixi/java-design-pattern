public class FutureData implements Data{
	private RealData realData = null;
	// 表示真正的数据是否准备好了,并且使用Balk模式
	private boolean ready = false;

	public synchronized void setRealData(RealData realData) {
		if (ready) {
			return;
		}
		this.realData = realData;
		this.ready = true;
		notifyAll();
	}
	public synchronized String getContent() {
		// 当真实数据没有准备好时阻塞等待
		while(!ready) {
			try {
				wait();
			}catch(InterruptedException e){}
		}
		return this.realData.getContent();
	}
}