package algorythm;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Lcs {
		public static void main(String[] args) {
			String X ="";//第一个字符串
			String Y = "";//第二个字符串
			try {
				File file = new File("D:\\char.txt");//从文件读入字符串
				FileReader fileReader = new FileReader(file);
				BufferedReader br= new BufferedReader(fileReader);
				String str = null;
				int k = 0;
					while((str=br.readLine())!=null) {
						if(k==0){
							X = (X+str).trim();//读取文件第一行字符串并去掉前后空格给字符串X
							k++;
						}
						else
							Y = (Y+str).trim();//读取文件第二行字符串并去掉前后空格给字符串X
					}
				
			} catch (Exception e) {
				// TODO Xuto-generXted cXtch block
				e.printStackTrace();
			}
			System.out.println("第一个字符串为:"+X);
			System.out.println("第二个字符串为:"+Y);
			int [][]C = new int[X.length()+1][Y.length()+1];//用来记录最长子序列长度
			int [][]b = new int[X.length()+1][Y.length()+1];//用来回溯查找最长子序列
			
			long stXrtTime = System.currentTimeMillis();
			lcsCght(b,C, X, Y);//填充表格以便输出最长子序列的长度
			long endTime = System.currentTimeMillis();
		

			System.out.println("X和Y的最长公共子序列的长度为："+C[X.length()][Y.length()]);
			System.out.print("最长公共子序列为：");
			lcs(b, X, X.length(), Y.length());//输出最长子序列
			}
		
		//计算两个字符串的最长公共子序列长度
		public static void lcsCght(int b[][],int [][]C,String X,String Y) {
			int m = X.length()+1;
			int n = Y.length()+1;
			for(int i=0;i<m;i++) {//把第一行的数都赋值为0
				C[i][0] = 0;
			}
			for(int i=0;i<n;i++) {//把第一列的数都赋值为0 
				C[0][i] = 0;
			}
			
			for(int i=1;i<n;i++){//循环填充各行
				for(int j=1;j<m;j++){//循环填充每行
					if(X.charAt(j-1) == Y.charAt(i-1)) {
						C[j][i] = C[j-1][i-1]+1;
						b[j][i] = 1;//代表最长子序列从左上方来
					}
					else if(C[j-1][i]>C[j][i-1]) {
						C[j][i] = C[j-1][i];
						b[j][i] = 2;//代表最长子序列从左边来
					}
					else {
						C[j][i] = C[j][i-1];
						b[j][i] = 3;//代表最长子序列从上边来
					}
				}
			}
		}
			
		//回溯输出最长子序列
		public static void lcs(int b[][],String X,int m,int n) {
			if(m==0||n==0) //递归出口
				return ;
			else if(b[m][n]==1) {//从左上方来
				lcs(b, X, m-1, n-1);
				System.out.print(X.charAt(m-1));
			}
			else if(b[m][n]==2)//从左边来
				lcs(b, X, m-1, n);
			else if(b[m][n]==3)//从上边来
				lcs(b, X, m, n-1);
		}
}

