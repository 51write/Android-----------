package wyf.jc;			//���������
import android.app.Activity;		//���������
import android.os.Bundle;		//���������
import android.view.Menu;		//���������
import android.view.MenuItem;		//���������
import android.view.SubMenu;		//���������
import android.view.MenuItem.OnMenuItemClickListener;	//���������
import android.widget.EditText;	//���������
public class Sample_6_1 extends Activity {
    final int MENU_GENDER_MALE=0;    //�Ա�Ϊ��ѡ����
    final int MENU_GENDER_FEMALE=1;	//�Ա�ΪŮѡ����
    final int MENU_HOBBY1=2;		//����1ѡ����
    final int MENU_HOBBY2=3;		//����2ѡ����
    final int MENU_HOBBY3=4;		//����3ѡ����
    final int MENU_OK=5;    		//ȷ���˵�ѡ����
    final int MENU_GENDER=6;  		//�Ա��Ӳ˵����
    final int MENU_HOBBY=7;         //�����Ӳ˵����ÿ���˵���Ŀ�ı��=======end============
    final int GENDER_GROUP=0;      //�Ա��Ӳ˵�����ı��
    final int HOBBY_GROUP=1;  	   //�����Ӳ˵�����ı��
    final int MAIN_GROUP=2;        //����ܲ˵�����ı��
    
    MenuItem[] miaHobby=new MenuItem[3];//���ò˵�����
    MenuItem male=null;//�����Ա�˵���
    @Override
    public void onCreate(Bundle savedInstanceState) {	//��дonCreate����
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);        		//���õ�ǰ��Ļ
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    	//�Ա�ѡ�˵�����   �˵���������ǵ�ѡ�˵�����    	
    	SubMenu subMenuGender = menu.addSubMenu(MAIN_GROUP,MENU_GENDER,0,R.string.gender);
    	subMenuGender.setIcon(R.drawable.gender);
    	subMenuGender.setHeaderIcon(R.drawable.gender);
    	male=subMenuGender.add(GENDER_GROUP, MENU_GENDER_MALE, 0, R.string.male);
    	male.setChecked(true);
    	subMenuGender.add(GENDER_GROUP, MENU_GENDER_FEMALE, 0, R.string.female);
    	//����GENDER_GROUP���ǿ�ѡ��ģ������
    	subMenuGender.setGroupCheckable(GENDER_GROUP, true,true); 
    	            
    	//���ø�ѡ�˵�����
    	SubMenu subMenuHobby = menu.addSubMenu(MAIN_GROUP,MENU_HOBBY,0,R.string.hobby);
    	subMenuHobby.setIcon(R.drawable.hobby); 
    	miaHobby[0]=subMenuHobby.add(HOBBY_GROUP, MENU_HOBBY1, 0, R.string.hobby1);
    	miaHobby[1]=subMenuHobby.add(HOBBY_GROUP, MENU_HOBBY2, 0, R.string.hobby2);
    	miaHobby[2]=subMenuHobby.add(HOBBY_GROUP, MENU_HOBBY3, 0, R.string.hobby3);
    	miaHobby[0].setCheckable(true);//���ò˵���Ϊ��ѡ�˵���
    	miaHobby[1].setCheckable(true);
    	miaHobby[2].setCheckable(true);
    	//ȷ���˵���
    	MenuItem ok=menu.add(GENDER_GROUP+2,MENU_OK,0,R.string.ok);
    	OnMenuItemClickListener lsn=new OnMenuItemClickListener(){//ʵ�ֲ˵������¼������ӿ�
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				appendStateStr();
				return true;
			}    		
    	};
    	ok.setOnMenuItemClickListener(lsn);//��ȷ���˵�����Ӽ�����    	
    	//��ȷ���˵�����ӿ�ݼ�
    	ok.setAlphabeticShortcut('o');//�����ַ���ݼ�
    	//ok.setNumericShortcut('1');//�������ֿ�ݼ�
    	//ok.setShortcut('a', '2');//ͬʱ�������ֿ�ݼ�
    	//Ҫע�⣬ͬʱ���ö��ʱֻ�����һ������������
    	
    	return true;
    }
    @Override  //��ѡ��ѡ�˵���ѡ��״̬�仯��Ļص�����
    public boolean onOptionsItemSelected(MenuItem mi){
    	switch(mi.getItemId()){
    	   case MENU_GENDER_MALE://��ѡ�˵���״̬���л�Ҫ����д�������
    	   case MENU_GENDER_FEMALE:
    		    mi.setChecked(true); 
    		    appendStateStr();//����Ч��Ŀ�仯ʱ��¼���ı�����
    		    break;   
    	   case MENU_HOBBY1://��ѡ�˵���״̬���л�Ҫ����д�������
    	   case MENU_HOBBY2:
    	   case MENU_HOBBY3:
    	       mi.setChecked(!mi.isChecked());
    	       appendStateStr();//����Ч��Ŀ�仯ʱ��¼���ı�����
    	       break;    	 
    	}    	    	
    	return true;
    }
    //��ȡ��ǰѡ��״̬�ķ���
	public void appendStateStr(){
		String result="��ѡ����Ա�Ϊ��";
		if(male.isChecked()){
    		result=result+"��";
		}
		else{
			result=result+"Ů";
		}
		String hobbyStr="";
		for(MenuItem mi:miaHobby){
			if(mi.isChecked()){
				hobbyStr=hobbyStr+mi.getTitle()+"��";
			}
		}
		if(hobbyStr.length()>0){
			result=result+",���İ���Ϊ��"+hobbyStr.substring(0, hobbyStr.length()-1)+"��\n";
		}
		else{
			result=result+"��\n";
		}
		EditText et=(EditText)Sample_6_1.this.findViewById(R.id.EditText01);               
		et.append(result);
	}
}