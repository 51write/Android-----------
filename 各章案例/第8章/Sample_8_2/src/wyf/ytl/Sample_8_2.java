package wyf.ytl;				//声明包语句
import android.app.Activity;		//引入相关类
import android.os.Bundle;				//引入相关类
import android.view.Window;//引入相关类
import android.view.WindowManager;		//引入相关类
public class Sample_8_2 extends Activity {
	GameView gameView;							//GameView对象引用
    @Override
    public void onCreate(Bundle savedInstanceState) {	//重写onCreate方法
        super.onCreate(savedInstanceState);
		//设置全屏
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN ,  
		              WindowManager.LayoutParams.FLAG_FULLSCREEN);
        gameView = new GameView(this);			//创建GameView
        setContentView(gameView);				//设置当前屏幕
    }

}