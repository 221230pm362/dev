package main;

public class KhList<T> {
	
	//사이즈가 늘어나는 배열을 관리
	private Object[] arr;
	
	private int firstEmptyIdx;

	//생성자
	public KhList() {
		arr = new Object[3];
		firstEmptyIdx = 0;
	}
	
	//add
	public void add(T data) {
		if(firstEmptyIdx == arr.length) {
			Object[] temp = new Object[arr.length * 2];
			for(int i = 0 ; i < arr.length; ++i) {
				temp[i] = arr[i];
			}
			arr = temp;
		}
		
		arr[firstEmptyIdx++] = data;
	}
	
	
	//get
	public Object get(int idx) {
		return (T) arr[idx];
	}
	
	//remove
	public void remove(int idx) {
		arr[idx] = null;
		for(int i = idx; i < firstEmptyIdx-1; i++) {
			arr[i] = arr[i+1];
		}
		firstEmptyIdx--;
	}
	
	//toString
	@Override
	public String toString() {
		String str = "";
		
		for(int i = 0 ; i < firstEmptyIdx; ++i) {
			str += arr[i];
			if(i == firstEmptyIdx-1) {
				continue;
			}
			str += ",";
		}
		
		return str;
	}
	
	//size
	public int size() {
		return firstEmptyIdx;
	}
	
	
	
}//class












