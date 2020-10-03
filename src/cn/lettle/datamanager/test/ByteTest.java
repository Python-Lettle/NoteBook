package cn.lettle.datamanager.test;

public class ByteTest
{
	public static void main_(String args[]){
		int check = 16;
		int num = 13;
		while((num & check) == 0){
			System.out.println(num++);
		}
		System.out.println("后面的语句...");
	}
}
