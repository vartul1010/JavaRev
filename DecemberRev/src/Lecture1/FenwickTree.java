package Lecture1;

public class FenwickTree {
	
	// BinaryIndexTree

	public static void main(String[] args) {
		
		int[] arr = {1, 2, 4, -5, 6, 8, -10};
		
		FenwickTree ft = new FenwickTree(arr);
		
		System.out.println(ft.getSum(1, 5));
		ft.update(1, -4);
		ft.update(3, 5);
		System.out.println(ft.getSum(1, 5));
	}
	
	private  int[] farr;
	private int[] oarr;
	
	public FenwickTree (int arr[]){
		this.oarr = new int[arr.length];
		this.farr = new int[arr.length + 1];
		
		for(int i=0; i<arr.length; i++){
			this.update(i, arr[i]);
		}
	}
	
	public int getSum(int i){
		int sum = 0;
		int pos = i + 1;
		
		while(pos != 0){
			sum += farr[pos];
			int lastBit = getLastBit(pos);
			pos -= lastBit;
		}
		
		return sum;
	}
	
	// Assuming j > i
	public int getSum(int i, int j){
		int sumTillIM1 = getSum(i-1);
		int sumTillJ = getSum(j);
		
		return sumTillJ - sumTillIM1;
	}
	
	public void update(int i, int delta){
		int pos = i + 1;
		
		while(pos < farr.length){
			farr[pos] += delta;
			int lastBit = getLastBit(pos);
			pos += lastBit;
		}
		
		oarr[i] += delta;
	}
	
	private int getLastBit(int i){
		return i & -i;
	}

}
