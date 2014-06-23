package wyf.ytl;

import android.app.Activity;
import android.os.Bundle;

public class Sample_8_4 extends Activity {
	MyGLSurfaceView myGLSurfaceView;//�Զ���GLSurfaceView
    @Override
    public void onCreate(Bundle savedInstanceState) {//Activity����ʱ������
        super.onCreate(savedInstanceState);
        myGLSurfaceView = new MyGLSurfaceView(this);//����һ���Զ����GLSurfaceView
        this.setContentView(myGLSurfaceView);
        myGLSurfaceView.requestFocus();//��ý���
        myGLSurfaceView.setFocusableInTouchMode(true);//���ÿ��Դ��� 
    }
    @Override
    protected void onResume() {
        super.onResume();
        if(myGLSurfaceView != null){
        	myGLSurfaceView.onResume();
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        if(myGLSurfaceView != null){
        	myGLSurfaceView.onPause();
        }
    }
}