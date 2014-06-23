package wyf.jc;				//声明包语句
import java.util.Calendar;	//引入相关类
import android.app.Activity;		//引入相关类
import android.os.Bundle;			//引入相关类
import android.widget.DatePicker;	//引入相关类
import android.widget.EditText;		//引入相关类
import android.widget.TimePicker;	//引入相关类
import android.widget.DatePicker.OnDateChangedListener;	//引入相关类
import android.widget.TimePicker.OnTimeChangedListener;	//引入相关类
public class Sample_4_9 extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {		//重写onCreate方法
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);						//设置当前屏幕
        DatePicker dp = (DatePicker)findViewById(R.id.datepicker);
        TimePicker tp = (TimePicker)findViewById(R.id.timepicker);
        Calendar c = Calendar.getInstance();				//获得Calendar对象
        int year = c.get(Calendar.YEAR);
        int monthOfYear = c.get(Calendar.MONTH);
        int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
        dp.init(year, monthOfYear, dayOfMonth, new OnDateChangedListener(){	//初始化DatePicker
			@Override
			public void onDateChanged(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				flushDate(year,monthOfYear,dayOfMonth);	//更新EditText所显示内容
			}
        });
        tp.setOnTimeChangedListener(new OnTimeChangedListener(){		//为TimePicker添加监听器
			@Override
			public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
				flushTime(hourOfDay,minute);			//更新EditText所显示内容
			}
        });
    }
    //方法：刷新EditText所显示的内容
    public void flushDate(int year, int monthOfYear,int dayOfMonth){
    	EditText et = (EditText)findViewById(R.id.etDate);
    	et.setText("您选择的日期是："+year+"年"+(monthOfYear+1)+"月"+dayOfMonth+"日。");
    }
    //方法：刷新时间EditText所显示的内容
    public void flushTime(int hourOfDay,int minute){
    	EditText et = (EditText)findViewById(R.id.etTime);
    	et.setText("您选择的时间是："+hourOfDay+"时"+minute+"分。");
	}    
}