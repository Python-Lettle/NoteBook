package cn.lettle.datamanager.entity;

import java.util.*;

public class ArrayBox implements IBox
{
	
	public String __version__ = "v1.2";
	
	//最终存储装载的对象
	private Object[] elements;
	//记录元素个数,以及下一个元素的位置
	private int count = 0;
	//定义最大值
//	private final int MAX_COUNT = 100;
	
	public ArrayBox() {
		this(16);
	}
	public ArrayBox(int length) {	
		elements = new Object[length];
	}
	public ArrayBox(Object[] e) {
		for (int i = 0; i < e.length; i++) {
			this.elements = e;
			count++;
		}
	}
	
	//添加一个Object
	public boolean add(Object e) {
		//判断容量是否够用
		checkLength(1);
		
		//此时容量足够，插入元素
		this.elements[count] = e;
		this.count++;
		return true;
	}
	
	//添加一组Object
	public boolean add(Object[] es) {
		checkLength(es.length);
		
		for (int i = 0; i < es.length; i++) {
			elements[count] = es[i];
			count++;
		}
		//count += es.length;
		return true;
	}
	
	//通过index获取一个Object
	public Object get(int index) {
		return elements[index];
	}
	
	public Object remove(int index) {
//		for(int i=index+1; i<=count-1; i++) {
//			elements[i-1] = elements[i];
//		}
//		Object e = elements[count-1];
		
		Object removeObject = this.elements[index];
		
		copy(this.elements, index+1, this.elements, index, count-index-1);
		this.elements[count-1] = null;
		count--;
		
		return removeObject;
	}
	
	//向某个位置插入元素，原来的向后移
	public boolean insert(Object e, int index) {
		if(index < elements.length) {
			checkLength(1);
			//先移位
			if(index < count) {
				for(int i = count-1; i>=index; i--) {
					elements[i+1] = elements[i];
				}
			}
			//插入元素
			elements[index] = e;
			count++;
			return true;
		}
		return false;
	}
	
	//去重
	/*
	public boolean ifRepeat(){
		
		for(int i=0;i<this.elements.length;i++){
			for(int ii=0;ii<this.elements.length;i++){
				if(this.elements[i] == this.elements[ii]){
					remove(i);
					count--;
					break;
				}
			}
		}
		return true;
		
		
	}
	*/

	/**
	 * 去掉数组中重复的元素
	 *
	 * @param arr
	 * @return
	 */
	//方法一：需要传入一个Object数组，然后返回去重后的数组  
	public Object[] ifRepeat()
	{  
		Object[] arr = this.elements;
		//用来记录去除重复之后的数组长度和给临时数组作为下标索引  
		int t = 0;  
		//临时数组  
		Object[] tempArr = new Object[arr.length];  
		//遍历原数组  
		for (int i = 0; i < arr.length; i++)
		{  
			//声明一个标记，并每次重置  
			boolean isTrue = true;  
			//内层循环将原数组的元素逐个对比  
			for (int j=i + 1;j < arr.length;j++)
			{  
				//如果发现有重复元素，改变标记状态并结束当次内层循环  
				if (arr[i] == arr[j])
				{  
					isTrue = false;  
					break;  
				}  
			}  
			//判断标记是否被改变，如果没被改变就是没有重复元素  
			if (isTrue)
			{  
				//没有元素就将原数组的元素赋给临时数组  
				tempArr[t] = arr[i];  
				//走到这里证明当前元素没有重复，那么记录自增  
				t++;  
			}  
		}  
		//声明需要返回的数组，这个才是去重后的数组  
		Object[]  newArr = new Object[t];  
		//用arraycopy方法将刚才去重的数组拷贝到新数组并返回  
		System.arraycopy(tempArr, 0, newArr, 0, t);
		this.elements = removeNull(newArr);
		return this.elements;  
	}
	
	//获得容器中装载数据的数量
	public int size() {
		return count;
	}
	
	//获取容量
	public int volume() {
		return this.elements.length;
	}
	
	public Object[] toArray() {
		Object[] elements2 = removeNull(this.elements);
		return elements2;
	}
	
	public String toString () {
		String res = "[";
		
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] != null) {
				res += "\"" + elements[i] + "\",";
			}else {
				res += elements[i] + ",";
			}
		}
		res = res.substring(0,res.length() -1);
		res += "]";
		return res;
	}

	public String[] toStringArray(){
		String[] res = new String[size()];
		for(int i=0; i<elements.length; i++){
			res[i] = elements.toString();
		}
		return res;
	}
	
	private void checkLength(int need) {
		int needMinLength = count + need;
		if(needMinLength > elements.length) {
			//容量不足 需要扩容
			int newLength = elements.length<<1 + 1;
			newLength = Math.max(newLength, needMinLength);
			
			//将扩容的新数组的地址传给box
			Object[] newElements = new Object[newLength];
			
//			for (int i = 0; i < count; i++) {
//				newElements[i] = elements[i];
//			}
			
			copy(this.elements, 0, newElements, 0, count);
			
			this.elements = newElements ;
		}
	}
	
	private void copy(Object[] sourse, int start, Object[] target, int begin, int length) {
		int sIndex = start;
		int tIndex = begin;
		int count = 0;
		while (true) {
			if(count++ == length) {
				return;
			}
			if(sIndex == sourse.length) {
				return;
			}
			if(tIndex == target.length) {
				return;
			}
			
			target[tIndex++] = sourse[sIndex++] ;
		}
	}
	
	//删除null元素
	private Object[] removeNull(Object[] objs){
		Object[] newObjs;
		List<Object> list;
		try{
			list = new ArrayList(objs.length);
		}catch (NullPointerException e){
			return null;
		}

		for(Object obj : objs){
			list.add(obj);
		}

		//删除空的值
		while(list.remove(null));
		
		newObjs = list.toArray();
		return newObjs;
	}
}
