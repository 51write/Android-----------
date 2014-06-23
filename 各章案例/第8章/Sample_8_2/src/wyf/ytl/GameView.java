package wyf.ytl;			//���������
import android.graphics.Bitmap;			//���������
import android.graphics.BitmapFactory;	//���������
import android.graphics.Canvas;			//���������
import android.view.MotionEvent;		//���������
import android.view.SurfaceHolder;		//���������
import android.view.SurfaceView;		//���������
public class GameView extends SurfaceView implements SurfaceHolder.Callback{
	Sample_8_2 activity;		//Activity����
	TimeThread tt;				//TimeThread����
	BallGoThread bgt;			//BallGoThread����
	int backSize=16;//�����ߴ�
	int screenWidth = 320;//��Ļ���
	int screenHeight = 480;//��Ļ�߶�
	int bannerWidth=40;//����
	int bannerHeight=6;//��߶�
	int bottomSpance=16;//���¿հ�
	int bannerSpan=5;//�岽��
	int ballSpan=8;//�򲽽�
	int ballSize=16;//С��ߴ�
	int hintWidth=100;//��ʾ���
	int hintHeight=20;//��ʾ�߶�
	
    int status=0;  //0-�ȴ���ʼ   1-������   2-��Ϸ����  3-��Ϸʤ��
    int score=0;//�÷�    
    int ballx;//С��x����
    int bally;//С��y����
    int direction=0;//С���� 
    int bannerX;//��X����
    int bannerY;//��Y����    
    int scoreWidth = 32;
    
    
    Bitmap iback;//����ͼ
    Bitmap[] iscore=new Bitmap[10];//�÷�ͼ
    Bitmap iball;//��
    Bitmap ibanner;//��
    Bitmap ibegin;//��ʼ
    Bitmap igameover;//��Ϸ����
    Bitmap iwin;//��Ϸ����
    Bitmap iexit;//�˳�
    Bitmap ireplay;//����	
    GameViewDrawThread gameViewGrawThread;
	public GameView(Sample_8_2 activity) {
		super(activity);
		getHolder().addCallback(this);//ע��ӿ�
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
		//��ʼ��С��λ�ü���X����
		initBallAndBanner();
	}
	public void initBallAndBanner(){
		//��ʼ��С��λ��
		bally=screenHeight-bottomSpance-bannerHeight-ballSize;
		ballx=screenWidth/2-ballSize/2;
		//��ʼ����X����
		bannerX=screenWidth/2-bannerWidth/2;
		bannerY=screenHeight-bottomSpance-bannerHeight;				
	}
	public void replay(){
		if(status==2||status==3){	
	    	//��ʼ��С��λ�ü���X����
			initBallAndBanner();
			score=0;
			status=0;
			direction=3;
		}	
	}
	public void doDraw(Canvas canvas) {
    	//�屳��
    	int cols=screenWidth/backSize+((screenWidth%backSize==0)?0:1);//����
    	int rows=screenHeight/backSize+((screenHeight%backSize==0)?0:1);//����
    	for(int i=0;i<rows;i++){
    		for(int j=0;j<cols;j++){
    			canvas.drawBitmap(iback, 16*j,16*i, null);
    		}
    	}
    	
    	//���Ƶ÷�
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
    	
    	//����С��
    	canvas.drawBitmap(iball,ballx,bally, null);
    	
    	//���ư�
    	canvas.drawBitmap(ibanner,bannerX,bannerY, null);
    	
    	//���ƿ�ʼ��ʾ
    	if(status==0){
    		canvas.drawBitmap(    			
    			ibegin,
    			screenWidth/2-hintWidth/2,
    		    screenHeight/2-hintHeight/2, null
    		);
    	}

     	//����ʧ����ʾ
    	if(status==2){
    		canvas.drawBitmap(    			
    			igameover,
    			screenWidth/2-hintWidth/2,
    		    screenHeight/2-hintHeight/2, null
    		);   		
    	}  
    	
    	//����ʤ��
     	if(status==3){
     		canvas.drawBitmap(    			
     			iwin,
    			screenWidth/2-hintWidth/2,
    		    screenHeight/2-hintHeight/2, null
    		);
    	}  
     	
     	
    	//�����˳�ѡ��
     	canvas.drawBitmap(			
     		iexit,
			screenWidth-32,
		    screenHeight-16,null
	    );     	
		//��������ѡ�� ireplay   		
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
		int x = (int) event.getX();						 	//��ȡ���������x����
		int y = (int) event.getY();							//��ȡ���������y����
		if(x<screenWidth&&x>screenWidth-32
		    	  &&y<screenHeight&&y>screenHeight-16){//�����˳�ѡ��
		    System.exit(0);								//�˳�����
		}
		if(status == 0){							//�ȴ�״̬�������������ʼ��Ϸ
			status=1;									//����״ֵ̬
			tt=new TimeThread(this);					//�����µļ�ʱ�߳�	
			bgt=new BallGoThread(this);					//�����µ�BallThread
			tt.start();									//��������߳�
			bgt.start();	  		
		}
		else if(status == 1){						//�������Ϸ״̬��
			bannerX = x;							//�ƶ������λ��
		}
		else if(status==2||status==3){				//�������Ϸʧ�ܻ�ʤ��
			if(x<32&&x>0&&y<screenHeight&&y>screenHeight-16){//��������ѡ��
			    replay();					//���÷������¿�ʼ��Ϸ
			}    		
		}
		return super.onTouchEvent(event);
	}
	
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}
	public void surfaceCreated(SurfaceHolder holder) {//����ʱ������Ӧ����
        this.gameViewGrawThread.flag = true;
        gameViewGrawThread.start();
	}
	public void surfaceDestroyed(SurfaceHolder holder) {//�ݻ�ʱ�ͷ���Ӧ����
        boolean retry = true;
        this.gameViewGrawThread.flag =  false;
        while (retry) {
            try {
            	gameViewGrawThread.join();
                retry = false;
            } 
            catch (InterruptedException e) {}//���ϵ�ѭ����ֱ��ˢ֡�߳̽���
        }
	}	
}
