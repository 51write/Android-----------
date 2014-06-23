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
	//所有资源图片（andy、bill、edgar、torvalds、turing）id的数组
	int[] drawableIds=
		{R.drawable.andy,R.drawable.bill,R.drawable.edgar,R.drawable.torvalds,R.drawable.turing};
	//所有资源字符串（andy、bill、edgar、torvalds、turing）id的数组
	int[] nameIds=
		{R.string.andy,R.string.bill,R.string.edgar,R.string.torvalds,R.string.turing};
	int[] msgIds=
		{R.string.andydis,R.string.billdis,R.string.edgardis,
			R.string.torvaldsdis,R.string.turingdis};
    public List<? extends Map<String, ?>> generateDataList(){
    	ArrayList<Map<String,Object>> list=new ArrayList<Map<String,Object>>();;
    	int rowCounter=drawableIds.length;//得到表格的行数
    	for(int i=0;i<rowCounter;i++){//循环生成每行的包含对应各个列数据的Map；col1、col2、col3为列名
    		HashMap<String,Object> hmap=new HashMap<String,Object>();
    		hmap.put("col1", drawableIds[i]);   //第一列为图片 		
    		hmap.put("col2", this.getResources().getString(nameIds[i]));//第二例为姓名
    		hmap.put("col3", this.getResources().getString(msgIds[i]));//第三列为描述
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
        	generateDataList(), //数据List
        	R.layout.grid_row, //行对应layout id
        	new String[]{"col1","col2","col3"}, //列名列表
        	new int[]{R.id.ImageView01,R.id.TextView02,R.id.TextView03}//列对应控件id列表
        );
        gv.setAdapter(sca);//为GridView设置数据适配器
        gv.setOnItemSelectedListener(//设置选项选中的监听器
           new OnItemSelectedListener(){
        	   public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {//重写选项被选中事件的处理方法
        		   TextView tv=(TextView)findViewById(R.id.TextView01);//获取主界面TextView
        		   LinearLayout ll=(LinearLayout)arg1;//获取当前选中选项对应的LinearLayout
        		   TextView tvn=(TextView)ll.getChildAt(1);//获取其中的TextView 
        		   TextView tvnL=(TextView)ll.getChildAt(2);//获取其中的TextView 
        		   StringBuilder sb=new StringBuilder();
        		   sb.append(tvn.getText());//获取姓名信息
        		   sb.append(" ");
        		   sb.append(tvnL.getText());//获取描述信息				
        		   tv.setText(sb.toString());//信息设置进主界面TextView		
        	   }
        	   public void onNothingSelected(AdapterView<?> arg0){}
           	}
        );  
        gv.setOnItemClickListener( //设置选项被单击的监听器
        	new OnItemClickListener(){
        	   public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {//重写选项被单击事件的处理方法
        		   TextView tv=(TextView)findViewById(R.id.TextView01);//获取主界面TextView
        		   LinearLayout ll=(LinearLayout)arg1;//获取当前选中选项对应的LinearLayout
        		   TextView tvn=(TextView)ll.getChildAt(1);//获取其中的TextView 
        		   TextView tvnL=(TextView)ll.getChildAt(2);//获取其中的TextView 
        		   StringBuilder sb=new StringBuilder();
        		   sb.append(tvn.getText());//获取姓名信息
        		   sb.append(" ");
        		   sb.append(tvnL.getText());//获取描述信息				
        		   tv.setText(sb.toString());//信息设置进主界面TextView	
        	   }        	   
           	}
        );        
    }
}