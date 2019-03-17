package algorythm;

import java.util.Scanner;

public class Crawl {
/**
 * 爬台阶
 * @param args
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		while(n-->0){
			int m = scanner.nextInt();
			System.out.println(JumpFloor(m));
		}
	}
	public static int JumpFloor(int target) {
        if(target==2)
            return 1;
        if(target==3)
            return 2;
        
            return JumpFloor(target-1)+JumpFloor(target-2);
    }

}
