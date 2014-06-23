package wyf.jc;				//声明包语句
import android.app.Activity;		//引入相关类
import android.os.Bundle;			//引入相关类
import android.widget.CompoundButton;	//引入相关类
import android.widget.ImageView;		//引入相关类
import android.widget.ToggleButton;		//引入相关类
import android.widget.CompoundButton.OnCheckedChangeListener;	//引入相关类
public class Sample_4_5 extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ToggleButton tb=(ToggleButton)this.findViewById(R.id.ToggleButton01);  
        tb.setOnCheckedChangeListener(new OnCheckedChangeListener(){//为ToggleButton添加监听器
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {							//重写onCheckedChanged方法
				setBulbState(isChecked);			//设置控件状态
			}
        });
    }    
    //方法：设置程序状态的方法
    public void setBulbState(boolean state){//true on  false off
    	//设置图片状态
    	ImageView iv=(ImageView)findViewById(R.id.ImageView01);
		iv.setImageResource((state)?R.drawable.bulb_on:R.drawable.bulb_off);//设置图片状态
		//设置ToggleButton状态
		ToggleButton tb=(ToggleButton)this.findViewById(R.id.ToggleButton01);        
		tb.setChecked(state);//设置ToggleButton状态
	}
}