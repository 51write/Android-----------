package wyf.ytl;			//���������
public class TimeThread extends Thread{
	int highest=60;				//ʤ��ֵ
	GameView gameView;			//GameView����
	boolean flag=true;			//�߳��Ƿ�ִ�б�־λ
	public TimeThread(GameView gameView){	//������
		this.gameView=gameView;
	}
	public void run(){
		while(flag){
			gameView.score++;			//����ʱ��
			if(gameView.score==highest){	//�ж�ʱ���Ƿ�ﵽʤ��ʱ��
				gameView.status=3;//��Ϸʤ��
				gameView.tt.flag=false;		//ֹͣTimeThread��ִ��
				gameView.bgt.flag=false;	//ֹͣBallGoThread��ִ��
			}
			try{
				Thread.sleep(1000);		//����1����
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}