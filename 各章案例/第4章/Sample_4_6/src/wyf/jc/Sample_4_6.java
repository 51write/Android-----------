package wyf.jc;							//声明包语句
import android.app.Activity;			//引入相关类
import android.os.Bundle;				//引入相关类
import android.widget.CheckBox;			//引入相关类
import android.widget.CompoundButton;	//引入相关类
import android.widget.ImageView;		//引入相关类
import android.widget.RadioButton;		//引入相关类
import android.widget.CompoundButton.OnCheckedChangeListener;	//引入相关类
public class Sample_4_6 extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {		//重写onCreate方法
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        CheckBox cb=(CheckBox)this.findViewById(R.id.CheckBox01);  
        cb.setOnCheckedChangeListener(new OnCheckedChangeListener(){//为CheckBox添加监听器及开关灯业务代码
			@Override
			public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
				setBulbState(isChecked);	
			}
        });
        RadioButton rb=(RadioButton)findViewById(R.id.off);
        rb.setOnCheckedChangeListener(new OnCheckedChangeListener(){ //为RadioButton添加监听器及开关灯业务代码
			@Override
			public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
				setBulbState(!isChecked);
			}
        });
    }
    //方法：设置程序状态的
    public void setBulbState(boolean state){
    	//设置图片状态
    	ImageView iv=(ImageView)findViewById(R.id.ImageView01);
		iv.setImageResource((state)?R.drawable.bulb_on:R.drawable.bulb_off);
		CheckBox cb=(CheckBox)this.findViewById(R.id.CheckBox01);  
		cb.setText((state)?R.string.off:R.string.on);		
		cb.setChecked(state);							//设置复选框文字状态
		RadioButton rb=(RadioButton)findViewById(R.id.off);
		rb.setChecked(!state);
		rb=(RadioButton)findViewById(R.id.on);
		rb.setChecked(state);							//设置单选按钮状态
    }
}