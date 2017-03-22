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
		
		//从文件读取账号密码信息
		File f = new File("c:\\test\\consumer.txt");		
		FileInputStream fis = new FileInputStream(f);
		InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
		BufferedReader br = new BufferedReader(isr);
		zhanghao = br.readLine();
		mima = br.readLine();
		br.close();
		
		//将读取到的账号密码信息和用户输入的信息进行匹配
		DealingWithCode cus1 = new DealingWithCode();
		cus1.accountNumber = zhanghao;
		cus1.code = mima;
		cus1.In();
		while(smbl != cus1.accountNumberContrast()){}
		cus1.generatePassword();//随即口令生成并要求输入，输入错误则会重新生成随机口令
		//随即口令匹配，包括当前随即口令的匹配和同上一次的口令的匹配
	}
}
