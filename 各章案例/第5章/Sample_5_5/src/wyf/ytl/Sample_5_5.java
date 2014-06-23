package wyf.ytl;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.SeekBar;
public class Sample_5_5 extends Activity {
    final static double MAX=100;//SeekBar、ProgressBar的最大值
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //普通拖拉条被拉动的处理代码
        SeekBar sb=(SeekBar)this.findViewById(R.id.SeekBar01);
        sb.setOnSeekBarChangeListener(
            new SeekBar.OnSeekBarChangeListener(){
				public void onProgressChanged(SeekBar seekBar, int progress,
						boolean fromUser) {
					ProgressBar pb=(ProgressBar)findViewById(R.id.ProgressBar01);	
					SeekBar sb=(SeekBar)findViewById(R.id.SeekBar01);
					pb.setProgress(sb.getProgress());
				}
				public void onStartTrackingTouch(SeekBar seekBar) {	}
				public void onStopTrackingTouch(SeekBar seekBar) { }            	
            }
        );
    }
}