package wyf.jc;					//���������
import android.app.Activity;		//���������
import android.os.Bundle;			//���������
import android.view.View;			//���������
import android.widget.Button;			//���������
import android.widget.LinearLayout;		//���������

public class LinearActivity extends Activity {
	int count=0;				//����������¼��ť����
    @Override
    public void onCreate(Bundle savedInstanceState) {	//��дonCreate����
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button button = (Button) findViewById(R.id.Button01); 	//��ȡ��Ļ�еİ�ť�ؼ�����
        button.setOnClickListener(		//Ϊ��ť�������OnClickListener�ӿ�ʵ��
           //OnClickListenerΪView���ڲ��ӿڣ���ʵ���߸������������¼�
        	new View.OnClickListener(){ 
    			public void onClick(View v){             	
    				LinearLayout ll=(LinearLayout)findViewById(R.id.lla); //��ȡ���Բ��ֶ���
					String msg=LinearActivity.this.getResources().getString(R.string.button);
					Button tempbutton=new Button(LinearActivity.this);	//����һ��Button����
					tempbutton.setText(msg+(++count));	//����Button�ؼ���ʾ������
					tempbutton.setWidth(80);			//����Button�Ŀ��
					ll.addView(tempbutton);				//�����Բ��������View
					System.out.println("========= count"+count);
    			} 
    		}
        ); 
	}
}