package wyf.jc;								//���������
import android.app.Activity;						//���������
import android.os.Bundle;				//���������
import android.view.Gravity;
import android.view.View;						//���������
import android.widget.Button;				//���������
import android.widget.ImageView;				//���������
import android.widget.LinearLayout;				//���������
import android.widget.Toast;				//���������
public class Sample_6_9 extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {	//��дonCreate����
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);					//���õ�ǰ��Ļ
        Button btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {	//Ϊ��ť��Ӽ�����
			@Override
			public void onClick(View v) {
				ImageView iv = new ImageView(Sample_6_9.this);	//����ImageView
				iv.setImageResource(R.drawable.header2);		//����ImageView����ʾ����
				LinearLayout ll = new LinearLayout(Sample_6_9.this);	//����һ�����Բ���
				Toast toast = Toast.makeText(Sample_6_9.this, "����һ����ͼƬ��Toast", Toast.LENGTH_LONG);
				toast.setGravity(Gravity.CENTER, 0, 0);
				View toastView = toast.getView();			//���Toast��View
				ll.setOrientation(LinearLayout.HORIZONTAL);		//�������Բ��ֵ����з�ʽ
				ll.addView(iv);							//��ImageView��ӵ����Բ���
				ll.addView(toastView);					//��Toast��View��ӵ����Բ���
				toast.setView(ll);
				toast.show();							//��ʾToast
			}
		});
    }
}