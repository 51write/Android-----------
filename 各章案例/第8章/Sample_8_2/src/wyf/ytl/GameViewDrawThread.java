package wyf.ytl;						//���������
import android.graphics.Canvas;			//���������
import android.view.SurfaceHolder;		//���������
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
            	// �����������������ڴ�Ҫ��Ƚϸߵ�����£����������ҪΪnull
                c = this.surfaceHolder.lockCanvas(null);
                synchronized (this.surfaceHolder) {
                	gameView.doDraw(c);//����
                }
            } finally {
                if (c != null) {
                	//������Ļ��ʾ����
                    this.surfaceHolder.unlockCanvasAndPost(c);
                }
            }
            try{
            	Thread.sleep(sleepSpan);//˯��ָ��������
            }
            catch(Exception e){
            	e.printStackTrace();//��ӡ��ջ��Ϣ
            }
        }
	}
}
