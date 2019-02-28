package algorythm;
import java.util.*;
public class Bfs_cnt{
	static int cnt;
	static int dir[][]={{-1,0},{0,1},{1,0},{0,-1}};
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()){
			int n = sc.nextInt();
			int m = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			int [][]a = new int[n][m];
			for(int i=0;i<n;i++)
				for(int j=0;j<m;j++)
					a[i][j] = sc.nextInt();
			
			cnt = 0;
			bfs(x-1,y-1,n,m,a);
			System.out.println(cnt);
		}
	}
	public static void bfs(int x,int y,int n,int m,int [][]a){
		 if(x<0||x>=n||y<0||y>=m||a[x][y]==0)return;//边界条件
		 a[x][y]=0;cnt++;//走过的地方不能再走（标志）
		 for(int i=0;i<4;++i)
			 bfs(x+dir[i][0],y+dir[i][1],n,m,a);
	}
 }
