package Code;

import java.io.*;
import java.util.*;

public class DealingWithCode 
{
	String accountNumber,inaccountNumber;//账号和用户输入的账号
	String code,incode;//密码和用户输入的密码
	String randomcode,inrandomcode,RepeatedRandomCode;//随机口令、用户输入的随机口令和重复的随机口令
	
	//从文件中读取上一次的随机口令，并要求用户输入账号和密码
	public void In() throws Exception
	{
		File f = new File("c:\\test\\randomcode.txt");
		FileInputStream fis = new FileInputStream(f);
		InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
		BufferedReader br = new BufferedReader(isr);
        RepeatedRandomCode = br.readLine();
        br.close();
		System.out.println("请输入您的账号和密码：");
		Scanner reader = new Scanner(System.in);
		inaccountNumber = reader.next();
		incode = reader.next();
	}
	
	public void Out() throws Exception
	{
		File f = new File("c:\\test\\randomcode.txt");
		FileOutputStream fos = new FileOutputStream(f);
		OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		bw.write(randomcode);	
		bw.newLine();
		bw.close();
	}
	
	//用户输入的账户密码和文档中的信息进行匹配，若成功则进行下一步，失败则会提示重新输入，否则可选择退出
	public int accountNumberContrast()
	{
		int symbol;
		if(inaccountNumber.equals(accountNumber)&&incode.equals(code))
		{
			symbol = 1;
		}
		else
		{
			System.out.println("账号密码错误！请重新输入！");
			System.out.println("请输入您的账号和密码：");
			Scanner reader = new Scanner(System.in);
			inaccountNumber = reader.next();
			incode = reader.next();
			symbol = 0;
		}
		return symbol;
	}
	
	//用户信息匹配成功后，生成随机口令，并要求用户输入
	public void generatePassword() throws Exception
	{
		int a,b;
		System.out.println("请输入以下口令：");
		Random rand = new Random();
		a = rand.nextInt(900000)+100000;//随机生成6位数字的口令
		randomcode = String.valueOf(a);
		System.out.println(randomcode);
		Scanner reader = new Scanner(System.in);
        b = reader.nextInt();
        inrandomcode = String.valueOf(b);
        randomCodeContrast();//进行口令匹配，若失败则返回口令生成，反之则成功登陆
	}
	
	//随机口令匹配，若成功则提示成功登陆，失败则会提示输入错误或口令重复，系统会重新生成新的随机口令并要求用户输入
	public int randomCodeContrast() throws Exception
	{
		int count = 0;
		if(0 == repeatedRandomCodeContrast()){}//同上一次的随机口令进行匹配，若匹配成功则返回口令重复，并自动生成新的随机口令要求用户输入
		if(inrandomcode.equals(randomcode))
		{
			count++;
		}	
		if(count == 1)
		{
			System.out.println("口令正确，登陆成功！");
			Out();
			return 1;
		}
		else 
		{
			System.out.println("口令错误，请重新输入口令！");
			generatePassword();
			return 0;
		}
	}
	
	//重复随机口令对比
	public int repeatedRandomCodeContrast() throws Exception
	{
		int count = 1;
		if(inrandomcode == RepeatedRandomCode)
		{
			count--;
		}
		if(count != 1)
		{
			System.out.println("口令重复，请重新输入口令！");
			generatePassword();
			return count;
		}
		return count;
	}
}
