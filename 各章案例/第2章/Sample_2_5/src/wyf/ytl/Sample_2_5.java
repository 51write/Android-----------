package wyf.ytl;
import android.app.Activity;
import android.os.Bundle;
public class Sample_2_5 extends Activity {//�̳���Activity
	MyView myView;//myView������
    public void onCreate(Bundle savedInstanceState) {//��д��onCreate����
        super.onCreate(savedInstanceState);
        myView =  new MyView(this);//��ʼ���Զ���View
        this.setContentView(myView);//���õ�ǰ���û�����
    }
}