package wyf.jc;								//���������
import android.app.Activity;				//���������
import android.os.Bundle;					//���������
import android.view.View;					//���������
import android.view.View.OnClickListener;	//���������
import android.widget.Button;				//���������
public class Sample_4_2 extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {		//��дonCreate����
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);						//���õ�ǰ��Ļ
        Button btn = (Button)findViewById(R.id.btn);		//��ȡButton�ؼ�����
        btn.setOnClickListener(new OnClickListener(){		//���OnClickListener������
			@Override
			public void onClick(View v) {				//��дonClick����
				Button btn = (Button)findViewById(R.id.btn);	//��ȡButton����
				btn.setBackgroundDrawable(getResources().getDrawable(R.color.btn));	//���ð�ť����
				btn.setText(R.string.btn2);			//���ð�ť��ʾ����
			}
        });
    }
}