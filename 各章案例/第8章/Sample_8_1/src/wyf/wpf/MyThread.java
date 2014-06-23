package wyf.wpf;			//���������
public class MyThread extends Thread{
	int sleepSpan = 30;		//����ʱ��
	MyView myView;			//MyView��������
	
	public MyThread(MyView myView){	//MyThread��Ĺ�����
		this.myView = myView;	
	}
	public void run(){		//�߳�ִ�з���
		while(true){
			//��̬�ű���=====================begin=============
			myView.angle=myView.angle+myView.angleChange;
			if(myView.angle>MyView.ANGLE_MAX){//�������ֵ�������컷��
				myView.angleChange=-3;
			}
			else if(myView.angle<0){//С��0��������컷��
				myView.angleChange=+3;
			}
			//��̬�ű���=====================end===============
			//�ƶ��Զ���=====================begin=============
			switch(myView.direction){
			   case MyView.RIGHT://����
			      myView.centerX=myView.centerX+MyView.SPEED;
			   break;
			   case MyView.UP://����
			      myView.centerY=myView.centerY-MyView.SPEED;
			   break;	
			   case MyView.LEFT ://����
			      myView.centerX=myView.centerX-MyView.SPEED;
			   break;
			   case MyView.DOWN://����
			      myView.centerY=myView.centerY+MyView.SPEED;
			   break;		   	
			}
			if(myView.centerY+myView.radius>MyView.SCREEN_HEIGHT){//�����±߽�
				myView.centerY=myView.centerY-MyView.SPEED;
				myView.direction=MyView.LEFT;
			}
			if(myView.centerY-myView.radius<0){//�����ϱ߽�
				myView.centerY=myView.centerY+MyView.SPEED;
				myView.direction=MyView.RIGHT;
			}			
			if(myView.centerX-myView.radius<0){//������߽�
				myView.centerX=myView.radius;
				myView.direction=MyView.UP;
			}			
			if(myView.centerX+myView.radius>MyView.SCREEN_WIDTH){//�����ұ߽�
				myView.centerX=myView.centerX-MyView.SPEED;
				myView.direction=MyView.DOWN;
			}	
			//�ƶ��Զ���=====================end=============		
			myView.postInvalidate();//�ػ�
			try{
				Thread.sleep(sleepSpan);
			}
			catch(Exception e){
				e.printStackTrace();
			}	
		}
	}
}