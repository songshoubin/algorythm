package algorythm;

import java.util.*;

/**
 * 
 * @author song
 *有 N 个网络节点，标记为 1 到 N。
给定一个列表 times，表示信号经过有向边的传递时间。 times[i] = (u, v, w)，其中 u 是源节点，v 是目标节点， w 是一个信号从源节点传递到目标节点的时间。
现在，我们向当前的节点 K 发送了一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1。

注意:
N 的范围在 [1, 100] 之间。
K 的范围在 [1, N] 之间。
times 的长度在 [1, 6000] 之间。
所有的边 times[i] = (u, v, w) 都有 1 <= u, v <= N 且 1 <= w <= 100。
 */


public class NetworkDelay {
	final static int max = 35536;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();//有n个顶点
		int [][]a = new int[n][n];//存有向图
		int []dist = new int[n];//存源顶点到各顶点的最短距离
		int []prev = new int[n];//存源顶点到该顶点最短路径的前驱顶点
		boolean []m = new boolean[n];//该顶点是否已经找到最短路径
		for(int i=0;i<n;i++)//初始化有向图
			for(int j=0;j<n;j++)
				a[i][j] = scanner.nextInt();
		
		dijkstra(a, dist, prev, m, 0);
		for(int i=0;i<n;i++)
			System.out.println(dist[i]);
	}
	
	public static void dijkstra(int [][]x,int []dist,int []prev,boolean []m,int v0){
		for(int i=0;i<dist.length;i++){//初始化最短路径
			dist[i] = x[v0][i];
			m[i] = false;
			if(dist[i] == max)
				prev[i] = v0;
			else {
				prev[i] = -1;
			}
			
		}
		
		dist[v0] = 0;
		m[v0] = true;
		prev[v0] = v0;
		
		for(int i=0;i<dist.length;i++){//循环n-1次   一次找到一个顶点的最短路径
			int u = v0;//标记此顶点为这次找到最短路径的坐标
			int mindist = max;
			for(int j=0;j<dist.length;j++){//找到当前状态图且未找到的最短路径
				if(!m[j]&&dist[j]<mindist){
					u = j;
					mindist = dist[j];
				}
			}
			m[u] = true;
			for(int k=0;k<dist.length;k++){//更新图
				if(!m[k]&&dist[k]>dist[u]+x[u][k]){
					dist[k] = dist[u]+x[u][k];
					
					prev[k] = u;
				}
			}
			
		}
	}
}
