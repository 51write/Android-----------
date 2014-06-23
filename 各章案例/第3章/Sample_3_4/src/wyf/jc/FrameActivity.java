package wyf.jc;						//声明包语句

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class FrameActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {	//重写onCreate方法
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);			//设置当前屏幕
    }
    public void myClick(View view){
    	FrameLayout fl = (FrameLayout)view;
    	fl.setForeground(null);
    }
}