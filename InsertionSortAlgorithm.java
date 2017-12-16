
public class InsertionSortAlgorithm {

	void sort(int[] arr) {
		int current, j;
		for(int i = 1; i < arr.length; i++) {
			current = arr[i];
			j = i;
			while(j > 0 && arr[j - 1] > current) {
				arr[j] = arr[j -1];
				j -= 1;
			}
			arr[j] = current;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {3, 6, 1, 7, 5, 9, 8, 2};
		InsertionSortAlgorithm is = new InsertionSortAlgorithm();
		is.sort(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
