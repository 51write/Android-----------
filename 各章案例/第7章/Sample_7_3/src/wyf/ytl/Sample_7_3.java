package wyf.ytl;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
public class Sample_7_3 extends Activity {
	MyButton myButton01;//声明myButton01的引用
	MyButton myButton02;//声明myButton02的引用
	MyButton myButton03;//声明myButton03的引用
	MyButton myButton04;//声明myButton04的引用
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myButton01 = new MyButton(this);//初始化myButton01
        myButton02 = new MyButton(this);//初始化myButton02
        myButton03 = new MyButton(this);//初始化myButton03
        myButton04 = new MyButton(this);//初始化myButton04
        myButton01.setText("myButton01");//设置myButton01上的文字
        myButton02.setText("myButton02");//设置myButton02上的文字
        myButton03.setText("myButton03");//设置myButton03上的文字
        myButton04.setText("myButton04");//设置myButton04上的文字
        LinearLayout LinearLayout1 = new LinearLayout(this);//创建一个线性布局
        LinearLayout1.setOrientation(LinearLayout.VERTICAL);//设置其布局方式
        LinearLayout1.addView(myButton01);//将myButton01添加到布局中
        LinearLayout1.addView(myButton02);//将myButton02添加到布局中
        LinearLayout1.addView(myButton03);//将myButton03添加到布局中
        LinearLayout1.addView(myButton04);//将myButton04添加到布局中
        setContentView(LinearLayout1);//设置当前的用户界面
    }
    class MyButton extends Button{//自定义Button
		public MyButton(Context context) {//构造器
			super(context);
		}
		@Override
		protected void onFocusChanged(boolean focused, int direction,
				Rect previouslyFocusedRect) {//重写的焦点变化方法
			Log.d("Button", this.getText() + ", focused = " + focused + ", direction = " + direction
					+ ", previouslyFocusedRect = " + previouslyFocusedRect);
			super.onFocusChanged(focused, direction, previouslyFocusedRect);
		}
    }
}