package wyf.jc;					//���������
import android.app.Activity;	//���������
import android.os.Bundle;		//���������
public class RelativeActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {	//��дonCreate����
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);					//���õ�ǰ��ĻΪmain.xml
    }
}