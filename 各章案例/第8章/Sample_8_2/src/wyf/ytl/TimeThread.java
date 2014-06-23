package wyf.ytl;			//声明包语句
public class TimeThread extends Thread{
	int highest=60;				//胜利值
	GameView gameView;			//GameView引用
	boolean flag=true;			//线程是否执行标志位
	public TimeThread(GameView gameView){	//构造器
		this.gameView=gameView;
	}
	public void run(){
		while(flag){
			gameView.score++;			//增加时间
			if(gameView.score==highest){	//判断时间是否达到胜利时间
				gameView.status=3;//游戏胜利
				gameView.tt.flag=false;		//停止TimeThread的执行
				gameView.bgt.flag=false;	//停止BallGoThread的执行
			}
			try{
				Thread.sleep(1000);		//休眠1秒钟
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}