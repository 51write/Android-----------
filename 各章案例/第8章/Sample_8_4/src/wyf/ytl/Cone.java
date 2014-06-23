package wyf.ytl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

public class Cone {//����ΪԲ׶��
	private IntBuffer   mVertexBuffer;//�����������ݻ���
    private IntBuffer   mColorBuffer;//������ɫ���ݻ���
    private ByteBuffer  mIndexBuffer;//���㹹���������ݻ���
    
    int angle;//Բ׶���ǵĽǶ�
    int height;//Բ׶�ĸ߶�
    int vertexX;//�����X����
    int vertexY;//�����Y����
    int vertexZ;//�����Z����
    
    int vertexCount = 0;//����ĸ���
    int indexCount = 0;
    final int angleSpan = 18;//�иλ
    public Cone(int angle, int height, int x, int y, int z){//������
    	this.angle = angle;
    	this.height = height;
    	this.vertexX = x;
    	this.vertexY = y;
    	this.vertexZ = z;
    	
    	this.initVertexArray();//��ʼ����������
    	this.initColorArray();//��ʼ����ɫ����
    	this.initIndexArray();//��ʼ����������
    }
    
    public void initVertexArray(){//��ʼ����������
    	final int UNIT_SIZE=10000;
    	ArrayList<Integer> alVertix=new ArrayList<Integer>();//��Ŷ��������ArrayList
    	
    	final int angleSpan = 18;
    	for(int vAngle=0;vAngle<=180;vAngle=vAngle+angleSpan){
    		for(int hAngle=0;hAngle<360;hAngle=hAngle+angleSpan){
    			int y = (int)(vAngle*height/180*UNIT_SIZE);
    			int x = (int)((height-vAngle*height/180)*UNIT_SIZE*Math.tan(Math.toRadians(angle))*Math.cos(Math.toRadians(hAngle)));
    			int z = (int)((height-vAngle*height/180)*UNIT_SIZE*Math.tan(Math.toRadians(angle))*Math.sin(Math.toRadians(hAngle)));
    			alVertix.add(x + vertexX*UNIT_SIZE);alVertix.add(y + vertexY*UNIT_SIZE);alVertix.add(z + vertexZ*UNIT_SIZE);
    		}
    	}
    	
    	vertexCount=alVertix.size()/3;//���������Ϊ����ֵ������1/3����Ϊһ��������3������
        //��alVertix�е�����ֵת�浽һ��int������
        int vertices[]=new int[vertexCount*3];
    	for(int i=0;i<alVertix.size();i++){
    		vertices[i]=alVertix.get(i);
    	}
		
        //���������������ݻ���,vertices.length*4����Ϊһ�������ĸ��ֽ�
        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length*4);
        vbb.order(ByteOrder.nativeOrder());//�����ֽ�˳��
        mVertexBuffer = vbb.asIntBuffer();//ת��Ϊint�ͻ���
        mVertexBuffer.put(vertices);//�򻺳����з��붥����������
        mVertexBuffer.position(0);//���û�������ʼλ��
    }
    
    public void initColorArray(){//��ʼ��������ɫ����
    	final int one = 65535;
        int colors[]=new int[vertexCount*4];//������ɫֵ���飬ÿ������4��ɫ��ֵRGBA
        for(int i=0;i<vertexCount;i++){//�������ÿ���������ɫ
        	colors[i*4]=(int) (one*Math.random());//��ɫͨ��
        	colors[i*4+1]=(int) (one*Math.random());//��ɫͨ��
        	colors[i*4+2]=(int) (one*Math.random());//��ɫͨ��
        	colors[i*4+3]=0;//alphaɫ��ͨ��
        }

        //����������ɫ���ݻ��壬vertices.length*4����Ϊһ��int�������ĸ��ֽ�
        ByteBuffer cbb = ByteBuffer.allocateDirect(colors.length*4);
        cbb.order(ByteOrder.nativeOrder());//�����ֽ�˳��
        mColorBuffer = cbb.asIntBuffer();//ת��Ϊint�ͻ���
        mColorBuffer.put(colors);//�򻺳����з��붥����ɫ����
        mColorBuffer.position(0);//���û�������ʼλ��
    }
    
    public void initIndexArray(){//��ʼ����������
    	ArrayList<Integer> alIndex=new ArrayList<Integer>();
        int row=(180/angleSpan)+1;//�зֵ�����
        int col=360/angleSpan;//�зֵ�����
        for(int i=0;i<row;i++){//��ÿһ��ѭ��
        	if(i>0&&i<row-1){//�м���
        		for(int j=0;j<col;j++){//�м��е��������ڵ�����һ�еĶ�Ӧ�㹹��������
					int k=i*col+j;
					alIndex.add(k+col);
					alIndex.add(k+1);
					alIndex.add(k);		
				}
        		for(int j=0;j<col+1;j++){//�м��е��������ڵ�����һ�еĶ�Ӧ�㹹��������				
					int k=i*col+j;
					alIndex.add(k-col);
					alIndex.add(k-1);
					alIndex.add(k);	
				}
        	}
        	if(i==(row-1)){
        		for(int j=0;j<col+1;j++){				
					int k=i*col+j;
					alIndex.add(k-col);
					alIndex.add(k-1);
					alIndex.add(k);	
				}
        	}
        }
        indexCount = alIndex.size();
        byte indices[]=new byte[alIndex.size()];
        for(int i=0;i<alIndex.size();i++){
        	indices[i] = alIndex.get(i).byteValue();
        } 
        //���������ι����������ݻ���
        mIndexBuffer = ByteBuffer.allocateDirect(indices.length);
        mIndexBuffer.put(indices);//�򻺳����з��������ι�����������
        mIndexBuffer.position(0);//���û�������ʼλ��
    }
    
    public void drawSelf(GL10 gl){//�Զ���Ļ��Ʒ���    
        gl.glPushMatrix();

		
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
          
		gl.glVertexPointer(//Ϊ����ָ��������������
			3,				//ÿ���������������Ϊ3  xyz 
			GL10.GL_FIXED,	//��������ֵ������Ϊ GL_FIXED
			0, 				//����������������֮��ļ��
			mVertexBuffer	//������������
		);
          
		gl.glColorPointer(//Ϊ����ָ��������ɫ����
			4, 				//������ɫ����ɳɷ֣�����Ϊ4��RGBA
			GL10.GL_FIXED, 	//������ɫֵ������Ϊ GL_FIXED
			0, 				//����������ɫ����֮��ļ��
			mColorBuffer	//������ɫ����
		);
          
		gl.glDrawElements(//����ͼ��
			GL10.GL_TRIANGLES, 		//�������η�ʽ���
			indexCount, 			//һ��indexCount/3�������Σ�indexCount������
			GL10.GL_UNSIGNED_BYTE, 	//����ֵ�ĳߴ�
			mIndexBuffer			//����ֵ����
		); 
		gl.glPopMatrix();
    }
}
