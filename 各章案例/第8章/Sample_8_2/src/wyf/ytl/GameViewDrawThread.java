package wyf.ytl;						//声明包语句
import android.graphics.Canvas;			//引入相关类
import android.view.SurfaceHolder;		//引入相关类
public class GameViewDrawThread extends Thread{
	boolean flag = true;
	int sleepSpan = 100;
	GameView gameView;
	SurfaceHolder surfaceHolder;
	public GameViewDrawThread(GameView gameView){
		this.gameView = gameView;
		this.surfaceHolder = gameView.getHolder();
	}
	public void run(){
		Canvas c;
        while (this.flag) {
            c = null;
            try {
            	// 锁定整个画布，在内存要求比较高的情况下，建议参数不要为null
                c = this.surfaceHolder.lockCanvas(null);
                synchronized (this.surfaceHolder) {
                	gameView.doDraw(c);//绘制
                }
            } finally {
                if (c != null) {
                	//更新屏幕显示内容
                    this.surfaceHolder.unlockCanvasAndPost(c);
                }
            }
            try{
            	Thread.sleep(sleepSpan);//睡眠指定毫秒数
            }
            catch(Exception e){
            	e.printStackTrace();//打印堆栈信息
            }
        }
	}
}
