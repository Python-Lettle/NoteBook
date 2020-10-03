package cn.lettle.datamanager.entity;

public interface IBox {
	
	/**
	 * 装载
	 * @param obj
	 * @return boolean
	 * 			true  装载成功
	 * 			false 装载失败
	 */
	public abstract boolean add(Object obj) ;
	
	/**
	 * 获取一个Object
	 * @param index
	 * @return Object
	 */
	public abstract Object get(int index) ;
	
	/**
	 * 返回数组内容数量
	 * @return int
	 */
	public abstract int size()  ; 
	
	/**
	 * 移除一个元素
	 * @param index
	 * @return 移除的Object
	 */
	public abstract Object remove(int index) ;
	
	/**
	 * 将Box转换为数组并返回
	 * @return 数组类型的Object
	 */
	public abstract Object[] toArray() ;
	
	
}
