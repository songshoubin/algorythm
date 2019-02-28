package algorythm;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.util.Scanner;
public class MaxSum {
	public static int besti;
	public static int bestj;
	public static int besti1;
	public static int bestj1;
	public static int besti2;
	public static int bestj2;
	static int arr[] = null;//定义一个数组，用来存储一串数字
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个整数代表你要生成整数的个数：");
		int count = scanner.nextInt();
		arr = new int[count];
		Random random = new Random();
		File file = new File("E://test.txt");//打开文件
		BufferedWriter writer = null;
		
		//随机生成count个数字存储到文件中
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
			String s = "";
			for(int i=0;i<count;i++){
				int rand = random.nextInt(100)+1;
				rand -= 50;
				s += rand+",";
			}
			s = s.substring(0, s.length()-1);
			writer.write(s);
			writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//读取文件数字存储到数组中
		BufferedReader reader = null;//数据流
		String str;
		String arrs[];
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			int temp = 0;//中间指针
			while((str=reader.readLine())!=null){
				str = str.replace(" ", "");//去掉字符串中所有空格
				arrs = str.split(",");//用,来分割字符串
				for(int i=temp;i<(arrs.length+temp);i++){
					arr[i] = Integer.parseInt(arrs[i-temp]);//将每个字符转换为整型
				}
				temp +=arrs.length;//中间指针加上当前行字符串长度
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("-----------暴力解法-----------");
		long startTime1 = System.currentTimeMillis();
		int maxSum = maxSum(arr);
		long endTime1 = System.currentTimeMillis();
		System.out.println("当前算法所用时间为："+(endTime1-startTime1)+"ms");
		System.out.println("最大子段和为："+maxSum);
		System.out.println("最大子段和开始下标为："+besti);
		System.out.println("最大子段和结束下标为："+bestj);	
		
		System.out.println("-----------分治思想解法-----------");
		long startTime2 = System.currentTimeMillis();
		int maxSum1 = divideMaxSubSum(0, arr.length-1);
		long endTime2 = System.currentTimeMillis();
		System.out.println("当前算法所用时间为："+(endTime2-startTime2)+"ms");
		System.out.println("最大子段和为："+maxSum1);
		System.out.println("最大子段和开始下标为："+besti);
		System.out.println("最大子段和结束下标为："+bestj);
		System.out.println("-----------动态规划解法-----------");
		long startTime3 = System.currentTimeMillis();
		int maxSum2 = dpSum();
		long endTime3 = System.currentTimeMillis();
		System.out.println("当前算法所用时间为："+(endTime3-startTime3)+"ms");
		System.out.println("最大子段和为："+maxSum2);
		System.out.println("最大子段和开始下标为："+besti2);
		System.out.println("最大子段和结束下标为："+bestj2);
	}

	//普通算法
	public static int maxSum(int arr[]){
		int maxSum= 0;
		for(int i=0;i<arr.length;i++){
			int sum = 0;
			for(int j=i;j<arr.length;j++){
				sum += arr[j];
				if(sum>maxSum){
					maxSum = sum;
					besti = i;
					bestj = j;
				}
			}
		}
		return maxSum;
	}
	
	//分治算法
	public static int divideMaxSubSum(int left ,int right) {
		int sum = 0;
		if(left == right)
			sum = arr[left]>0?arr[left]:0;
			else{
				int center = (left+right)/2;
				int leftSum = divideMaxSubSum(left, center);//对左半部分求最大子段和
				int rightSum = divideMaxSubSum(center+1, right);//对右半部分求最大子段和
				//如果最大子段和在中间
				int s1 = 0;
				int lefts = 0;
				for(int i=center;i>=left;i--){//从中间求最大子段和的左边坐标
					lefts += arr[i];
					if(lefts>s1){
						s1 = lefts;
						besti1 = i;
					}
				}
				int s2 = 0;
				int rights = 0;
				for(int i=center+1;i<=right;i++){//从中间求最大子段和的右边坐标
					rights += arr[i];
					if(rights>s2){
						s2 = rights;
						bestj1 = i;
					}
				}
				sum = s1+s2;
				if(sum<leftSum)
					sum = leftSum;
				if(sum<rightSum)
					sum = rightSum;
				
			}
		return sum;
	}
	//动态规划
	public static int dpSum(){
		int n = arr.length-1;
		int sum = 0,b=0;
		int temp = 0;
		for(int i=0;i<=n;i++){
			if(b>0){
				b +=arr[i];//大于0一直累加
			}
			else {
				b = arr[i];//累加和小于0，重新开始
				temp = i;
			}
			if(b>sum){
				sum = b;//通过比较更新最大子段和
				bestj2 = i;
				besti2 = temp;
			}
		}
		return sum;
	}
}