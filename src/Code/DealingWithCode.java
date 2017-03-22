package Code;

import java.io.*;
import java.util.*;

public class DealingWithCode 
{
	String accountNumber,inaccountNumber;//�˺ź��û�������˺�
	String code,incode;//������û����������
	String randomcode,inrandomcode,RepeatedRandomCode;//�������û���������������ظ����������
	
	//���ļ��ж�ȡ��һ�ε���������Ҫ���û������˺ź�����
	public void In() throws Exception
	{
		File f = new File("c:\\test\\randomcode.txt");
		FileInputStream fis = new FileInputStream(f);
		InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
		BufferedReader br = new BufferedReader(isr);
        RepeatedRandomCode = br.readLine();
        br.close();
		System.out.println("�����������˺ź����룺");
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
	
	//�û�������˻�������ĵ��е���Ϣ����ƥ�䣬���ɹ��������һ����ʧ�������ʾ�������룬�����ѡ���˳�
	public int accountNumberContrast()
	{
		int symbol;
		if(inaccountNumber.equals(accountNumber)&&incode.equals(code))
		{
			symbol = 1;
		}
		else
		{
			System.out.println("�˺�����������������룡");
			System.out.println("�����������˺ź����룺");
			Scanner reader = new Scanner(System.in);
			inaccountNumber = reader.next();
			incode = reader.next();
			symbol = 0;
		}
		return symbol;
	}
	
	//�û���Ϣƥ��ɹ���������������Ҫ���û�����
	public void generatePassword() throws Exception
	{
		int a,b;
		System.out.println("���������¿��");
		Random rand = new Random();
		a = rand.nextInt(900000)+100000;//�������6λ���ֵĿ���
		randomcode = String.valueOf(a);
		System.out.println(randomcode);
		Scanner reader = new Scanner(System.in);
        b = reader.nextInt();
        inrandomcode = String.valueOf(b);
        randomCodeContrast();//���п���ƥ�䣬��ʧ���򷵻ؿ������ɣ���֮��ɹ���½
	}
	
	//�������ƥ�䣬���ɹ�����ʾ�ɹ���½��ʧ�������ʾ������������ظ���ϵͳ�����������µ�������Ҫ���û�����
	public int randomCodeContrast() throws Exception
	{
		int count = 0;
		if(0 == repeatedRandomCodeContrast()){}//ͬ��һ�ε�����������ƥ�䣬��ƥ��ɹ��򷵻ؿ����ظ������Զ������µ��������Ҫ���û�����
		if(inrandomcode.equals(randomcode))
		{
			count++;
		}	
		if(count == 1)
		{
			System.out.println("������ȷ����½�ɹ���");
			Out();
			return 1;
		}
		else 
		{
			System.out.println("�������������������");
			generatePassword();
			return 0;
		}
	}
	
	//�ظ��������Ա�
	public int repeatedRandomCodeContrast() throws Exception
	{
		int count = 1;
		if(inrandomcode == RepeatedRandomCode)
		{
			count--;
		}
		if(count != 1)
		{
			System.out.println("�����ظ���������������");
			generatePassword();
			return count;
		}
		return count;
	}
}
