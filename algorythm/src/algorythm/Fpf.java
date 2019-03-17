package algorythm;

import java.util.Scanner;
import java.math.*;
/**
 * 分解质因数
 * @author song
 *
 */
public class Fpf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			
			if(isSqr(n))//首先判断它本身，如果是完全平方数就退出
				System.out.println("Yes");
			else{
				int i;
				for(i=2;i<n/2;i++){
					if(n%i==0&&isSqr(i)){
						System.out.println("Yes");
						break;						
					}
				}
				if(i==n/2)
					System.out.println("No");
			}
		}
	}
	
	
	public static boolean isSqr(int n){
		 int a = (int)(Math.sqrt(n) + 0.5);  //四舍五入求整，又学到一招
	     return a * a == n;
	}

}
