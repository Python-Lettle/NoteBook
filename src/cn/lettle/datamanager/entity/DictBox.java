package cn.lettle.datamanager.entity;

public class DictBox extends ArrayBox
{
	public DictBox(){
		super();
	}
	public DictBox(Data[] ds){
		super(ds);
	}
	//精准get
	public Data get(String name){
		Data e;
		//Data[] ds = (Data[]) super.toArray();
		
		for(int i=0;i<super.size();i++){
			e = (Data)super.get(i);
			if (e.getName() == name){
				return e;
			}
		}
		
		/*
		for(Data e:ds){
			
		}
		*/
		return null;
	}
	
	//模糊搜索
	public ArrayBox getAll(String[] keywords){
		Data e;
		ArrayBox ab = new ArrayBox();
		for(String keyword:keywords){
			for(int i=0;i<super.size();i++){
				e = (Data)super.get(i);
				if(e==null){continue;}
				if (e.getName().indexOf(keyword) != -1){
					ab.add(e);
				}
			}
		}
		
		return ab;
	}
	
	//检查如果含有关键词的Data在里面
	public Data ifin(String name){
		String[] keywords;
		Data e;
		for(int i=0;i<super.size();i++){
			e = (Data)super.get(i);
			if (e.getName() == name){
				return e;
			}
		}
		return null;
	}

	@Override
	public Data[] toArray()
	{
		Object[] os;
		Data[] ds;
		try{
			os = super.toArray();
			ds = new Data[os.length];
			for(int i=0;i<os.length;i++){
				ds[i] = (Data)os[i];
			}
		}catch(NullPointerException e){
			return null;
		}
		
		return ds;
	}
	
	public int getCount(){
		return super.count;
	}
}
