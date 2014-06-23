package wyf.ytl;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
public class MyGLSurfaceView extends GLSurfaceView{
	MyRenderer myRenderer;//自定义的渲染器
	private IntBuffer   mVertexBuffer;//顶点坐标数据缓冲
    private IntBuffer   mColorBuffer;//顶点着色数据缓冲
    private final float TOUCH_SCALE_FACTOR = 180.0f/320;//角度缩放比例
	private float mPreviousY;//上次的触控位置Y坐标
    private float mPreviousX;//上次的触控位置X坐标
    float yAngle=0;//绕y轴旋转的角度
    float zAngle=0;//绕z轴旋转的角度
    int vertexCount;//顶点的个数
	public MyGLSurfaceView(Context context){//构造器
		super(context);
		myRenderer = new MyRenderer();//创建渲染器
		this.setRenderer(myRenderer);//设置渲染器
		this.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);//设置渲染模式
		this.initVertexBuffer();//初始化顶点坐标数组
		this.initColorBuffer();//初始化颜色数组
	}
    @Override 
    public boolean onTouchEvent(MotionEvent e){//触摸事件的回调方法
    	float x = e.getX();//得到x坐标
        float y = e.getY();//得到y坐标
        switch (e.getAction()) {
        case MotionEvent.ACTION_MOVE://触控笔移动
            float dy = y - mPreviousY;//计算触控笔Y位移
            float dx = x - mPreviousX;//计算触控笔X位移
            yAngle += dx * TOUCH_SCALE_FACTOR;//设置沿y轴旋转角度
            zAngle += dy * TOUCH_SCALE_FACTOR;//设置沿z轴旋转角度
            requestRender();//重绘画面
        }
        mPreviousY = y;//记录触控笔位置
        mPreviousX = x;//记录触控笔位置
        return true;//返回true
    }
	private void initVertexBuffer(){//初始化顶点坐标数据
		vertexCount=15;//顶点的个数
        final int UNIT_SIZE=10000;//创建像素单位
        int vertices[]=new int[]{
        	0,0,0,-8*UNIT_SIZE,-8*UNIT_SIZE,0,
        	-8*UNIT_SIZE,8*UNIT_SIZE,0,
        	0,0,0,-8*UNIT_SIZE,8*UNIT_SIZE,0,
        	0,14*UNIT_SIZE,0,
        	0,0,0,0,14*UNIT_SIZE,0,
        	8*UNIT_SIZE,8*UNIT_SIZE,0,
        	0,0,0,8*UNIT_SIZE,8*UNIT_SIZE,0,
        	8*UNIT_SIZE,-8*UNIT_SIZE,0,
        	0,0,0,8*UNIT_SIZE,-8*UNIT_SIZE,0,
        	-8*UNIT_SIZE,-8*UNIT_SIZE,0
        };
        //创建顶点坐标数据缓冲
        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length*4);
        vbb.order(ByteOrder.nativeOrder());//设置字节顺序
        mVertexBuffer = vbb.asIntBuffer();//转换为int型缓冲
        mVertexBuffer.put(vertices);//向缓冲区中放入顶点坐标数据
        mVertexBuffer.position(0);//设置缓冲区起始位置
	}
	private void initColorBuffer(){//初始化颜色数组
        final int one = 65535;
        int colors[]=new int[]{//顶点颜色值数组，每个顶点4个色彩值RGBA
        		one,one,one,0,0,0,one,0,
        		0,0,one,0,one,one,one,0,
        		0,0,one,0,0,0,one,0,
        		one,one,one,0,0,0,one,0,
        		0,0,one,0,one,one,one,0,
        		0,0,one,0,0,0,one,0,
        		one,one,one,0,0,0,one,0,
        		0,0,one,0,
        };
        //创建顶点着色数据缓冲
        ByteBuffer cbb = ByteBuffer.allocateDirect(colors.length*4);
        cbb.order(ByteOrder.nativeOrder());//设置字节顺序
        mColorBuffer = cbb.asIntBuffer();//转换为int型缓冲
        mColorBuffer.put(colors);//向缓冲区中放入顶点着色数据
        mColorBuffer.position(0);//设置缓冲区起始位置
	}
	//自定义的渲染器
	private class MyRenderer implements GLSurfaceView.Renderer{
		@Override
		public void onDrawFrame(GL10 gl) {//绘制方法
        	//清除颜色缓存于深度缓存
        	gl.glClear(GL10.GL_COLOR_BUFFER_BIT|GL10.GL_DEPTH_BUFFER_BIT);
            gl.glMatrixMode(GL10.GL_MODELVIEW);//设置当前矩阵为模式矩阵
            gl.glLoadIdentity(); //设置当前矩阵为单位矩阵
            gl.glTranslatef(0, 0f, -3f);
            gl.glRotatef(yAngle, 0, 1, 0);//沿Y轴旋转
            gl.glRotatef(zAngle, 0, 0, 1);//沿X轴旋转
            gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);//启用顶点坐标数组
            gl.glEnableClientState(GL10.GL_COLOR_ARRAY);//启用顶点颜色数组
            gl.glVertexPointer(//为画笔指定顶点坐标数据
            		3,//每个顶点的坐标数量为3  xyz 
            		GL10.GL_FIXED,//顶点坐标值的类型为 GL_FIXED
            		0, mVertexBuffer//顶点坐标数据
            );
            gl.glColorPointer(//为画笔指定顶点着色数据
            		4, //设置颜色的组成成分，必须为4—RGBA
            		GL10.GL_FIXED,//顶点颜色值的类型为 GL_FIXED
            		0, mColorBuffer//顶点着色数据
            );
            gl.glDrawArrays(GL10.GL_TRIANGLES, 0, vertexCount); //绘制图形
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