package wyf.ytl;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class Sample_2_7 extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button bCall=(Button)this.findViewById(R.id.Button01);
        bCall.setOnClickListener(
                //OnClickListener为View的内部接口，其实现者负责监听鼠标点击事件
                new View.OnClickListener(){ 
                 public void onClick(View v){ 
                	 EditText eTel=(EditText)findViewById(R.id.myEditText);                	 
                	 String strTel=eTel.getText().toString();
                	//判断号码字符串是否合法
                	 if(PhoneNumberUtils.isGlobalPhoneNumber(strTel)){//合法则拨号
                		 Intent i=new Intent(Intent.ACTION_DIAL,Uri.parse("tel://"+strTel));
                		 Sample_2_7.this.startActivity(i);
                	 }else{//不合法则提示
                		 Toast.makeText(
                				 Sample_2_7.this, //上下文
                				 "电话号码不符合格式！！！", //提示内容
                				 5000						//信息显示时间
                				 ).show();
                	 }
                 } 
       }); 
    }
}