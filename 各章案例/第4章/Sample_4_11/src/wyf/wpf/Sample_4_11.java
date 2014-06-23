package wyf.wpf;						//声明包语句
import android.app.Activity;		//引入相关类
import android.os.Bundle;			//引入相关类
import android.view.View;		//引入相关类
import android.view.View.OnClickListener;		//引入相关类
import android.view.animation.Animation;		//引入相关类
import android.view.animation.AnimationUtils;	//引入相关类
import android.widget.Button;		//引入相关类
import android.widget.ImageView;		//引入相关类
public class Sample_4_11 extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {	//重写onCreate方法
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);			//设置屏幕
        Button btn = (Button)findViewById(R.id.btn);	//获取Button对象
        btn.setOnClickListener(new OnClickListener() {	//为Button对象添加OnClickListener监听器
			@Override
			public void onClick(View v) {				//重写onClick方法
		        ImageView iv = (ImageView)findViewById(R.id.iv);
		        Animation animation = AnimationUtils.loadAnimation(Sample_4_11.this, R.anim.tween_ani);
		        iv.startAnimation(animation);			//启动动画			
			}
		});
    }
}