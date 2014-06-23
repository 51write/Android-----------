package wyf.ytl;

import android.app.Activity;
import android.os.Bundle;

public class Sample_8_3 extends Activity {
	MyGLSurfaceView myGLSurfaceView;//自定义GLSurfaceView
    @Override
    public void onCreate(Bundle savedInstanceState) {//Activity创建时被调用
        super.onCreate(savedInstanceState);
        myGLSurfaceView = new MyGLSurfaceView(this);//创建一个自定义的GLSurfaceView
        this.setContentView(myGLSurfaceView);//设置当前的用户界面
        myGLSurfaceView.requestFocus();//获得焦点
        myGLSurfaceView.setFocusableInTouchMode(true);//设置可以触控
    }
    @Override
    protected void onResume(){
        super.onResume();
        if(myGLSurfaceView != null){//当myGLSurfaceView不为空时
        	myGLSurfaceView.onResume();
        }
    }
    @Override
    protected void onPause(){
        super.onPause();
        if(myGLSurfaceView != null){//当myGLSurfaceView不为空时
        	myGLSurfaceView.onPause();
        }
    }
}