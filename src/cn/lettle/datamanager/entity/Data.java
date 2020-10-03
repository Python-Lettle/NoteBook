package cn.lettle.datamanager.entity;

public class Data
{
	
	private String name;  //数据名称
	private String value;

	public Data(String name,String value){
		this.name = name;
		this.value = value;
	}
	
	@Override
	public String toString()
	{
		String res;
		res =  "标题: " + name + "\n";
		res += "内容:\n" +value;
		return res;
	} //数据内容
	
	public String getName(){
		return this.name;
	}
	public String getValue(){
		return this.value;
	}
	public String[] getKeyword(){
		return this.value.split(" ");
	}

}
