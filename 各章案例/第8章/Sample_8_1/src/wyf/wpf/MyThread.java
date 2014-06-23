package wyf.wpf;			//声明包语句
public class MyThread extends Thread{
	int sleepSpan = 30;		//休眠时间
	MyView myView;			//MyView对象引用
	
	public MyThread(MyView myView){	//MyThread类的构造器
		this.myView = myView;	
	}
	public void run(){		//线程执行方法
		while(true){
			//动态张闭嘴=====================begin=============
			myView.angle=myView.angle+myView.angleChange;
			if(myView.angle>MyView.ANGLE_MAX){//超过最大值则进入闭嘴环节
				myView.angleChange=-3;
			}
			else if(myView.angle<0){//小于0则进入张嘴环节
				myView.angleChange=+3;
			}
			//动态张闭嘴=====================end===============
			//移动吃豆者=====================begin=============
			switch(myView.direction){
			   case MyView.RIGHT://向右
			      myView.centerX=myView.centerX+MyView.SPEED;
			   break;
			   case MyView.UP://向上
			      myView.centerY=myView.centerY-MyView.SPEED;
			   break;	
			   case MyView.LEFT ://向左
			      myView.centerX=myView.centerX-MyView.SPEED;
			   break;
			   case MyView.DOWN://向下
			      myView.centerY=myView.centerY+MyView.SPEED;
			   break;		   	
			}
			if(myView.centerY+myView.radius>MyView.SCREEN_HEIGHT){//碰到下边界
				myView.centerY=myView.centerY-MyView.SPEED;
				myView.direction=MyView.LEFT;
			}
			if(myView.centerY-myView.radius<0){//出了上边界
				myView.centerY=myView.centerY+MyView.SPEED;
				myView.direction=MyView.RIGHT;
			}			
			if(myView.centerX-myView.radius<0){//出了左边界
				myView.centerX=myView.radius;
				myView.direction=MyView.UP;
			}			
			if(myView.centerX+myView.radius>MyView.SCREEN_WIDTH){//出了右边界
				myView.centerX=myView.centerX-MyView.SPEED;
				myView.direction=MyView.DOWN;
			}	
			//移动吃豆者=====================end=============		
			myView.postInvalidate();//重绘
			try{
				Thread.sleep(sleepSpan);
			}
			catch(Exception e){
				e.printStackTrace();
			}	
		}
	}
}