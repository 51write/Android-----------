package wyf.jc;					//���������
import android.app.Activity;		//���������
import android.os.Bundle;			//���������
import android.view.KeyEvent;		//���������
import android.view.View;			//���������
import android.view.View.OnKeyListener;	//���������
import android.widget.EditText;			//���������
public class Sample_4_1 extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {		//��дonCreate����
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);						//���õ�ǰ��Ļ
        EditText etEmail = (EditText)findViewById(R.id.etEmail);
        etEmail.setOnKeyListener(myOnKeyListener);			//ΪEditText�ؼ�����OnKeyListner������
    }
    private OnKeyListener myOnKeyListener = new OnKeyListener(){	//�Զ����OnKeyListner����
		@Override
		public boolean onKey(View v, int keyCode, KeyEvent event) {	//��дonKey����
			EditText etInfo = (EditText)findViewById(R.id.etInfo);	
			EditText etEmail = (EditText)findViewById(R.id.etEmail);
			etInfo.setText("������������ַΪ��"+etEmail.getText());			//����EditText�ؼ�����ʾ����
			return false;
		}
    };
}