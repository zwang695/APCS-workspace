import java.util.Arrays;

public class ResizableArray<E> {

	private E[] data;
	private final int MAX_DATA_AMOUNT = 100;
	private int size;
	
	public ResizableArray() {
		data = (E[]) new Object[MAX_DATA_AMOUNT];
		size = 0;
	}
	
	public void add(E val) {
		if(size+1 >= data.length) resize();
		data[size] = val;
		size++;
	}
	
	public void insert(int i, E val) {
		if(size+1 >= data.length) resize();
		if(i<size) {
			for(int j = size; j > i; j--) {
				data[j] = data[j-1];
			}
			size++;
			data[i] = val;
		}
		else {
			throw new ArrayIndexOutOfBoundsException("Index too big: " + i);
		}
	}
	
	public void set(int i, E val) {
		if(i<size) {
			data[i] = val;
		}
		else {
			throw new IllegalArgumentException("Index too big: " + i);
		}
	}
	
	public E remove(int i) {
		if(i<size) {
			E val = data[i];
			for(int j = i; j < size; j++) {
				data[j] = data[j+1];
			}
			size--;
			return val;
		}
		else {
			throw new IllegalArgumentException("Index too big: " + i);
		}
	}
	
	public int size() {
		return size;
	}
	
	public E get(int i) {
		if(i<size) {
			return data[i];
		}
		else {
			throw new IllegalArgumentException("Index too big: " + i);
		}
	}
	
	public int indexOf(E val) {
		for(int i = 0; i < size; i++) {
			if(data[i].equals(val)) {
				return i;
			}
		}
		return -1;
	}
	
	//not finished	
	public boolean equals(Object other) {
		ResizableArray ra = (ResizableArray) other;
		if(size != ra.size()) {
			return false;
		}
		for(int i = 0; i < size; i++) {
			if(!ra.get(i).equals(data[i])) return false;
		}
		return true;
	}
	
	public void sort() {
		
		for (int i = 0; i < size-1; i++) {
            for (int j = 0; j < size-i-1; j++) {
            	Comparable x = (Comparable)data[j];
            	if(x.compareTo(data[j+1]) > 0) {
        			E temp = data[j];
        			data[j] = data[j+1];
        			data[j+1] = temp;
        		}
            }
		}
	}
	
	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append("[");
		for(int i = 0; i < size; i++) {
			s.append(data[i]);
			if(i!=size-1) {
				s.append(", ");
			}
		}
		s.append("]");
		return s.toString();
	}
	
	private void resize() {
		//int[] copy = new int[data.length + 3000];
		data = Arrays.copyOf(data, data.length + 1000);
//		for(int i = 0; i < size; i++) {
//			copy[i] = data[i];
//		}
	}
	
	public E[] toArray() {
		return Arrays.copyOf(data, size);
	}
	
}
