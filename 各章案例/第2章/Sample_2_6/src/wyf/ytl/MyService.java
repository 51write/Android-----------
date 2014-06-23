package wyf.ytl;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
public class MyService extends Service{
	MyThread myThread;//线程的引用
	public void onCreate() {//重写的onCreate方法
		Log.d("MyService", "onCreate");//打印日志
		super.onCreate();
	}
	public void onStart(Intent intent, int startId) {//重写的onStart方法
		Log.d("MyService", "onStart");//打印日志
		if(myThread == null){
			myThread = new MyThread();
			myThread.start();	//启动线程			
		}
		super.onStart(intent, startId);
	}		
	public IBinder onBind(Intent arg0) {//重写的onBind方法
		Log.d("MyService", "onBind");//打印日志
		if(myThread == null){
			myThread = new MyThread();
			myThread.start();		//启动线程		
		}
		return null;
	}
	public boolean onUnbind(Intent intent) {//重写的onUnbind方法
		Log.d("MyService", "onUnbind");//打印日志
		if(myThread != null){
			myThread.flag = false;
			myThread = null;//释放线程
		}		
		return super.onUnbind(intent);
	}	
	public void onDestroy() {//重写的onDestroy方法
		Log.d("MyService", "onDestroy");//打印日志
		if(myThread != null){
			myThread.flag = false;
			myThread = null;
		}
		super.onDestroy();
	}	
	public class MyThread extends Thread{
		boolean flag = true;//循环标志位
		int i = 0;
		public void run(){
			while(flag){
				Log.d("MyService", "i = " + (i++));//打印日志
				try{
					Thread.sleep(1000);//睡眠1秒钟
				}catch(Exception e){//捕获异常
					e.printStackTrace();//打印异常
				}
			}
		}
	}
}