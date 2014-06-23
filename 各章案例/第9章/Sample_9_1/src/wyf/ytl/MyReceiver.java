package wyf.ytl;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
public class MyReceiver extends BroadcastReceiver{//继承自BroadcastReceiver
	@Override
	public void onReceive(Context context, Intent intent) {//重写的onReceive方法
		Intent i = new Intent(context, Sample_9_1.class);//创建Intent对象
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//设置Intent的Flag
		context.startActivity(i);//启动Activity
	}
}
