package wyf.ytl;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
public class Sample_2_6 extends Activity {
	OnClickListener myOnClickListener;//��������
	ServiceConnection connection;//�õ�ServiceConnection����
	Button startService;//startService��ť
	Button stopService;//stopService��ť
	Button bindService;//bindService��ť
	Button unbindService;//unbindService��ť
    public void onCreate(Bundle savedInstanceState) {//��д��onCreate����
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        connection = new ServiceConnection(){
			public void onServiceConnected(ComponentName arg0, IBinder arg1){}
			public void onServiceDisconnected(ComponentName name){}
        };
        startService = (Button) findViewById(R.id.startService);
        stopService = (Button) findViewById(R.id.stopService);
        bindService = (Button) findViewById(R.id.bindService);
        unbindService = (Button) findViewById(R.id.unbindService);
        myOnClickListener = new OnClickListener(){
			public void onClick(View v) {
				Intent intent = new Intent(Sample_2_6.this,MyService.class);
				if(v == startService){
					startService(intent);
					bindService.setEnabled(false);
					unbindService.setEnabled(false);
				}else if(v == stopService){
					stopService(intent);
					bindService.setEnabled(true);
					unbindService.setEnabled(true);
				}else if(v == bindService){
					bindService(intent, connection, BIND_AUTO_CREATE);
					startService.setEnabled(false);
					stopService.setEnabled(false);
				}else if(v == unbindService){
					unbindService(connection);
					startService.setEnabled(true);
					stopService.setEnabled(true);
				}
			}
        };
        startService.setOnClickListener(myOnClickListener);
        stopService.setOnClickListener(myOnClickListener);
        bindService.setOnClickListener(myOnClickListener);
        unbindService.setOnClickListener(myOnClickListener);
    }
}