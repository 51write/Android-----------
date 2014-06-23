package wyf.ytl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
public class Sample_5_3 extends Activity {
	//������ԴͼƬ��andy��bill��edgar��torvalds��turing��id������
	int[] drawableIds=
		{R.drawable.andy,R.drawable.bill,R.drawable.edgar,R.drawable.torvalds,R.drawable.turing};
	//������Դ�ַ�����andy��bill��edgar��torvalds��turing��id������
	int[] nameIds=
		{R.string.andy,R.string.bill,R.string.edgar,R.string.torvalds,R.string.turing};
	int[] msgIds=
		{R.string.andydis,R.string.billdis,R.string.edgardis,
			R.string.torvaldsdis,R.string.turingdis};
    public List<? extends Map<String, ?>> generateDataList(){
    	ArrayList<Map<String,Object>> list=new ArrayList<Map<String,Object>>();;
    	int rowCounter=drawableIds.length;//�õ���������
    	for(int i=0;i<rowCounter;i++){//ѭ������ÿ�еİ�����Ӧ���������ݵ�Map��col1��col2��col3Ϊ����
    		HashMap<String,Object> hmap=new HashMap<String,Object>();
    		hmap.put("col1", drawableIds[i]);   //��һ��ΪͼƬ 		
    		hmap.put("col2", this.getResources().getString(nameIds[i]));//�ڶ���Ϊ����
    		hmap.put("col3", this.getResources().getString(msgIds[i]));//������Ϊ����
    		list.add(hmap);
    	}    	
    	return list;
	}
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        GridView gv=(GridView)this.findViewById(R.id.GridView01);        
        SimpleAdapter sca=new SimpleAdapter(
        	this,
        	generateDataList(), //����List
        	R.layout.grid_row, //�ж�Ӧlayout id
        	new String[]{"col1","col2","col3"}, //�����б�
        	new int[]{R.id.ImageView01,R.id.TextView02,R.id.TextView03}//�ж�Ӧ�ؼ�id�б�
        );
        gv.setAdapter(sca);//ΪGridView��������������
        gv.setOnItemSelectedListener(//����ѡ��ѡ�еļ�����
           new OnItemSelectedListener(){
        	   public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {//��дѡ�ѡ���¼��Ĵ�����
        		   TextView tv=(TextView)findViewById(R.id.TextView01);//��ȡ������TextView
        		   LinearLayout ll=(LinearLayout)arg1;//��ȡ��ǰѡ��ѡ���Ӧ��LinearLayout
        		   TextView tvn=(TextView)ll.getChildAt(1);//��ȡ���е�TextView 
        		   TextView tvnL=(TextView)ll.getChildAt(2);//��ȡ���е�TextView 
        		   StringBuilder sb=new StringBuilder();
        		   sb.append(tvn.getText());//��ȡ������Ϣ
        		   sb.append(" ");
        		   sb.append(tvnL.getText());//��ȡ������Ϣ				
        		   tv.setText(sb.toString());//��Ϣ���ý�������TextView		
        	   }
        	   public void onNothingSelected(AdapterView<?> arg0){}
           	}
        );  
        gv.setOnItemClickListener( //����ѡ������ļ�����
        	new OnItemClickListener(){
        	   public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {//��дѡ������¼��Ĵ�����
        		   TextView tv=(TextView)findViewById(R.id.TextView01);//��ȡ������TextView
        		   LinearLayout ll=(LinearLayout)arg1;//��ȡ��ǰѡ��ѡ���Ӧ��LinearLayout
        		   TextView tvn=(TextView)ll.getChildAt(1);//��ȡ���е�TextView 
        		   TextView tvnL=(TextView)ll.getChildAt(2);//��ȡ���е�TextView 
        		   StringBuilder sb=new StringBuilder();
        		   sb.append(tvn.getText());//��ȡ������Ϣ
        		   sb.append(" ");
        		   sb.append(tvnL.getText());//��ȡ������Ϣ				
        		   tv.setText(sb.toString());//��Ϣ���ý�������TextView	
        	   }        	   
           	}
        );        
    }
}