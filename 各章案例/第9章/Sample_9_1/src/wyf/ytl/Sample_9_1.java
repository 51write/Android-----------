package wyf.ytl;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
public class Sample_9_1 extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button myButton = (Button) this.findViewById(R.id.myButton);
        myButton.setOnClickListener(
        			new OnClickListener(){
						@Override
						public void onClick(View v) {
							System.exit(0);
						}
        			}
        		);
    }
}