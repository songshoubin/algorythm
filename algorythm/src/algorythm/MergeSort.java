package algorythm;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int arr[] = {8,5,4,9,6,11,2,3};
		int temp[] = new int[arr.length];
		sort(arr,0,arr.length-1,temp);
		System.out.println(Arrays.toString(arr));
		System.out.println("成功了");
	}

	
	public static void  sort(int arr[],int left,int right,int temp[]) {
		if(left<right){
			int mid = (left+right)/2;
			sort(arr, left, mid, temp);//分左数组
			sort(arr, mid+1,right, temp);//分右数组
			merge(arr,left,mid,right,temp);//左右数组并
		}
		
	}


	private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
		int i = left;//左指针
		int j = mid+1;//右指针
		int t = 0;//临时指针
		while(i<=mid&&j<=right){
			if(arr[i]<arr[j])
				temp[t++] = arr[i++];
			else
				temp[t++] = arr[j++];
		}
		while(i<=mid){//把剩余的左数组放进temp
			temp[t++] = arr[i++];
		}
		while(j<=right){//把剩余的右数组放进temp
			temp[t++] = arr[j++];
		}
		
		t = 0;
		//将temp copy进原数组
		while (left<=right) {
			arr[left++] = temp[t++];
		}
	}
}
