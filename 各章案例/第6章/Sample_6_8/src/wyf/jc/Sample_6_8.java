package wyf.jc;				//声明包语句
import android.app.Activity;		//引入相关类
import android.app.Dialog;			//引入相关类
import android.app.ProgressDialog;	//引入相关类
import android.os.Bundle;			//引入相关类
import android.os.Handler;			//引入相关类
import android.os.Message;			//引入相关类
import android.view.View;			//引入相关类
import android.view.View.OnClickListener;		//引入相关类
import android.widget.Button;		//引入相关类
public class Sample_6_8 extends Activity {
    final int PROGRESS_DIALOG=0;		//声明进度对话框id
    final int INCREASE=0;				//Handler消息类型
    ProgressDialog pd;
	Handler myHandler;					//Handler对象引用
    @Override
    public void onCreate(Bundle savedInstanceState) {		//重写onCreate方法
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);						//设置屏幕
        Button bok=(Button)this.findViewById(R.id.Button01);	//获得Button对象
        bok.setOnClickListener(									//设置OnClickListener监听器
        	new OnClickListener(){
				@Override
				public void onClick(View v) {					//重写onClick方法
					showDialog(PROGRESS_DIALOG);				//显示进度对话框
				}        		
        	}        
        );    
        myHandler=new Handler(){				//创建Handler对象
        	@Override
        	public void handleMessage(Message msg){
        		switch(msg.what){
        		   case INCREASE:
    				 pd.incrementProgressBy(1);//进度每次加1
       				 if(pd.getProgress()>=100){	//判断是否结束进度
       					 pd.dismiss();	       		//如果进度条走完则关闭窗口				 
       				 }         			  
        		   break;
        		}
        		super.handleMessage(msg);
        	}
        };
    }

    @Override
    public Dialog onCreateDialog(int id){//重写onCreateDialog方法
    	switch(id){			//对id进行判断
    	  case  PROGRESS_DIALOG:		//创建进度对话框	
    		 pd=new ProgressDialog(this);//创建进度对话框	
    		 pd.setMax(100);//设置最大值
             pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);  
             pd.setTitle(R.string.title);//设置标题
             pd.setCancelable(false);//设置进度对话框不能用回退按钮关闭            
          break;
    	}    	
    	return pd;
    }
    @Override
    public void onPrepareDialog(int id, Dialog dialog){//每次弹出对话框时被回调以动态更新对话框内容的方法
    	super.onPrepareDialog(id, dialog);
    	switch(id){
    		case  PROGRESS_DIALOG: 
    			pd.incrementProgressBy(-pd.getProgress());//对话框进度清零
    			new Thread(){								//创建一个线程
    				public void run(){
    					while(true){
    						myHandler.sendEmptyMessage(INCREASE);	//发送Handler消息
    						if(pd.getProgress()>=100){
    							break;
    						}
    						try{
    							Thread.sleep(40);					//线程休眠
    						}
    						catch(Exception e){
    							e.printStackTrace();				//捕获并打印异常
    						} 
    					}    				 
    				}
    			}.start();											//启动线程
    			break;
    	}    	
    }
}