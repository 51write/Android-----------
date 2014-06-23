package wyf.ytl;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

public class Sample_7_9 extends Activity {
	ImageView myImageView;//ImageView的引用
    Handler myHandler = new Handler(){//创建一个Handler对象
		@Override
		public void handleMessage(Message msg) {//重写接收消息的方法
			switch(msg.what){//判断what的值
			case 0://what值为0时
				myImageView.setImageResource(R.drawable.bbta);break;
			case 1://what值为1时
				myImageView.setImageResource(R.drawable.bbtb);break;
			case 2://what值为2时
				myImageView.setImageResource(R.drawable.bbtc);break;
			case 3://what值为3时
				myImageView.setImageResource(R.drawable.bbtd);break;	
			}
			super.handleMessage(msg);
		}
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {//重写的onCreate方法
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);//设置当前的用户界面
        myImageView = (ImageView) findViewById(R.id.myImageView);//得到ImageView的引用
        MyThread myThread = new MyThread(this);//初始化MyThread线程
        myThread.start();//启动线程
    }

}