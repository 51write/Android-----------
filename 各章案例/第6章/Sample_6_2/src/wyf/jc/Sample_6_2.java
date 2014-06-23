package wyf.jc;					//声明包语句
import android.app.Activity;		//引入相关类
import android.os.Bundle;			//引入相关类
import android.view.ContextMenu;	//引入相关类
import android.view.MenuItem;		//引入相关类
import android.view.View;			//引入相关类
import android.widget.EditText;		//引入相关类
public class Sample_6_2 extends Activity {
    final int MENU1=1;//每个菜单项目的编号=======begin=========
    final int MENU2=2;
    final int MENU3=3;
    final int MENU4=4;
    final int MENU5=5;//每个菜单项目的编号=======end============
    @Override
    public void onCreate(Bundle savedInstanceState) {		//重写onCreate方法
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //为两个文本框注册上下文菜单
        this.registerForContextMenu(findViewById(R.id.EditText01));
        this.registerForContextMenu(findViewById(R.id.EditText02));
    }
    @Override
    public void onCreateContextMenu (ContextMenu menu, View v,
    			ContextMenu.ContextMenuInfo menuInfo){//此方法在每次调出上下文菜单时都会被调用一次
    	menu.setHeaderIcon(R.drawable.header);
    	if(v==findViewById(R.id.EditText01)){//若是第一个文本框
    		menu.add(0, MENU1, 0, R.string.mi1);
    		menu.add(0, MENU2, 0, R.string.mi2);
    		menu.add(0, MENU3, 0, R.string.mi3); 
    	}
    	else if(v==findViewById(R.id.EditText02)){//若是第二个文本框
    		menu.add(0, MENU4, 0, R.string.mi4);
    		menu.add(0, MENU5, 0, R.string.mi5);
    	}
    }
    @Override  //菜单项选中状态变化后的回调方法
    public boolean onContextItemSelected(MenuItem mi){	
		switch(mi.getItemId()){
		  case MENU1:
		  case MENU2:
		  case MENU3:
			  EditText et1=(EditText)this.findViewById(R.id.EditText01);               
			  et1.append("\n"+mi.getTitle()+" 被按下");  
		  break;
		  case MENU4:
		  case MENU5:
			  EditText et2=(EditText)this.findViewById(R.id.EditText02);               
			  et2.append("\n"+mi.getTitle()+" 被按下");  
		  break;
		}    	
    	return true;
    }
}