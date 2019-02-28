package algorythm;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int arr[] = {10,4,8,1,2,47,5,6};
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int arr[],int left,int right){
		if(left <right){
			//获取枢纽并把其放在数组尾
			getpivot(arr, left, right);
			//左指针
			int i = left;
			//右指针
			int j = right-1;
			while(true){
				for(;arr[i]<arr[right-1];++i);
				for(;arr[j]>arr[right-1]&&j>left;--j);
				if(i>=j)
					break;
				swap(arr, i, j);
			}
			if(i<right)
				swap(arr, i, right-1);
			if(arr[right]<arr[right-1])
				swap(arr, right, right-1);
			quickSort(arr, left, i-1);
			quickSort(arr, i+1, right);
		}
	}
	
	//两数交换
	public static void swap(int arr[],int a,int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	//处理枢纽
	public static void  getpivot(int arr[],int left,int right) {
		int mid = (left+right)/2;
		if(arr[left]>arr[mid]){
			swap(arr, left, mid);
		}
		if(arr[left]>arr[right]){
			swap(arr, left, right);
		}
		if(arr[mid]>arr[right]){
			swap(arr, mid, right);
		}
		swap(arr, mid, right-1);
	}
	
}
