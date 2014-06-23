package wyf.ytl;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

public class MyGLSurfaceView extends GLSurfaceView{
	MySceneRenderer mRenderer;//场景渲染器
    private final float TOUCH_SCALE_FACTOR = 180.0f/320;//角度缩放比例
    private float mPreviousY;//上次的触控位置Y坐标
    private float mPreviousX;//上次的触控位置Y坐标
	public MyGLSurfaceView(Context context) {//构造器
		super(context);
        mRenderer = new MySceneRenderer();//创建场景渲染器
        this.setRenderer(mRenderer);//设置渲染器		
        this.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);//设置渲染模式为主动渲染   
	}
    @Override 
    public boolean onTouchEvent(MotionEvent e){//触摸事件的回调方法
        float y = e.getY();
        float x = e.getX();
        switch (e.getAction()) {
        case MotionEvent.ACTION_MOVE://触控笔移动时
            float dy = y - mPreviousY;//计算触控笔Y位移
            float dx = x - mPreviousX;//计算触控笔Y位移
            mRenderer.granary.mAngleZ += dy * TOUCH_SCALE_FACTOR;//设置沿Z轴旋转
            mRenderer.granary.mAngleY += dx * TOUCH_SCALE_FACTOR;//设置沿Y轴旋转
            requestRender();//重新绘制
        }
        mPreviousY = y;//记录触控笔的Y坐标
        mPreviousX = x;//记录触控笔的X坐标
        return true;
    }
	private class MySceneRenderer implements  GLSurfaceView.Renderer{//自定义的渲染器 
		Granary granary = new Granary(0, 0, 0);
		@Override
		public void onDrawFrame(GL10 gl) {//绘制方法
			//gl.glShadeModel(GL10.GL_FLAT);//不平滑着色
			gl.glShadeModel(GL10.GL_SMOOTH);//平滑着色
        	gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);//清除颜色缓存
            gl.glMatrixMode(GL10.GL_MODELVIEW);//设置当前矩阵为模式矩阵
            gl.glLoadIdentity();//设置当前矩阵为单位矩阵              
            gl.glTranslatef(0f, 0f, -2.2f);
            granary.drawSelf(gl);
		}
		@Override
        public void onSurfaceChanged(GL10 gl, int width, int height) {
        	gl.glViewport(0, 0, width, height);//设置视窗大小及位置 
            gl.glMatrixMode(GL10.GL_PROJECTION);//设置当前矩阵为投影矩阵
            gl.glLoadIdentity();//设置当前矩阵为单位矩阵
            float ratio = (float)width/height;//计算透视投影的比例
            gl.glFrustumf(-ratio, ratio, -1, 1, 1, 10);//调用此方法计算产生透视投影矩阵
        }
		@Override
        public void onSurfaceCreated(GL10 gl, EGLConfig config) {//创建时被调用
        	gl.glDisable(GL10.GL_DITHER);//关闭抗抖动           
            gl.glEnable(GL10.GL_DEPTH_TEST);//启用深度测试
        }
	}
}
