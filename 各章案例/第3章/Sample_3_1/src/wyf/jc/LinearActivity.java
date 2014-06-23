package wyf.jc;					//声明包语句
import android.app.Activity;		//引入相关类
import android.os.Bundle;			//引入相关类
import android.view.View;			//引入相关类
import android.widget.Button;			//引入相关类
import android.widget.LinearLayout;		//引入相关类

public class LinearActivity extends Activity {
	int count=0;				//计数器，记录按钮个数
    @Override
    public void onCreate(Bundle savedInstanceState) {	//重写onCreate方法
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button button = (Button) findViewById(R.id.Button01); 	//获取屏幕中的按钮控件对象
        button.setOnClickListener(		//为按钮对象添加OnClickListener接口实现
           //OnClickListener为View的内部接口，其实现者负责监听鼠标点击事件
        	new View.OnClickListener(){ 
    			public void onClick(View v){             	
    				LinearLayout ll=(LinearLayout)findViewById(R.id.lla); //获取线性布局对象
					String msg=LinearActivity.this.getResources().getString(R.string.button);
					Button tempbutton=new Button(LinearActivity.this);	//创建一个Button对象
					tempbutton.setText(msg+(++count));	//设置Button控件显示的内容
					tempbutton.setWidth(80);			//设置Button的宽度
					ll.addView(tempbutton);				//向线性布局中添加View
					System.out.println("========= count"+count);
    			} 
    		}
        ); 
	}
}