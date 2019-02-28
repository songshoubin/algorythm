package algorythm;

public class FullySort {

	public static void main(String[] args) {
		int arr[] = {1,5,7,2};
		fullySort(arr,0);
	}

	public static void fullySort(int arr[],int start) {
		if((arr.length-1)==start){
			for (int i : arr) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
		for(int i=start;i<=arr.length-1;i++){
			swap(arr, i, start);
			fullySort(arr, start+1);
			swap(arr, i, start);
		}
		
		
	}
	public  static void swap(int arr[],int a,int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] =temp;
	}
}
