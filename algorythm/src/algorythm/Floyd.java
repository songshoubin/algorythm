package algorythm;

public class Floyd {
	final static int max = 100000;
	public static void floyd(int arr[][],int n ) {
		for(int i = 0;i < n ; i++){//設置一個中介
			for (int j = 0; j < n; j++) {//起點
				for (int k = 0; k < n; k++) {//終點
					if(arr[j][k]>arr[j][i]+arr[i][k])
						arr[j][k]=arr[j][i]+arr[i][k];
				}
				
			}
		}
	}
	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
		// TODO Auto-generated method stub
		int ad[][] = {{max,2,6,4,7},{2,max,max,1,max},{6,max,max,max,max},{4,2,max,max,5},{7,max,max,5,max}};
		floyd(ad, 5);
		for (int[] is : ad) {
			for (int i : is) {
				System.out.println(i);
			}
			System.out.println();
		}
		
		/*for(int i = 0; i < 5; i++){数组（即两点距离）自动输入
			for(int j = 0; j < 5; j++){
				ad[i][j] = scanner.nextInt();
			}
		}*/
	}
}
