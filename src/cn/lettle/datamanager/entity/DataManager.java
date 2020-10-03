package cn.lettle.datamanager.entity;

/**
 *数据管理类的主体
 */
public class DataManager
{
	//盒子: 装载Data对象
	private DictBox box;  //变量单元存储盒子
	
	public DataManager(){
		this.box = new DictBox();
	}
	
	public boolean setBox(DictBox b){
		this.box = b;
		return true;
	}
	public IBox getBox(){
		return this.box;
	}
	
	//添加Data进box
	public boolean add(Data e){
		this.box.add(e);
		return true;
	}
	public boolean add(Data[] es){
		this.box.add(es);
		return true;
	}
	
	//有模糊搜索功能 return: 装有Data的Arraybox
	public DictBox get(String name){
		String[] keywords = name.split(" ");
		ArrayBox ab = new ArrayBox();
		DictBox res = new DictBox();
		ab = this.box.getAll(keywords);
		for(Object d:ab.toArray()){
			if(d!= null){
				res.add(d);
			}
		}
		return res;
	}
}
