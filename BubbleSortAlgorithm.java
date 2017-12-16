
public class BubbleSortAlgorithm {

	void sort(int[] arr) {
		int temp;
		boolean swapped = true;
		while(swapped) {
			swapped = false;
			for(int i = 0; i < arr.length - 1; i++) {
				if(arr[i] > arr[i + 1]) {
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					swapped = true;
				}
			} 
		}	
	}
	
	public static void main(String[] args) {
		int[] arr = {3, 6, 4, 7, 5, -9, 1, 8, 2};
		BubbleSortAlgorithm bs = new BubbleSortAlgorithm();
		bs.sort(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
