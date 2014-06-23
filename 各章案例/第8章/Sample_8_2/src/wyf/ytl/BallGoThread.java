package wyf.ytl;							//声明包语句
public class BallGoThread extends Thread{
	GameView father;
	boolean flag=true;	
	public BallGoThread(GameView father){
		this.father=father;
	}	
	public void run(){
		while(flag){
			switch(father.direction){
				case 0://右上
				  father.ballx=father.ballx+father.ballSpan;
				  father.bally=father.bally-father.ballSpan;
				  
				  if(father.ballx>=father.screenWidth-father.ballSize){//碰到右壁
				  	father.direction=3;
				  }
				  else if(father.bally<=0){//碰到上壁
				  	father.direction=1;
				  }
				  break;
				case 3://左上
				  father.ballx=father.ballx-father.ballSpan;
				  father.bally=father.bally-father.ballSpan;
				  if(father.ballx<=0){//碰到左壁
				  	father.direction=0;
				  }
				  else if(father.bally<=0){//碰到上壁
				  	father.direction=2;
				  }						  
				  break;					
				case 1://右下
				  father.ballx=father.ballx+father.ballSpan;
				  father.bally=father.bally+father.ballSpan;
				  
				  if(father.bally>=
				          father.screenHeight-father.bannerHeight
				          -father.bottomSpance-father.ballSize){//碰到下壁
				  	 checkCollision(1);
				  }		
				  else if(father.ballx>=father.screenWidth-father.ballSize){//碰到右壁
				  	father.direction=2;
				  }				   		  
				  break;
				case 2://左下
				  father.ballx=father.ballx-father.ballSpan;
				  father.bally=father.bally+father.ballSpan;
				  
				  if(father.bally>=
				          father.screenHeight-father.bannerHeight
				          -father.bottomSpance-father.ballSize){//碰到下壁
				  	checkCollision(2);
				  }		
				  else if(father.ballx<=0){//碰到左壁
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
	  	      father.bannerX+father.bannerWidth){//碰到板
	  		switch(direction){
	  			case 1:
	  			  father.direction=0;
	  			break;
	  			case 2:
	  			  father.direction=3;
	  			break;
	  		}
	  	}
	  	else{//没有碰到板
	  	    //游戏失败
	  		father.tt.flag=false;
	  		father.bgt.flag=false;
	  		father.status=2;  		
	  	}		
	}	
}