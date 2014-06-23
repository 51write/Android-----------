package wyf.ytl;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
public class MyService extends Service{
	MyThread myThread;//�̵߳�����
	public void onCreate() {//��д��onCreate����
		Log.d("MyService", "onCreate");//��ӡ��־
		super.onCreate();
	}
	public void onStart(Intent intent, int startId) {//��д��onStart����
		Log.d("MyService", "onStart");//��ӡ��־
		if(myThread == null){
			myThread = new MyThread();
			myThread.start();	//�����߳�			
		}
		super.onStart(intent, startId);
	}		
	public IBinder onBind(Intent arg0) {//��д��onBind����
		Log.d("MyService", "onBind");//��ӡ��־
		if(myThread == null){
			myThread = new MyThread();
			myThread.start();		//�����߳�		
		}
		return null;
	}
	public boolean onUnbind(Intent intent) {//��д��onUnbind����
		Log.d("MyService", "onUnbind");//��ӡ��־
		if(myThread != null){
			myThread.flag = false;
			myThread = null;//�ͷ��߳�
		}		
		return super.onUnbind(intent);
	}	
	public void onDestroy() {//��д��onDestroy����
		Log.d("MyService", "onDestroy");//��ӡ��־
		if(myThread != null){
			myThread.flag = false;
			myThread = null;
		}
		super.onDestroy();
	}	
	public class MyThread extends Thread{
		boolean flag = true;//ѭ����־λ
		int i = 0;
		public void run(){
			while(flag){
				Log.d("MyService", "i = " + (i++));//��ӡ��־
				try{
					Thread.sleep(1000);//˯��1����
				}catch(Exception e){//�����쳣
					e.printStackTrace();//��ӡ�쳣
				}
			}
		}
	}
}