package Code;

import java.io.*;
import java.util.Random;

public class Test {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int smbl = 1;
		String zhanghao;
		String mima;
		
		//���ļ���ȡ�˺�������Ϣ
		File f = new File("c:\\test\\consumer.txt");		
		FileInputStream fis = new FileInputStream(f);
		InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
		BufferedReader br = new BufferedReader(isr);
		zhanghao = br.readLine();
		mima = br.readLine();
		br.close();
		
		//����ȡ�����˺�������Ϣ���û��������Ϣ����ƥ��
		DealingWithCode cus1 = new DealingWithCode();
		cus1.accountNumber = zhanghao;
		cus1.code = mima;
		cus1.In();
		while(smbl != cus1.accountNumberContrast()){}
		cus1.generatePassword();//�漴�������ɲ�Ҫ�����룬�������������������������
		//�漴����ƥ�䣬������ǰ�漴�����ƥ���ͬ��һ�εĿ����ƥ��
	}
}
