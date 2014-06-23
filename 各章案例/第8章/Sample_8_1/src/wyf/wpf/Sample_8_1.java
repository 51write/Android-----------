package wyf.wpf;				//声明包语句
import android.app.Activity;		//引入相关类
import android.os.Bundle;			//引入相关类
import android.view.Window;			//引入相关类
import android.view.WindowManager;	//引入相关类
public class Sample_8_1 extends Activity {
	MyView myView;			//MyView对象引用
	MyThread mt;			//MyThread对象引用
    @Override
    public void onCreate(Bundle savedInstanceState) {	//重写onCreate方法
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);	//设置不显示应用程序标题栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        		WindowManager.LayoutParams.FLAG_FULLSCREEN);	//设置全屏
        myView = new MyView(this);			//创建MyView对象
        setContentView(myView);				//设置当前屏幕
        mt = new MyThread(myView);			//创建MyThread对象
        mt.start();							//启动MyThread
    }
}