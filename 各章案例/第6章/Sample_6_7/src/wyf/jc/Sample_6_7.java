package wyf.jc;								//声明包语句
import java.util.Calendar;					//引入相关类
import android.app.Activity;				//引入相关类
import android.app.DatePickerDialog;		//引入相关类
import android.app.Dialog;					//引入相关类
import android.app.TimePickerDialog;		//引入相关类
import android.os.Bundle;					//引入相关类
import android.view.View;					//引入相关类
import android.view.View.OnClickListener;	//引入相关类
import android.widget.Button;				//引入相关类	
import android.widget.DatePicker;			//引入相关类
import android.widget.EditText;				//引入相关类
import android.widget.TimePicker;			//引入相关类
public class Sample_6_7 extends Activity {
    final int DATE_DIALOG=0;				//日期选择对话框id	
    final int TIME_DIALOG=1;				//时间选择对话框id	
    Calendar c=null;						//声明一个日历对象
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);        
        //打开日期对话框的按钮
        Button bDate =(Button) this.findViewById(R.id.Button01);
        bDate.setOnClickListener(
        		new OnClickListener(){
					@Override
					public void onClick(View v){		//重写onClick方法
						showDialog(DATE_DIALOG);		//打开单选列表对话框				
					}        			
        		}
        ); 
        //打开时间对话框的按钮
        Button bTime =(Button) this.findViewById(R.id.Button02);
        bTime.setOnClickListener(
        		new OnClickListener(){
					@Override
					public void onClick(View v){		//重写onClick方法
						showDialog(TIME_DIALOG);		//打开单选列表对话框				
					}        			
        		}
        );  
    }
    @Override
    public Dialog onCreateDialog(int id){		//重写onCreateDialog方法
    	Dialog dialog=null;
    	switch(id){					//对id进行判断
    	  case DATE_DIALOG://生成日期对话框的代码
    		   c=Calendar.getInstance();//获取日期对象
    		   dialog=new DatePickerDialog(			//创建DatePickerDialog对象
    		     this,
    		     new DatePickerDialog.OnDateSetListener(){	//创建OnDateSetListener监听器
					@Override
					public void onDateSet(DatePicker dp, int year, int month,int dayOfMonth) {		
						EditText et = (EditText)findViewById(R.id.et);
						et.setText("您选择了："+year+"年"+month+"月"+dayOfMonth+"日");
					}    		    	 
    		     },
    		     c.get(Calendar.YEAR),					//传入年份
    		     c.get(Calendar.MONTH),					//传入月份
    		     c.get(Calendar.DAY_OF_MONTH)    		//传入天数     
    		  );
    	  break;
    	  case TIME_DIALOG://生成时间对话框的代码
    		  c=Calendar.getInstance();//获取日期对象
    		  dialog=new TimePickerDialog(				//创建TimePickerDialog对象
    			this,
    			new TimePickerDialog.OnTimeSetListener(){ //创建OnTimeSetListener监听器
					@Override
					public void onTimeSet(TimePicker tp, int hourOfDay, int minute) {
						EditText et = (EditText)findViewById(R.id.et);
						et.setText("您选择了："+hourOfDay+"时"+minute+"分");		//设置EditText控件的属性
					}    				 
    			 },
    			 c.get(Calendar.HOUR_OF_DAY),		//传入当前小时数
    			 c.get(Calendar.MINUTE),			//传入当前分钟数
    			 false
    		  );
    		  break;
    	}
    	return dialog;
    }
}