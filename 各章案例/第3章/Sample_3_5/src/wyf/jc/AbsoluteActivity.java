package wyf.jc;				//声明包语句
import android.app.Activity;	//引入相关类
import android.os.Bundle;		//引入相关类
import android.view.View;
import android.widget.Button;	//引入相关类
import android.widget.EditText;	//引入相关类
public class AbsoluteActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {	//重写onCreate方法
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);					//设置当前屏幕
        final Button OkButton = (Button) findViewById(R.id.Button01);		//获取确定按钮对象
        final Button cancelButton = (Button) findViewById(R.id.Button02);	//获取取消按钮对象
        final EditText uid=(EditText)findViewById(R.id.EditText01);			//获取用户名文本框对象
        final EditText pwd=(EditText)findViewById(R.id.EditText02);			//获取密码文本框对象
        final EditText log=(EditText)findViewById(R.id.EditText03);			//获取登录日志文本框对象
        OkButton.setOnClickListener(//OnClickListener为View的内部接口，其实现者负责监听鼠标点击事件
        		new View.OnClickListener(){ 
        			public void onClick(View v){ 					//重写onClick方法
        				String uidStr=uid.getText().toString();		//获取用户名文本框的内容
        				String pwdStr=pwd.getText().toString();		//获取密码文本框的内容
        				log.append("用户名："+uidStr+" 密码："+pwdStr+"\n");
        			} 
        		}); 
        cancelButton.setOnClickListener(//OnClickListener为View的内部接口，其实现者负责监听鼠标点击事件
                new View.OnClickListener(){ 
                	public void onClick(View v){ 		//重写onClick方法
                		uid.setText("");				//清空用户名文本框内容
                		pwd.setText("");				//清空密码文本框内容
                	} 
                }); 
    }
}