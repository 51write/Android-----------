package wyf.wpf;								//���������
import android.app.Activity;			//���������
import android.graphics.drawable.AnimationDrawable;	//���������
import android.os.Bundle;		//���������
import android.view.View;		//���������
import android.view.View.OnClickListener;	//���������
import android.widget.Button;	//���������
import android.widget.ImageView;	//���������
public class Sample_4_10 extends Activity {	
    @Override
    public void onCreate(Bundle savedInstanceState) {	//��дonCreate����
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new OnClickListener() {	//Ϊ��ť���ü�����
			@Override	
			public void onClick(View v) {			//��дonClick����
		        ImageView iv = (ImageView)findViewById(R.id.iv);
		        iv.setBackgroundResource(R.anim.frame_ani);
		        AnimationDrawable ad = (AnimationDrawable)iv.getBackground();
		        ad.start();		//����AnimationDrawable
			}
		});
    }
}