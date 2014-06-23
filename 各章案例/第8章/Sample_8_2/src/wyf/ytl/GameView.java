package wyf.ytl;			//声明包语句
import android.graphics.Bitmap;			//引入相关类
import android.graphics.BitmapFactory;	//引入相关类
import android.graphics.Canvas;			//引入相关类
import android.view.MotionEvent;		//引入相关类
import android.view.SurfaceHolder;		//引入相关类
import android.view.SurfaceView;		//引入相关类
public class GameView extends SurfaceView implements SurfaceHolder.Callback{
	Sample_8_2 activity;		//Activity引用
	TimeThread tt;				//TimeThread引用
	BallGoThread bgt;			//BallGoThread引用
	int backSize=16;//背景尺寸
	int screenWidth = 320;//屏幕宽度
	int screenHeight = 480;//屏幕高度
	int bannerWidth=40;//板宽度
	int bannerHeight=6;//板高度
	int bottomSpance=16;//底下空白
	int bannerSpan=5;//板步进
	int ballSpan=8;//球步进
	int ballSize=16;//小球尺寸
	int hintWidth=100;//提示宽度
	int hintHeight=20;//提示高度
	
    int status=0;  //0-等待开始   1-进行中   2-游戏结束  3-游戏胜利
    int score=0;//得分    
    int ballx;//小球x坐标
    int bally;//小球y坐标
    int direction=0;//小球方向 
    int bannerX;//板X坐标
    int bannerY;//板Y坐标    
    int scoreWidth = 32;
    
    
    Bitmap iback;//背景图
    Bitmap[] iscore=new Bitmap[10];//得分图
    Bitmap iball;//球
    Bitmap ibanner;//板
    Bitmap ibegin;//开始
    Bitmap igameover;//游戏结束
    Bitmap iwin;//游戏结束
    Bitmap iexit;//退出
    Bitmap ireplay;//重玩	
    GameViewDrawThread gameViewGrawThread;
	public GameView(Sample_8_2 activity) {
		super(activity);
		getHolder().addCallback(this);//注册接口
		this.activity = activity;
		initBitmap();
		gameViewGrawThread = new GameViewDrawThread(this);
	}
	public void initBitmap(){
		iback = BitmapFactory.decodeResource(getResources(), R.drawable.back);
		iscore[0] = BitmapFactory.decodeResource(getResources(), R.drawable.d0);
		iscore[1] = BitmapFactory.decodeResource(getResources(), R.drawable.d1);
		iscore[2] = BitmapFactory.decodeResource(getResources(), R.drawable.d2);
		iscore[3] = BitmapFactory.decodeResource(getResources(), R.drawable.d3);
		iscore[4] = BitmapFactory.decodeResource(getResources(), R.drawable.d4);
		iscore[5] = BitmapFactory.decodeResource(getResources(), R.drawable.d5);
		iscore[6] = BitmapFactory.decodeResource(getResources(), R.drawable.d6);
		iscore[7] = BitmapFactory.decodeResource(getResources(), R.drawable.d7);
		iscore[8] = BitmapFactory.decodeResource(getResources(), R.drawable.d8);
		iscore[9] = BitmapFactory.decodeResource(getResources(), R.drawable.d9);
		iball = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
		ibanner = BitmapFactory.decodeResource(getResources(), R.drawable.banner);
		ibegin = BitmapFactory.decodeResource(getResources(), R.drawable.begin);
		igameover = BitmapFactory.decodeResource(getResources(), R.drawable.gameover);
		iwin = BitmapFactory.decodeResource(getResources(), R.drawable.win);
		iexit = BitmapFactory.decodeResource(getResources(), R.drawable.exit);
		ireplay = BitmapFactory.decodeResource(getResources(), R.drawable.replay);
		//初始化小球位置及板X坐标
		initBallAndBanner();
	}
	public void initBallAndBanner(){
		//初始化小球位置
		bally=screenHeight-bottomSpance-bannerHeight-ballSize;
		ballx=screenWidth/2-ballSize/2;
		//初始化板X坐标
		bannerX=screenWidth/2-bannerWidth/2;
		bannerY=screenHeight-bottomSpance-bannerHeight;				
	}
	public void replay(){
		if(status==2||status==3){	
	    	//初始化小球位置及板X坐标
			initBallAndBanner();
			score=0;
			status=0;
			direction=3;
		}	
	}
	public void doDraw(Canvas canvas) {
    	//清背景
    	int cols=screenWidth/backSize+((screenWidth%backSize==0)?0:1);//列数
    	int rows=screenHeight/backSize+((screenHeight%backSize==0)?0:1);//行数
    	for(int i=0;i<rows;i++){
    		for(int j=0;j<cols;j++){
    			canvas.drawBitmap(iback, 16*j,16*i, null);
    		}
    	}
    	
    	//绘制得分
    	String scoreStr=score+""; 
    	int loop=3-scoreStr.length();
    	for(int i=0;i<loop;i++){
    		scoreStr="0"+scoreStr;
    	}
    	int startX=screenWidth-scoreWidth*3-10;
    	for(int i=0;i<3;i++){
    		int tempScore=scoreStr.charAt(i)-'0';
    		canvas.drawBitmap(iscore[tempScore], startX+i*scoreWidth,5, null);
    	}
    	
    	//绘制小球
    	canvas.drawBitmap(iball,ballx,bally, null);
    	
    	//绘制板
    	canvas.drawBitmap(ibanner,bannerX,bannerY, null);
    	
    	//绘制开始提示
    	if(status==0){
    		canvas.drawBitmap(    			
    			ibegin,
    			screenWidth/2-hintWidth/2,
    		    screenHeight/2-hintHeight/2, null
    		);
    	}

     	//绘制失败提示
    	if(status==2){
    		canvas.drawBitmap(    			
    			igameover,
    			screenWidth/2-hintWidth/2,
    		    screenHeight/2-hintHeight/2, null
    		);   		
    	}  
    	
    	//绘制胜利
     	if(status==3){
     		canvas.drawBitmap(    			
     			iwin,
    			screenWidth/2-hintWidth/2,
    		    screenHeight/2-hintHeight/2, null
    		);
    	}  
     	
     	
    	//绘制退出选项
     	canvas.drawBitmap(			
     		iexit,
			screenWidth-32,
		    screenHeight-16,null
	    );     	
		//绘制重玩选项 ireplay   		
    	if(status==2||status==3){
    		canvas.drawBitmap(				
    			ireplay ,
				0,
			    screenHeight-16,null
    		);    		
    	}  	
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int x = (int) event.getX();						 	//获取被点击处的x坐标
		int y = (int) event.getY();							//获取被点击处的y坐标
		if(x<screenWidth&&x>screenWidth-32
		    	  &&y<screenHeight&&y>screenHeight-16){//按下退出选项
		    System.exit(0);								//退出程序
		}
		if(status == 0){							//等待状态，按下任意键开始游戏
			status=1;									//设置状态值
			tt=new TimeThread(this);					//创建新的计时线程	
			bgt=new BallGoThread(this);					//创建新的BallThread
			tt.start();									//启动相关线程
			bgt.start();	  		
		}
		else if(status == 1){						//如果是游戏状态下
			bannerX = x;							//移动挡板的位置
		}
		else if(status==2||status==3){				//如果是游戏失败或胜利
			if(x<32&&x>0&&y<screenHeight&&y>screenHeight-16){//按下重玩选项
			    replay();					//调用方法重新开始游戏
			}    		
		}
		return super.onTouchEvent(event);
	}
	
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}
	public void surfaceCreated(SurfaceHolder holder) {//创建时启动相应进程
        this.gameViewGrawThread.flag = true;
        gameViewGrawThread.start();
	}
	public void surfaceDestroyed(SurfaceHolder holder) {//摧毁时释放相应进程
        boolean retry = true;
        this.gameViewGrawThread.flag =  false;
        while (retry) {
            try {
            	gameViewGrawThread.join();
                retry = false;
            } 
            catch (InterruptedException e) {}//不断地循环，直到刷帧线程结束
        }
	}	
}
