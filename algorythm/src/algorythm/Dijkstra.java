package algorythm;
import java.util.Arrays;

/**
 * @author song
 *
 */
public class Dijkstra {
		final  public static int max = 1000000;
		public static void main(String[] args) {
			//二维数组存权值
			int arr[][] = {{max,1,7,4,3,},{1,max,max,2,max},{7,max,max,6,max},{4,2,6,max,2,},{3,max,max,2,max}};
			dijkstra(arr, 0);
			for (int[] is : arr) {
				for (int is1 : is) {
					System.out.println(is1);
				}
				System.out.println();
			}
		}
		
		
		//迪杰斯特拉求n点到各点的最短距离
		public static void dijkstra(int arr[][],int n) {
			//s集合
			boolean mark[] = new boolean[arr[0].length];		
			//初始化mark
			for(int i = 0; i < arr[0].length; i++)
				mark[i] = false;
			mark[n] = true;
			
			int temp = n;
			for(int i = 0;i < arr[0].length-1;i++) {
			 temp = findMinLoad(mark, temp,n, arr);
			}
			
		}
		//找到n点到剩余各点的最小值并标志并且更新权
		public static int findMinLoad(boolean mark[],int n,int start, int arr[][]) {
			int min = max;
			int temp = 0;
			for(int i = 0;i < arr[0].length;i++) 
				if(!mark[i]&&arr[n][i]<min) {
					min = arr[n][i];
					temp = i;
				}
			for(int i = 0;i < arr[0].length;i++) {//更新数组
				if(!mark[i]&&arr[start][i] > arr[start][temp]+arr[temp][i])
					arr[start][i] = arr[start][temp]+arr[temp][i];
			}
			mark[temp] = true;
			return temp;
		}
}