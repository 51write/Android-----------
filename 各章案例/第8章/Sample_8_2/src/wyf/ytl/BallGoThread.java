package wyf.ytl;							//���������
public class BallGoThread extends Thread{
	GameView father;
	boolean flag=true;	
	public BallGoThread(GameView father){
		this.father=father;
	}	
	public void run(){
		while(flag){
			switch(father.direction){
				case 0://����
				  father.ballx=father.ballx+father.ballSpan;
				  father.bally=father.bally-father.ballSpan;
				  
				  if(father.ballx>=father.screenWidth-father.ballSize){//�����ұ�
				  	father.direction=3;
				  }
				  else if(father.bally<=0){//�����ϱ�
				  	father.direction=1;
				  }
				  break;
				case 3://����
				  father.ballx=father.ballx-father.ballSpan;
				  father.bally=father.bally-father.ballSpan;
				  if(father.ballx<=0){//�������
				  	father.direction=0;
				  }
				  else if(father.bally<=0){//�����ϱ�
				  	father.direction=2;
				  }						  
				  break;					
				case 1://����
				  father.ballx=father.ballx+father.ballSpan;
				  father.bally=father.bally+father.ballSpan;
				  
				  if(father.bally>=
				          father.screenHeight-father.bannerHeight
				          -father.bottomSpance-father.ballSize){//�����±�
				  	 checkCollision(1);
				  }		
				  else if(father.ballx>=father.screenWidth-father.ballSize){//�����ұ�
				  	father.direction=2;
				  }				   		  
				  break;
				case 2://����
				  father.ballx=father.ballx-father.ballSpan;
				  father.bally=father.bally+father.ballSpan;
				  
				  if(father.bally>=
				          father.screenHeight-father.bannerHeight
				          -father.bottomSpance-father.ballSize){//�����±�
				  	checkCollision(2);
				  }		
				  else if(father.ballx<=0){//�������
					  father.direction=1;
				  }				   			  
				break;								
			}			
			try{Thread.sleep(80);}
			catch(Exception e){e.printStackTrace();}			
		}
	}
	public void checkCollision(int direction){
	  	if(father.ballx>=father.bannerX-father.ballSize&&
	  	   father.ballx<=
	  	      father.bannerX+father.bannerWidth){//������
	  		switch(direction){
	  			case 1:
	  			  father.direction=0;
	  			break;
	  			case 2:
	  			  father.direction=3;
	  			break;
	  		}
	  	}
	  	else{//û��������
	  	    //��Ϸʧ��
	  		father.tt.flag=false;
	  		father.bgt.flag=false;
	  		father.status=2;  		
	  	}		
	}	
}