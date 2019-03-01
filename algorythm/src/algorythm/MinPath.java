package algorythm;

import java.util.*;

/**
 * 
 * @author song
 *给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
说明：每次只能向下或者向右移动一步。

示例:

输入:[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]

输出: 7

本题使用动态规划算法解，本题dp实现采用数组实现
 */
public class MinPath {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		int [][]x = new int[m][n];
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				x[i][j] = scanner.nextInt();
		MinPathSum(x, m, n);
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				System.out.print(x[i][j]+" ");
			}
			System.out.println();
		}
		//最短路径为x[m-1][n-1]	
		System.out.println(x[m-1][n-1]);
	}

	public static void MinPathSum(int [][]x,int m,int n){
		//更新第一行的数据
		for(int i=1;i<n;i++)
			x[0][i] = x[0][i-1]+x[0][i];
		//更新第一列数据
		for(int i=1;i<m;i++)
			x[i][0] = x[i-1][0]+x[i][0];
		
		for(int i=1;i<m;i++)
			for(int j=1;j<n;j++)
				x[i][j] = x[i][j]+x[i][j-1]<x[i][j]+x[i-1][j]?x[i][j]+x[i][j-1]:x[i][j]+x[i-1][j];
	}
}
