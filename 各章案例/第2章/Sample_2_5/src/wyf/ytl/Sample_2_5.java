package wyf.ytl;
import android.app.Activity;
import android.os.Bundle;
public class Sample_2_5 extends Activity {//继承自Activity
	MyView myView;//myView的引用
    public void onCreate(Bundle savedInstanceState) {//重写的onCreate方法
        super.onCreate(savedInstanceState);
        myView =  new MyView(this);//初始化自定义View
        this.setContentView(myView);//设置当前的用户界面
    }
}