import java.util.Arrays;

public class MergeSortAlgorithm {

	void sort(int[] arr) {
		if(arr.length > 1) {
			int mid = arr.length / 2;
			int[] left = Arrays.copyOfRange(arr, 0, mid);
			int[] right = Arrays.copyOfRange(arr, mid, arr.length);
			
			sort(left);
			sort(right);
			merge(left, right, arr);
		}
	}
	
	void merge(int[] left, int[] right, int[] arr) {
		int l = 0;
		int r = 0;
		int k = 0;
		while(l < left.length && r < right.length) {
			if(left[l] > right[r]) {
				arr[k] = right[r];
				r++;
			}
			else {
				arr[k] = left[l];
				l++;
			}
			k++;
		}
		if(l == left.length) {
			while(r != right.length) {
				arr[k] = right[r];
				k++;
				r++;
			}
		}
		else{
			while(l != left.length) {
				arr[k] = left[l];
				k++;
				l++;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {3, 6, 4, 7, 5, -9, 1, 8, 2};
		MergeSortAlgorithm ms = new MergeSortAlgorithm();
		ms.sort(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
