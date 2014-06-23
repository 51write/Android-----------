package wyf.ytl;

import javax.microedition.khronos.opengles.GL10;

public class Granary {//�ֿ��װ��
	Cone cone;//Բ׶
	Cylinder cylinder;//Բ��
    public float mAngleX;//��x����ת�Ƕ�
    public float mAngleY;//��y����ת�Ƕ� 
    public float mAngleZ;//��z����ת�Ƕ� 
	public Granary(int x, int y, int z){//������
		cone = new Cone(45, 6, x, y+1, z);
		cylinder = new Cylinder(4, 7, x, y, z);
	}

	public void drawSelf(GL10 gl){//�Զ���Ļ��Ʒ���
    	gl.glRotatef(mAngleX, 1, 0, 0);//��X����ת
    	gl.glRotatef(mAngleY, 0, 1, 0);//��Y����ת
		gl.glRotatef(mAngleZ, 0, 0, 1);//��Z����ת 
		
		cone.drawSelf(gl);
		cylinder.drawSelf(gl);
	}
}