
public class BinarySearchAlgorithm {

	int search(int[] arr, int num) {
		int front = 0;
		int rear = arr.length - 1;
		int mid;
		
		while(front < rear) {
			mid = (front + rear) / 2;
			if(num == arr[mid])
				return mid;
			else {
				if(num > arr[mid])
					front = mid + 1;
				else
					rear = mid - 1;
			}			
		}
		return 0;
	}
	
	public static void main(String args[]) {
		int[] arr = {34, 42, 56, 57, 60, 71, 74, 78, 80, 99 };
		int num = 89;
		BinarySearchAlgorithm bs = new BinarySearchAlgorithm();
		
		int result = bs.search(arr, num);
		if(result == 0)
			System.out.print("The number is not in the array.");
		else
			System.out.print("The number is at array index " + result +".");
	}
}
