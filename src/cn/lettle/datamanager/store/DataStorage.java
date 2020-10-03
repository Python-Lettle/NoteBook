package cn.lettle.datamanager.store;
import cn.lettle.datamanager.entity.Data;
import cn.lettle.datamanager.entity.DictBox;
import cn.lettle.datamanager.entity.ArrayBox;

/**
 * 单例数据存储
 */
public class DataStorage
{
	private DataStorage(){}
	private static DataStorage instance = new DataStorage();
	public static DataStorage getInstance(){ return instance;}
	
	private String data = 
	 "avoid doing/avoid后面跟doing|"
	+"be to blame/应受责备的|"
	+"be used to/习惯于|"
	+"be reported to do sth./报道某人做某事|"
	+"can/aux.能,可能 n.罐子|"
	+"look forward to/盼望;期望|"
	+"refer to/参考;查阅;指的是|"
	+"turn to/转向...;(使)变成;求助于|"
	;
	
	public Data[] getData(){
		String[] DataStrings = data.toString().split("\\|");
		DictBox ab = new DictBox();
		for(String s : DataStrings){
			String[] DataPiece = s.split("/"); //0为title 1为value
			ab.add(new Data(DataPiece[0],DataPiece[1]));
		}
		
		return ab.toArray();
	}
	public String getDataString(){return data;}
}
