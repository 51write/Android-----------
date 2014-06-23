package wyf.jc;					//���������
import android.app.Activity;		//���������
import android.os.Bundle;			//���������
import android.view.ContextMenu;	//���������
import android.view.MenuItem;		//���������
import android.view.View;			//���������
import android.widget.EditText;		//���������
public class Sample_6_2 extends Activity {
    final int MENU1=1;//ÿ���˵���Ŀ�ı��=======begin=========
    final int MENU2=2;
    final int MENU3=3;
    final int MENU4=4;
    final int MENU5=5;//ÿ���˵���Ŀ�ı��=======end============
    @Override
    public void onCreate(Bundle savedInstanceState) {		//��дonCreate����
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //Ϊ�����ı���ע�������Ĳ˵�
        this.registerForContextMenu(findViewById(R.id.EditText01));
        this.registerForContextMenu(findViewById(R.id.EditText02));
    }
    @Override
    public void onCreateContextMenu (ContextMenu menu, View v,
    			ContextMenu.ContextMenuInfo menuInfo){//�˷�����ÿ�ε��������Ĳ˵�ʱ���ᱻ����һ��
    	menu.setHeaderIcon(R.drawable.header);
    	if(v==findViewById(R.id.EditText01)){//���ǵ�һ���ı���
    		menu.add(0, MENU1, 0, R.string.mi1);
    		menu.add(0, MENU2, 0, R.string.mi2);
    		menu.add(0, MENU3, 0, R.string.mi3); 
    	}
    	else if(v==findViewById(R.id.EditText02)){//���ǵڶ����ı���
    		menu.add(0, MENU4, 0, R.string.mi4);
    		menu.add(0, MENU5, 0, R.string.mi5);
    	}
    }
    @Override  //�˵���ѡ��״̬�仯��Ļص�����
    public boolean onContextItemSelected(MenuItem mi){	
		switch(mi.getItemId()){
		  case MENU1:
		  case MENU2:
		  case MENU3:
			  EditText et1=(EditText)this.findViewById(R.id.EditText01);               
			  et1.append("\n"+mi.getTitle()+" ������");  
		  break;
		  case MENU4:
		  case MENU5:
			  EditText et2=(EditText)this.findViewById(R.id.EditText02);               
			  et2.append("\n"+mi.getTitle()+" ������");  
		  break;
		}    	
    	return true;
    }
}