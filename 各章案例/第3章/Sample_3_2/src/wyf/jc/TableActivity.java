package wyf.jc;				//声明包语句
import android.app.Activity;	//引入相关类
import android.os.Bundle;		//引入相关类
public class TableActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {	//重写onCreate方法
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);					//设置布局文件main.xml为当前屏幕
    }
}