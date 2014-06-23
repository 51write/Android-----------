package wyf.jc;								//声明包语句
import android.app.Activity;				//引入相关类
import android.os.Bundle;					//引入相关类
import android.view.View;					//引入相关类
import android.view.View.OnClickListener;	//引入相关类
import android.widget.Button;				//引入相关类
public class Sample_4_2 extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {		//重写onCreate方法
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);						//设置当前屏幕
        Button btn = (Button)findViewById(R.id.btn);		//获取Button控件对象
        btn.setOnClickListener(new OnClickListener(){		//添加OnClickListener监听器
			@Override
			public void onClick(View v) {				//重写onClick方法
				Button btn = (Button)findViewById(R.id.btn);	//获取Button对象
				btn.setBackgroundDrawable(getResources().getDrawable(R.color.btn));	//设置按钮背景
				btn.setText(R.string.btn2);			//设置按钮显示文字
			}
        });
    }
}