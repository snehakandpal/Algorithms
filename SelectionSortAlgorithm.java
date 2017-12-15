
public class SelectionSortAlgorithm {
	
	void sort(int[] arr) {
		int smallest;
		int temp;
		for(int i = 0; i < arr.length - 1; i++) {
			smallest = i;
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[j] < arr[smallest])
					smallest = j;
			}
			temp = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = temp;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {2, 5, 1, 8, 4, 7, 3};
		SelectionSortAlgorithm ss = new SelectionSortAlgorithm();
		ss.sort(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
