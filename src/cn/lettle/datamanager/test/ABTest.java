package cn.lettle.datamanager.test;
import cn.lettle.datamanager.entity.ArrayBox;

public class ABTest
{
	public static void mmain(String args[]){
		ArrayBox ab = new ArrayBox();
		String h = new String("hello");
		ab.add(h);
		ab.add(h);
		ab.add("haha");
		System.out.println(ab.toString());
		ab.ifRepeat();
		System.out.println(ab.toString());
	}
}
