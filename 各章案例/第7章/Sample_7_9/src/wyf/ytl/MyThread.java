package wyf.ytl;
public class MyThread extends Thread{
	Sample_7_9 activity;//activity的引用
	int what = 1;//发送消息的what值
	public MyThread(Sample_7_9 activity){//构造器
		this.activity = activity;//得到activity的引用
	}
	@Override
	public void run() {//重写的run方法
		while(true){//循环
			activity.myHandler.sendEmptyMessage((what++)%4);//发送消息
			try{
				Thread.sleep(2000);//睡眠
			}
			catch(Exception e){//捕获异常
				e.printStackTrace();//打印异常信息
			}
		}
	}
}
