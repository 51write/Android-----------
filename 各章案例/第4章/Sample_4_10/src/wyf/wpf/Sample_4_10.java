package wyf.wpf;								//声明包语句
import android.app.Activity;			//引入相关类
import android.graphics.drawable.AnimationDrawable;	//引入相关类
import android.os.Bundle;		//引入相关类
import android.view.View;		//引入相关类
import android.view.View.OnClickListener;	//引入相关类
import android.widget.Button;	//引入相关类
import android.widget.ImageView;	//引入相关类
public class Sample_4_10 extends Activity {	
    @Override
    public void onCreate(Bundle savedInstanceState) {	//重写onCreate方法
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new OnClickListener() {	//为按钮设置监听器
			@Override	
			public void onClick(View v) {			//重写onClick方法
		        ImageView iv = (ImageView)findViewById(R.id.iv);
		        iv.setBackgroundResource(R.anim.frame_ani);
		        AnimationDrawable ad = (AnimationDrawable)iv.getBackground();
		        ad.start();		//启动AnimationDrawable
			}
		});
    }
}