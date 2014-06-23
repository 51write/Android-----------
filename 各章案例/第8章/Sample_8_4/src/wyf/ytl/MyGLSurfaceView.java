package wyf.ytl;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

public class MyGLSurfaceView extends GLSurfaceView{
	MySceneRenderer mRenderer;//������Ⱦ��
    private final float TOUCH_SCALE_FACTOR = 180.0f/320;//�Ƕ����ű���
    private float mPreviousY;//�ϴεĴ���λ��Y����
    private float mPreviousX;//�ϴεĴ���λ��Y����
	public MyGLSurfaceView(Context context) {//������
		super(context);
        mRenderer = new MySceneRenderer();//����������Ⱦ��
        this.setRenderer(mRenderer);//������Ⱦ��		
        this.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);//������ȾģʽΪ������Ⱦ   
	}
    @Override 
    public boolean onTouchEvent(MotionEvent e){//�����¼��Ļص�����
        float y = e.getY();
        float x = e.getX();
        switch (e.getAction()) {
        case MotionEvent.ACTION_MOVE://���ر��ƶ�ʱ
            float dy = y - mPreviousY;//���㴥�ر�Yλ��
            float dx = x - mPreviousX;//���㴥�ر�Yλ��
            mRenderer.granary.mAngleZ += dy * TOUCH_SCALE_FACTOR;//������Z����ת
            mRenderer.granary.mAngleY += dx * TOUCH_SCALE_FACTOR;//������Y����ת
            requestRender();//���»���
        }
        mPreviousY = y;//��¼���رʵ�Y����
        mPreviousX = x;//��¼���رʵ�X����
        return true;
    }
	private class MySceneRenderer implements  GLSurfaceView.Renderer{//�Զ������Ⱦ�� 
		Granary granary = new Granary(0, 0, 0);
		@Override
		public void onDrawFrame(GL10 gl) {//���Ʒ���
			//gl.glShadeModel(GL10.GL_FLAT);//��ƽ����ɫ
			gl.glShadeModel(GL10.GL_SMOOTH);//ƽ����ɫ
        	gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);//�����ɫ����
            gl.glMatrixMode(GL10.GL_MODELVIEW);//���õ�ǰ����Ϊģʽ����
            gl.glLoadIdentity();//���õ�ǰ����Ϊ��λ����              
            gl.glTranslatef(0f, 0f, -2.2f);
            granary.drawSelf(gl);
		}
		@Override
        public void onSurfaceChanged(GL10 gl, int width, int height) {
        	gl.glViewport(0, 0, width, height);//�����Ӵ���С��λ�� 
            gl.glMatrixMode(GL10.GL_PROJECTION);//���õ�ǰ����ΪͶӰ����
            gl.glLoadIdentity();//���õ�ǰ����Ϊ��λ����
            float ratio = (float)width/height;//����͸��ͶӰ�ı���
            gl.glFrustumf(-ratio, ratio, -1, 1, 1, 10);//���ô˷����������͸��ͶӰ����
        }
		@Override
        public void onSurfaceCreated(GL10 gl, EGLConfig config) {//����ʱ������
        	gl.glDisable(GL10.GL_DITHER);//�رտ�����           
            gl.glEnable(GL10.GL_DEPTH_TEST);//������Ȳ���
        }
	}
}
