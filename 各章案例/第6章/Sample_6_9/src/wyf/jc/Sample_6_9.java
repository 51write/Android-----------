package wyf.jc;								//声明包语句
import android.app.Activity;						//引入相关类
import android.os.Bundle;				//引入相关类
import android.view.Gravity;
import android.view.View;						//引入相关类
import android.widget.Button;				//引入相关类
import android.widget.ImageView;				//引入相关类
import android.widget.LinearLayout;				//引入相关类
import android.widget.Toast;				//引入相关类
public class Sample_6_9 extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {	//重写onCreate方法
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);					//设置当前屏幕
        Button btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {	//为按钮添加监听器
			@Override
			public void onClick(View v) {
				ImageView iv = new ImageView(Sample_6_9.this);	//创建ImageView
				iv.setImageResource(R.drawable.header2);		//设置ImageView的显示内容
				LinearLayout ll = new LinearLayout(Sample_6_9.this);	//创建一个线性布局
				Toast toast = Toast.makeText(Sample_6_9.this, "这是一个带图片的Toast", Toast.LENGTH_LONG);
				toast.setGravity(Gravity.CENTER, 0, 0);
				View toastView = toast.getView();			//获得Toast的View
				ll.setOrientation(LinearLayout.HORIZONTAL);		//设置线性布局的排列方式
				ll.addView(iv);							//将ImageView添加到线性布局
				ll.addView(toastView);					//将Toast的View添加到线性布局
				toast.setView(ll);
				toast.show();							//显示Toast
			}
		});
    }
}