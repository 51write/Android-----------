package wyf.ytl;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
public class MyReceiver extends BroadcastReceiver{//�̳���BroadcastReceiver
	@Override
	public void onReceive(Context context, Intent intent) {//��д��onReceive����
		Intent i = new Intent(context, Sample_9_1.class);//����Intent����
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//����Intent��Flag
		context.startActivity(i);//����Activity
	}
}
