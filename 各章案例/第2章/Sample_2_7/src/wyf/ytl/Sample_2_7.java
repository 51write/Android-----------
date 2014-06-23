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
                //OnClickListenerΪView���ڲ��ӿڣ���ʵ���߸������������¼�
                new View.OnClickListener(){ 
                 public void onClick(View v){ 
                	 EditText eTel=(EditText)findViewById(R.id.myEditText);                	 
                	 String strTel=eTel.getText().toString();
                	//�жϺ����ַ����Ƿ�Ϸ�
                	 if(PhoneNumberUtils.isGlobalPhoneNumber(strTel)){//�Ϸ��򲦺�
                		 Intent i=new Intent(Intent.ACTION_DIAL,Uri.parse("tel://"+strTel));
                		 Sample_2_7.this.startActivity(i);
                	 }else{//���Ϸ�����ʾ
                		 Toast.makeText(
                				 Sample_2_7.this, //������
                				 "�绰���벻���ϸ�ʽ������", //��ʾ����
                				 5000						//��Ϣ��ʾʱ��
                				 ).show();
                	 }
                 } 
       }); 
    }
}