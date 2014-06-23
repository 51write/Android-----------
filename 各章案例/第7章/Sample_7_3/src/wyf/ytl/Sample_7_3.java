package wyf.ytl;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
public class Sample_7_3 extends Activity {
	MyButton myButton01;//����myButton01������
	MyButton myButton02;//����myButton02������
	MyButton myButton03;//����myButton03������
	MyButton myButton04;//����myButton04������
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myButton01 = new MyButton(this);//��ʼ��myButton01
        myButton02 = new MyButton(this);//��ʼ��myButton02
        myButton03 = new MyButton(this);//��ʼ��myButton03
        myButton04 = new MyButton(this);//��ʼ��myButton04
        myButton01.setText("myButton01");//����myButton01�ϵ�����
        myButton02.setText("myButton02");//����myButton02�ϵ�����
        myButton03.setText("myButton03");//����myButton03�ϵ�����
        myButton04.setText("myButton04");//����myButton04�ϵ�����
        LinearLayout LinearLayout1 = new LinearLayout(this);//����һ�����Բ���
        LinearLayout1.setOrientation(LinearLayout.VERTICAL);//�����䲼�ַ�ʽ
        LinearLayout1.addView(myButton01);//��myButton01��ӵ�������
        LinearLayout1.addView(myButton02);//��myButton02��ӵ�������
        LinearLayout1.addView(myButton03);//��myButton03��ӵ�������
        LinearLayout1.addView(myButton04);//��myButton04��ӵ�������
        setContentView(LinearLayout1);//���õ�ǰ���û�����
    }
    class MyButton extends Button{//�Զ���Button
		public MyButton(Context context) {//������
			super(context);
		}
		@Override
		protected void onFocusChanged(boolean focused, int direction,
				Rect previouslyFocusedRect) {//��д�Ľ���仯����
			Log.d("Button", this.getText() + ", focused = " + focused + ", direction = " + direction
					+ ", previouslyFocusedRect = " + previouslyFocusedRect);
			super.onFocusChanged(focused, direction, previouslyFocusedRect);
		}
    }
}