package wyf.ytl;
public class MyThread extends Thread{
	Sample_7_9 activity;//activity������
	int what = 1;//������Ϣ��whatֵ
	public MyThread(Sample_7_9 activity){//������
		this.activity = activity;//�õ�activity������
	}
	@Override
	public void run() {//��д��run����
		while(true){//ѭ��
			activity.myHandler.sendEmptyMessage((what++)%4);//������Ϣ
			try{
				Thread.sleep(2000);//˯��
			}
			catch(Exception e){//�����쳣
				e.printStackTrace();//��ӡ�쳣��Ϣ
			}
		}
	}
}
