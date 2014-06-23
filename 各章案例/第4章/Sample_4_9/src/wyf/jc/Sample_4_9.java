package wyf.jc;				//���������
import java.util.Calendar;	//���������
import android.app.Activity;		//���������
import android.os.Bundle;			//���������
import android.widget.DatePicker;	//���������
import android.widget.EditText;		//���������
import android.widget.TimePicker;	//���������
import android.widget.DatePicker.OnDateChangedListener;	//���������
import android.widget.TimePicker.OnTimeChangedListener;	//���������
public class Sample_4_9 extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {		//��дonCreate����
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);						//���õ�ǰ��Ļ
        DatePicker dp = (DatePicker)findViewById(R.id.datepicker);
        TimePicker tp = (TimePicker)findViewById(R.id.timepicker);
        Calendar c = Calendar.getInstance();				//���Calendar����
        int year = c.get(Calendar.YEAR);
        int monthOfYear = c.get(Calendar.MONTH);
        int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
        dp.init(year, monthOfYear, dayOfMonth, new OnDateChangedListener(){	//��ʼ��DatePicker
			@Override
			public void onDateChanged(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				flushDate(year,monthOfYear,dayOfMonth);	//����EditText����ʾ����
			}
        });
        tp.setOnTimeChangedListener(new OnTimeChangedListener(){		//ΪTimePicker��Ӽ�����
			@Override
			public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
				flushTime(hourOfDay,minute);			//����EditText����ʾ����
			}
        });
    }
    //������ˢ��EditText����ʾ������
    public void flushDate(int year, int monthOfYear,int dayOfMonth){
    	EditText et = (EditText)findViewById(R.id.etDate);
    	et.setText("��ѡ��������ǣ�"+year+"��"+(monthOfYear+1)+"��"+dayOfMonth+"�ա�");
    }
    //������ˢ��ʱ��EditText����ʾ������
    public void flushTime(int hourOfDay,int minute){
    	EditText et = (EditText)findViewById(R.id.etTime);
    	et.setText("��ѡ���ʱ���ǣ�"+hourOfDay+"ʱ"+minute+"�֡�");
	}    
}