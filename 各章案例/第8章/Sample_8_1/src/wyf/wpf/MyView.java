package wyf.wpf;			//声明包语句
import android.content.Context;		//引入相关类
import android.graphics.Bitmap;//引入相关类
import android.graphics.BitmapFactory;//引入相关类
import android.graphics.Canvas;//引入相关类
import android.graphics.Color;//引入相关类
import android.graphics.Paint;//引入相关类
import android.graphics.RectF;//引入相关类
import android.view.View;//引入相关类

public class MyView extends View{
	static final int ANGLE_MAX=50;	//张嘴最大角度
	static final int SPEED=4;		//移动的步进
	static final int SCREEN_WIDTH = 480;
	static final int SCREEN_HEIGHT = 320;
	//四个方向常数
	static final int LEFT=2;	//左
	static final int RIGHT=0;	//右
	static final int UP=3;		//上
	static final int DOWN=1;	//下
	int angle=30;				//当前张嘴总角度
	int angleChange=3;				//角度变化值
	int radius=20;					//半径
	int centerX=radius;				//当前位置
	int centerY=radius;				//当前位置
	long timeStamp=System.currentTimeMillis();	//记录换照片的时间
	int currPhoto;				//当前照片数组中的索引
	int direction = RIGHT;		//记录英雄方向
	Bitmap bmpMan;				//英雄的图片	
	Bitmap [] bmpPhotos;			//照片数组
	int [] imgIds = {				//图片id数组
		R.drawable.a,
		R.drawable.b,
		R.drawable.c,
		R.drawable.d
	};
	public MyView(Context context) {
		super(context);
		bmpMan = BitmapFactory.decodeResource(getResources(), R.drawable.man);
		bmpPhotos = new Bitmap[imgIds.length];
		for(int i=0;i<bmpPhotos.length;i++){
			bmpPhotos[i] = BitmapFactory.decodeResource(getResources(), imgIds[i]);
		}
	}
	@Override
	protected void onDraw(Canvas canvas) {
		Paint paint = new Paint();			//创建画笔对象
		canvas.drawColor(Color.BLACK);		//绘制背景
		canvas.drawBitmap(bmpMan, centerX-radius, centerY-radius, null);	//绘制吃豆小人
		paint.setColor(Color.BLACK);				//设置画笔颜色
		paint.setAntiAlias(true);
		RectF oval = new RectF(centerX-radius-1,centerY-radius-2,centerX-radius-1+2*radius+2,centerY-radius-2+2*radius+4);
		canvas.drawArc(oval, 360-angle+90*direction, 2*angle, true, paint);		//绘制扇形实现张嘴闭嘴
		if(System.currentTimeMillis()-timeStamp > 5000){		//如果时间间隔超过5秒
			timeStamp = System.currentTimeMillis();			//重新记录时间
			currPhoto = (currPhoto+1)%bmpPhotos.length;		//更换照片
		}
		canvas.drawBitmap(bmpPhotos[currPhoto], 80, 40, null);		//绘制照片
		super.onDraw(canvas);
	}
}