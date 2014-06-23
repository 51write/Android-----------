package wyf.jc;			//声明包语句
import android.app.Activity;		//引入相关类
import android.os.Bundle;		//引入相关类
import android.view.Menu;		//引入相关类
import android.view.MenuItem;		//引入相关类
import android.view.SubMenu;		//引入相关类
import android.view.MenuItem.OnMenuItemClickListener;	//引入相关类
import android.widget.EditText;	//引入相关类
public class Sample_6_1 extends Activity {
    final int MENU_GENDER_MALE=0;    //性别为男选项编号
    final int MENU_GENDER_FEMALE=1;	//性别为女选项编号
    final int MENU_HOBBY1=2;		//爱好1选项编号
    final int MENU_HOBBY2=3;		//爱好2选项编号
    final int MENU_HOBBY3=4;		//爱好3选项编号
    final int MENU_OK=5;    		//确定菜单选项编号
    final int MENU_GENDER=6;  		//性别子菜单编号
    final int MENU_HOBBY=7;         //爱好子菜单编号每个菜单项目的编号=======end============
    final int GENDER_GROUP=0;      //性别子菜单项组的编号
    final int HOBBY_GROUP=1;  	   //爱好子菜单项组的编号
    final int MAIN_GROUP=2;        //外层总菜单项组的编号
    
    MenuItem[] miaHobby=new MenuItem[3];//爱好菜单项组
    MenuItem male=null;//男性性别菜单项
    @Override
    public void onCreate(Bundle savedInstanceState) {	//重写onCreate方法
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);        		//设置当前屏幕
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    	//性别单选菜单项组   菜单若编组就是单选菜单项组    	
    	SubMenu subMenuGender = menu.addSubMenu(MAIN_GROUP,MENU_GENDER,0,R.string.gender);
    	subMenuGender.setIcon(R.drawable.gender);
    	subMenuGender.setHeaderIcon(R.drawable.gender);
    	male=subMenuGender.add(GENDER_GROUP, MENU_GENDER_MALE, 0, R.string.male);
    	male.setChecked(true);
    	subMenuGender.add(GENDER_GROUP, MENU_GENDER_FEMALE, 0, R.string.female);
    	//设置GENDER_GROUP组是可选择的，互斥的
    	subMenuGender.setGroupCheckable(GENDER_GROUP, true,true); 
    	            
    	//爱好复选菜单项组
    	SubMenu subMenuHobby = menu.addSubMenu(MAIN_GROUP,MENU_HOBBY,0,R.string.hobby);
    	subMenuHobby.setIcon(R.drawable.hobby); 
    	miaHobby[0]=subMenuHobby.add(HOBBY_GROUP, MENU_HOBBY1, 0, R.string.hobby1);
    	miaHobby[1]=subMenuHobby.add(HOBBY_GROUP, MENU_HOBBY2, 0, R.string.hobby2);
    	miaHobby[2]=subMenuHobby.add(HOBBY_GROUP, MENU_HOBBY3, 0, R.string.hobby3);
    	miaHobby[0].setCheckable(true);//设置菜单项为复选菜单项
    	miaHobby[1].setCheckable(true);
    	miaHobby[2].setCheckable(true);
    	//确定菜单项
    	MenuItem ok=menu.add(GENDER_GROUP+2,MENU_OK,0,R.string.ok);
    	OnMenuItemClickListener lsn=new OnMenuItemClickListener(){//实现菜单项点击事件监听接口
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				appendStateStr();
				return true;
			}    		
    	};
    	ok.setOnMenuItemClickListener(lsn);//给确定菜单项添加监听器    	
    	//给确定菜单项添加快捷键
    	ok.setAlphabeticShortcut('o');//设置字符快捷键
    	//ok.setNumericShortcut('1');//设置数字快捷键
    	//ok.setShortcut('a', '2');//同时设置两种快捷键
    	//要注意，同时设置多次时只有最后一个设置起作用
    	
    	return true;
    }
    @Override  //单选或复选菜单项选中状态变化后的回调方法
    public boolean onOptionsItemSelected(MenuItem mi){
    	switch(mi.getItemId()){
    	   case MENU_GENDER_MALE://单选菜单项状态的切换要自行写代码完成
    	   case MENU_GENDER_FEMALE:
    		    mi.setChecked(true); 
    		    appendStateStr();//当有效项目变化时记录在文本区中
    		    break;   
    	   case MENU_HOBBY1://复选菜单项状态的切换要自行写代码完成
    	   case MENU_HOBBY2:
    	   case MENU_HOBBY3:
    	       mi.setChecked(!mi.isChecked());
    	       appendStateStr();//当有效项目变化时记录在文本区中
    	       break;    	 
    	}    	    	
    	return true;
    }
    //获取当前选择状态的方法
	public void appendStateStr(){
		String result="您选择的性别为：";
		if(male.isChecked()){
    		result=result+"男";
		}
		else{
			result=result+"女";
		}
		String hobbyStr="";
		for(MenuItem mi:miaHobby){
			if(mi.isChecked()){
				hobbyStr=hobbyStr+mi.getTitle()+"、";
			}
		}
		if(hobbyStr.length()>0){
			result=result+",您的爱好为："+hobbyStr.substring(0, hobbyStr.length()-1)+"。\n";
		}
		else{
			result=result+"。\n";
		}
		EditText et=(EditText)Sample_6_1.this.findViewById(R.id.EditText01);               
		et.append(result);
	}
}