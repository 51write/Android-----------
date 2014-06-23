package wyf.jc;								//���������
import java.util.Calendar;					//���������
import android.app.Activity;				//���������
import android.app.DatePickerDialog;		//���������
import android.app.Dialog;					//���������
import android.app.TimePickerDialog;		//���������
import android.os.Bundle;					//���������
import android.view.View;					//���������
import android.view.View.OnClickListener;	//���������
import android.widget.Button;				//���������	
import android.widget.DatePicker;			//���������
import android.widget.EditText;				//���������
import android.widget.TimePicker;			//���������
public class Sample_6_7 extends Activity {
    final int DATE_DIALOG=0;				//����ѡ��Ի���id	
    final int TIME_DIALOG=1;				//ʱ��ѡ��Ի���id	
    Calendar c=null;						//����һ����������
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);        
        //�����ڶԻ���İ�ť
        Button bDate =(Button) this.findViewById(R.id.Button01);
        bDate.setOnClickListener(
        		new OnClickListener(){
					@Override
					public void onClick(View v){		//��дonClick����
						showDialog(DATE_DIALOG);		//�򿪵�ѡ�б�Ի���				
					}        			
        		}
        ); 
        //��ʱ��Ի���İ�ť
        Button bTime =(Button) this.findViewById(R.id.Button02);
        bTime.setOnClickListener(
        		new OnClickListener(){
					@Override
					public void onClick(View v){		//��дonClick����
						showDialog(TIME_DIALOG);		//�򿪵�ѡ�б�Ի���				
					}        			
        		}
        );  
    }
    @Override
    public Dialog onCreateDialog(int id){		//��дonCreateDialog����
    	Dialog dialog=null;
    	switch(id){					//��id�����ж�
    	  case DATE_DIALOG://�������ڶԻ���Ĵ���
    		   c=Calendar.getInstance();//��ȡ���ڶ���
    		   dialog=new DatePickerDialog(			//����DatePickerDialog����
    		     this,
    		     new DatePickerDialog.OnDateSetListener(){	//����OnDateSetListener������
					@Override
					public void onDateSet(DatePicker dp, int year, int month,int dayOfMonth) {		
						EditText et = (EditText)findViewById(R.id.et);
						et.setText("��ѡ���ˣ�"+year+"��"+month+"��"+dayOfMonth+"��");
					}    		    	 
    		     },
    		     c.get(Calendar.YEAR),					//�������
    		     c.get(Calendar.MONTH),					//�����·�
    		     c.get(Calendar.DAY_OF_MONTH)    		//��������     
    		  );
    	  break;
    	  case TIME_DIALOG://����ʱ��Ի���Ĵ���
    		  c=Calendar.getInstance();//��ȡ���ڶ���
    		  dialog=new TimePickerDialog(				//����TimePickerDialog����
    			this,
    			new TimePickerDialog.OnTimeSetListener(){ //����OnTimeSetListener������
					@Override
					public void onTimeSet(TimePicker tp, int hourOfDay, int minute) {
						EditText et = (EditText)findViewById(R.id.et);
						et.setText("��ѡ���ˣ�"+hourOfDay+"ʱ"+minute+"��");		//����EditText�ؼ�������
					}    				 
    			 },
    			 c.get(Calendar.HOUR_OF_DAY),		//���뵱ǰСʱ��
    			 c.get(Calendar.MINUTE),			//���뵱ǰ������
    			 false
    		  );
    		  break;
    	}
    	return dialog;
    }
}