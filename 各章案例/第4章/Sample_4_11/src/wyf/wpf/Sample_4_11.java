package wyf.wpf;						//���������
import android.app.Activity;		//���������
import android.os.Bundle;			//���������
import android.view.View;		//���������
import android.view.View.OnClickListener;		//���������
import android.view.animation.Animation;		//���������
import android.view.animation.AnimationUtils;	//���������
import android.widget.Button;		//���������
import android.widget.ImageView;		//���������
public class Sample_4_11 extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {	//��дonCreate����
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);			//������Ļ
        Button btn = (Button)findViewById(R.id.btn);	//��ȡButton����
        btn.setOnClickListener(new OnClickListener() {	//ΪButton�������OnClickListener������
			@Override
			public void onClick(View v) {				//��дonClick����
		        ImageView iv = (ImageView)findViewById(R.id.iv);
		        Animation animation = AnimationUtils.loadAnimation(Sample_4_11.this, R.anim.tween_ani);
		        iv.startAnimation(animation);			//��������			
			}
		});
    }
}