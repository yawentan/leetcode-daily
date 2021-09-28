package yawen;
/*
 *@author: yawen
 *@function: 手写hash表，参考https://www.cnblogs.com/hkblogs/p/9151160.html
 */
public class MyHashMap {
	
	//table 默认初始长度
	static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	//负载因子，当达到16*0.75时，发生扩容。
	static final float DEFAULT_LOAD_FACTOR = 0.75f;
	
	Entry[] table;
	
	int size;
	int threshold;
	
	//无参构造器
	public MyHashMap(){
		threshold = (int)(DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
		table = new Entry[DEFAULT_INITIAL_CAPACITY];
	}
	
	//hash构造函数
	public final int hash(Object key) {
		int h;
		return (key == null)?0:(h=key.hashCode())^(h>>>16); 
	}
	
	static int findBucketIndex(int h,int length) {
		return h&(length-1);
	}
	
	public Object put(Object key,Object value) {
		/*if(null == key) {
			return putNullKey(value);
		}*/
		int h = hash(key);
		int i = findBucketIndex(h,table.length);
		//如果重复，删除旧的
		for(Entry e=table[i];e!=null;e=e.next) {
			Object k;
			if(e.hash==h&&((k=e.key) == key||key.equals(k))) {
				Object OldValue = e.value;
				e.value = value;
				return OldValue;
			}
		}
		addEntry(h,key,value,i);
		return key;
	}
	
	void addEntry(int h,Object key,Object value,int i) {
		Entry e = table[i];
		table[i] = new Entry(h,key,value,e);
		size++;
		if(size>threshold) {
			System.out.println("我还没写扩容");
			//resize(table.length*2);
		}
	}
	
	public Object get(Object key) {
		int h = hash(key);
		int i = findBucketIndex(h,table.length);
		for(Entry e = table[i];e!=null;e=e.next) {
			if(e.hash==h&&(key==e.key||key.equals(e.key)))
				return e.value;
		}
		return null;
	}
	
	//map的储存单元
	static class Entry{
		int hash;
		Object key;
		Object value;
		Entry next;
		//构造器：初始化功能==__init__()(python)
		public Entry(int hash,Object key, Object value,Entry next) {
			this.hash = hash;
			this.key = key;
			this.value=value;
			this.next=next;
		}
	}
	
	public static void main(String arg[]) {
		MyHashMap Hashtab = new MyHashMap();
		Hashtab.put(1, 'a');
		System.out.println(Hashtab.get(2));
	}
}