package wyf.ytl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

public class Cone {//该类为圆锥类
	private IntBuffer   mVertexBuffer;//顶点坐标数据缓冲
    private IntBuffer   mColorBuffer;//顶点着色数据缓冲
    private ByteBuffer  mIndexBuffer;//顶点构建索引数据缓冲
    
    int angle;//圆锥顶角的角度
    int height;//圆锥的高度
    int vertexX;//顶点的X坐标
    int vertexY;//顶点的Y坐标
    int vertexZ;//顶点的Z坐标
    
    int vertexCount = 0;//顶点的个数
    int indexCount = 0;
    final int angleSpan = 18;//切割单位
    public Cone(int angle, int height, int x, int y, int z){//构造器
    	this.angle = angle;
    	this.height = height;
    	this.vertexX = x;
    	this.vertexY = y;
    	this.vertexZ = z;
    	
    	this.initVertexArray();//初始化顶点数组
    	this.initColorArray();//初始化着色数组
    	this.initIndexArray();//初始化索引数组
    }
    
    public void initVertexArray(){//初始化顶点数组
    	final int UNIT_SIZE=10000;
    	ArrayList<Integer> alVertix=new ArrayList<Integer>();//存放顶点坐标的ArrayList
    	
    	final int angleSpan = 18;
    	for(int vAngle=0;vAngle<=180;vAngle=vAngle+angleSpan){
    		for(int hAngle=0;hAngle<360;hAngle=hAngle+angleSpan){
    			int y = (int)(vAngle*height/180*UNIT_SIZE);
    			int x = (int)((height-vAngle*height/180)*UNIT_SIZE*Math.tan(Math.toRadians(angle))*Math.cos(Math.toRadians(hAngle)));
    			int z = (int)((height-vAngle*height/180)*UNIT_SIZE*Math.tan(Math.toRadians(angle))*Math.sin(Math.toRadians(hAngle)));
    			alVertix.add(x + vertexX*UNIT_SIZE);alVertix.add(y + vertexY*UNIT_SIZE);alVertix.add(z + vertexZ*UNIT_SIZE);
    		}
    	}
    	
    	vertexCount=alVertix.size()/3;//顶点的数量为坐标值数量的1/3，因为一个顶点有3个坐标
        //将alVertix中的坐标值转存到一个int数组中
        int vertices[]=new int[vertexCount*3];
    	for(int i=0;i<alVertix.size();i++){
    		vertices[i]=alVertix.get(i);
    	}
		
        //创建顶点坐标数据缓冲,vertices.length*4是因为一个整数四个字节
        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length*4);
        vbb.order(ByteOrder.nativeOrder());//设置字节顺序
        mVertexBuffer = vbb.asIntBuffer();//转换为int型缓冲
        mVertexBuffer.put(vertices);//向缓冲区中放入顶点坐标数据
        mVertexBuffer.position(0);//设置缓冲区起始位置
    }
    
    public void initColorArray(){//初始化顶点颜色数组
    	final int one = 65535;
        int colors[]=new int[vertexCount*4];//顶点颜色值数组，每个顶点4个色彩值RGBA
        for(int i=0;i<vertexCount;i++){//随机生成每个顶点的颜色
        	colors[i*4]=(int) (one*Math.random());//红色通道
        	colors[i*4+1]=(int) (one*Math.random());//绿色通道
        	colors[i*4+2]=(int) (one*Math.random());//蓝色通道
        	colors[i*4+3]=0;//alpha色彩通道
        }

        //创建顶点着色数据缓冲，vertices.length*4是因为一个int型整数四个字节
        ByteBuffer cbb = ByteBuffer.allocateDirect(colors.length*4);
        cbb.order(ByteOrder.nativeOrder());//设置字节顺序
        mColorBuffer = cbb.asIntBuffer();//转换为int型缓冲
        mColorBuffer.put(colors);//向缓冲区中放入顶点着色数据
        mColorBuffer.position(0);//设置缓冲区起始位置
    }
    
    public void initIndexArray(){//初始化索引数组
    	ArrayList<Integer> alIndex=new ArrayList<Integer>();
        int row=(180/angleSpan)+1;//切分的行数
        int col=360/angleSpan;//切分的列数
        for(int i=0;i<row;i++){//对每一行循环
        	if(i>0&&i<row-1){//中间行
        		for(int j=0;j<col;j++){//中间行的两个相邻点与下一行的对应点构成三角形
					int k=i*col+j;
					alIndex.add(k+col);
					alIndex.add(k+1);
					alIndex.add(k);		
				}
        		for(int j=0;j<col+1;j++){//中间行的两个相邻点与上一行的对应点构成三角形				
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
        //创建三角形构造索引数据缓冲
        mIndexBuffer = ByteBuffer.allocateDirect(indices.length);
        mIndexBuffer.put(indices);//向缓冲区中放入三角形构造索引数据
        mIndexBuffer.position(0);//设置缓冲区起始位置
    }
    
    public void drawSelf(GL10 gl){//自定义的绘制方法    
        gl.glPushMatrix();

		
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
          
		gl.glVertexPointer(//为画笔指定顶点坐标数据
			3,				//每个顶点的坐标数量为3  xyz 
			GL10.GL_FIXED,	//顶点坐标值的类型为 GL_FIXED
			0, 				//连续顶点坐标数据之间的间隔
			mVertexBuffer	//顶点坐标数据
		);
          
		gl.glColorPointer(//为画笔指定顶点着色数据
			4, 				//设置颜色的组成成分，必须为4—RGBA
			GL10.GL_FIXED, 	//顶点颜色值的类型为 GL_FIXED
			0, 				//连续顶点着色数据之间的间隔
			mColorBuffer	//顶点着色数据
		);
          
		gl.glDrawElements(//绘制图形
			GL10.GL_TRIANGLES, 		//以三角形方式填充
			indexCount, 			//一共indexCount/3个三角形，indexCount个顶点
			GL10.GL_UNSIGNED_BYTE, 	//索引值的尺寸
			mIndexBuffer			//索引值数据
		); 
		gl.glPopMatrix();
    }
}
