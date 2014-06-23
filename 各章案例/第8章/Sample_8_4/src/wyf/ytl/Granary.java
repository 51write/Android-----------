package wyf.ytl;

import javax.microedition.khronos.opengles.GL10;

public class Granary {//仓库封装类
	Cone cone;//圆锥
	Cylinder cylinder;//圆柱
    public float mAngleX;//沿x轴旋转角度
    public float mAngleY;//沿y轴旋转角度 
    public float mAngleZ;//沿z轴旋转角度 
	public Granary(int x, int y, int z){//构造器
		cone = new Cone(45, 6, x, y+1, z);
		cylinder = new Cylinder(4, 7, x, y, z);
	}

	public void drawSelf(GL10 gl){//自定义的绘制方法
    	gl.glRotatef(mAngleX, 1, 0, 0);//沿X轴旋转
    	gl.glRotatef(mAngleY, 0, 1, 0);//沿Y轴旋转
		gl.glRotatef(mAngleZ, 0, 0, 1);//沿Z轴旋转 
		
		cone.drawSelf(gl);
		cylinder.drawSelf(gl);
	}
}