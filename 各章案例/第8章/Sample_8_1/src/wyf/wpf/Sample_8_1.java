package wyf.wpf;				//���������
import android.app.Activity;		//���������
import android.os.Bundle;			//���������
import android.view.Window;			//���������
import android.view.WindowManager;	//���������
public class Sample_8_1 extends Activity {
	MyView myView;			//MyView��������
	MyThread mt;			//MyThread��������
    @Override
    public void onCreate(Bundle savedInstanceState) {	//��дonCreate����
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);	//���ò���ʾӦ�ó��������
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        		WindowManager.LayoutParams.FLAG_FULLSCREEN);	//����ȫ��
        myView = new MyView(this);			//����MyView����
        setContentView(myView);				//���õ�ǰ��Ļ
        mt = new MyThread(myView);			//����MyThread����
        mt.start();							//����MyThread
    }
}