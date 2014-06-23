package wyf.jc;					//声明包语句
import android.app.Activity;		//引入相关类
import android.os.Bundle;			//引入相关类
import android.view.KeyEvent;		//引入相关类
import android.view.View;			//引入相关类
import android.view.View.OnKeyListener;	//引入相关类
import android.widget.EditText;			//引入相关类
public class Sample_4_1 extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {		//重写onCreate方法
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);						//设置当前屏幕
        EditText etEmail = (EditText)findViewById(R.id.etEmail);
        etEmail.setOnKeyListener(myOnKeyListener);			//为EditText控件设置OnKeyListner监听器
    }
    private OnKeyListener myOnKeyListener = new OnKeyListener(){	//自定义的OnKeyListner对象
		@Override
		public boolean onKey(View v, int keyCode, KeyEvent event) {	//重写onKey方法
			EditText etInfo = (EditText)findViewById(R.id.etInfo);	
			EditText etEmail = (EditText)findViewById(R.id.etEmail);
			etInfo.setText("您输入的邮箱地址为："+etEmail.getText());			//设置EditText控件的显示内容
			return false;
		}
    };
}