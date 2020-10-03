package cn.lettle.datamanager;
import cn.lettle.datamanager.entity.Data;
import cn.lettle.datamanager.entity.DataManager;
import cn.lettle.datamanager.entity.DictBox;
import cn.lettle.datamanager.store.DataStorage;
import java.util.Scanner;


public class Main
{
	
	public static void main(String args[]){
		Scanner scn = new Scanner(System.in);
		
		DataManager dm = new DataManager();
		dm.add(DataStorage.getInstance().getData());
		
		String cmd = "";
		while(true){
			System.out.println("------------------------------");
			System.out.print("查询内容: ");
			cmd = scn.next();
			if(cmd.equals("/exit")){System.out.println("程序结束"); break;}
			
			DictBox res = new DictBox(dm.get(cmd).toArray());
			if(res.getCount() == 0){System.out.println("没有关于这个的笔记");continue;}
			for(Data e:res.toArray()){
				System.out.println(
					e.toString());
			}
		}
	}
}

