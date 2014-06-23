package wyf.jc;				//���������
import android.app.Activity;		//���������
import android.app.Dialog;			//���������
import android.app.ProgressDialog;	//���������
import android.os.Bundle;			//���������
import android.os.Handler;			//���������
import android.os.Message;			//���������
import android.view.View;			//���������
import android.view.View.OnClickListener;		//���������
import android.widget.Button;		//���������
public class Sample_6_8 extends Activity {
    final int PROGRESS_DIALOG=0;		//�������ȶԻ���id
    final int INCREASE=0;				//Handler��Ϣ����
    ProgressDialog pd;
	Handler myHandler;					//Handler��������
    @Override
    public void onCreate(Bundle savedInstanceState) {		//��дonCreate����
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);						//������Ļ
        Button bok=(Button)this.findViewById(R.id.Button01);	//���Button����
        bok.setOnClickListener(									//����OnClickListener������
        	new OnClickListener(){
				@Override
				public void onClick(View v) {					//��дonClick����
					showDialog(PROGRESS_DIALOG);				//��ʾ���ȶԻ���
				}        		
        	}        
        );    
        myHandler=new Handler(){				//����Handler����
        	@Override
        	public void handleMessage(Message msg){
        		switch(msg.what){
        		   case INCREASE:
    				 pd.incrementProgressBy(1);//����ÿ�μ�1
       				 if(pd.getProgress()>=100){	//�ж��Ƿ��������
       					 pd.dismiss();	       		//���������������رմ���				 
       				 }         			  
        		   break;
        		}
        		super.handleMessage(msg);
        	}
        };
    }

    @Override
    public Dialog onCreateDialog(int id){//��дonCreateDialog����
    	switch(id){			//��id�����ж�
    	  case  PROGRESS_DIALOG:		//�������ȶԻ���	
    		 pd=new ProgressDialog(this);//�������ȶԻ���	
    		 pd.setMax(100);//�������ֵ
             pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);  
             pd.setTitle(R.string.title);//���ñ���
             pd.setCancelable(false);//���ý��ȶԻ������û��˰�ť�ر�            
          break;
    	}    	
    	return pd;
    }
    @Override
    public void onPrepareDialog(int id, Dialog dialog){//ÿ�ε����Ի���ʱ���ص��Զ�̬���¶Ի������ݵķ���
    	super.onPrepareDialog(id, dialog);
    	switch(id){
    		case  PROGRESS_DIALOG: 
    			pd.incrementProgressBy(-pd.getProgress());//�Ի����������
    			new Thread(){								//����һ���߳�
    				public void run(){
    					while(true){
    						myHandler.sendEmptyMessage(INCREASE);	//����Handler��Ϣ
    						if(pd.getProgress()>=100){
    							break;
    						}
    						try{
    							Thread.sleep(40);					//�߳�����
    						}
    						catch(Exception e){
    							e.printStackTrace();				//���񲢴�ӡ�쳣
    						} 
    					}    				 
    				}
    			}.start();											//�����߳�
    			break;
    	}    	
    }
}