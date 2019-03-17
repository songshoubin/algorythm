package algorythm;

import java.util.Scanner;
/**
 * 求n个数的最小公倍数
 * @author song
 *
 */
public class Lcm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			Long []num = new Long[n];
			for(int i=0;i<n;i++){
				num[i] = scanner.nextLong();
				if(i!=0){
					num[i]=num[i-1]/gcd(num[i-1],num[i])*num[i];
				}
			}
			System.out.println(num[n-1]);
		}
	}

	public static Long gcd(Long a,Long b){
		if(b==0)
			return a;
		else
			return gcd(b,a%b);
	}
}
