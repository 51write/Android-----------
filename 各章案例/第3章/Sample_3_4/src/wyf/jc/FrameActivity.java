package wyf.jc;						//���������

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class FrameActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {	//��дonCreate����
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);			//���õ�ǰ��Ļ
    }
    public void myClick(View view){
    	FrameLayout fl = (FrameLayout)view;
    	fl.setForeground(null);
    }
}