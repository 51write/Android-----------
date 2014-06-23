package wyf.jc;							//���������
import android.app.Activity;			//���������
import android.os.Bundle;				//���������
import android.view.View;				//���������
import android.widget.Button;			//���������
import android.widget.ImageView;		//���������
public class Sample_4_7 extends Activity {
	ImageView iv;				//ImageView��������
	Button btnNext;				//Button��������
	Button btnPrevious;			//Button��������
	Button btnAlphaPlus;		//Button��������
	Button btnAlphaMinus;		//Button��������
	int currImgId = 0;			//��¼��ǰImageView��ʾ��ͼƬid
	int alpha=255;				//��¼ImageView��͸����
	int [] imgId = {			//ImageView��ʾ��ͼƬ����
		R.drawable.p1,	
		R.drawable.p2,
		R.drawable.p3,
		R.drawable.p4,
		R.drawable.p5,
		R.drawable.p6,
		R.drawable.p7,
		R.drawable.p8,
	};
	private View.OnClickListener myListener = new View.OnClickListener(){//�Զ����OnClickListener������
		@Override
		public void onClick(View v) {		//�жϵ��µ����Ǹ�Button
			if(v == btnNext){				//��һ��ͼƬ��ť������
				currImgId = (currImgId+1)%imgId.length;
				iv.setImageResource(imgId[currImgId]);	//����ImageView����ʾͼƬ
			}
			else if(v == btnPrevious){		//��һ��ͼƬ��ť������
				currImgId = (currImgId-1+imgId.length)%imgId.length;
				
				iv.setImageResource(imgId[currImgId]);	//����ImageView����ʾͼƬ
			}
			else if(v == btnAlphaPlus){			//����͸���Ȱ�ť������
				alpha -= 25;
				if(alpha < 0){
					alpha =0;
				}
				iv.setAlpha(alpha);			//����ImageView��͸����
			}
			else if(v == btnAlphaMinus){	//����͸���Ȱ�ť������
				alpha += 25;
				if(alpha >255){
					alpha = 255;
				}
				iv.setAlpha(alpha);			//����ImageView��͸����
			}
		}
	};
    @Override
    public void onCreate(Bundle savedInstanceState) {	//��дonCreate����
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        iv = (ImageView)findViewById(R.id.iv);			//���ImageView��������
        btnNext = (Button)findViewById(R.id.next);		//���ImageView��������
        btnPrevious = (Button)findViewById(R.id.previous);	//���ImageView��������
        btnAlphaPlus = (Button)findViewById(R.id.alpha_plus);	//���ImageView��������
        btnAlphaMinus = (Button)findViewById(R.id.alpha_minus);	//���ImageView��������
        btnNext.setOnClickListener(myListener);			//ΪButton��������OnClickListener������
        btnPrevious.setOnClickListener(myListener);		//ΪButton��������OnClickListener������
        btnAlphaPlus.setOnClickListener(myListener);	//ΪButton��������OnClickListener������
        btnAlphaMinus.setOnClickListener(myListener);	//ΪButton��������OnClickListener������
    }
}