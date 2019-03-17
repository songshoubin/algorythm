package algorythm;

import java.util.Scanner;
import java.math.*;
/**
 * 两个大整数相加
 * @author song
 *
 */
public class BigIntAdd
{
	public static void main(String arg[])
	{
	
	Scanner scan = new Scanner(System.in);
	int T = 0;
	T = scan.nextInt();
	
	BigInteger num1[] = new BigInteger[T];
	BigInteger num2[] = new BigInteger[T];
	BigInteger Sum12[] = new BigInteger[T];

	for ( int i=0 ; i<T ; i++ )
	{
		BigInteger j1 = new BigInteger(scan.next());
		num1[i] = j1;
		BigInteger j2 = new BigInteger(scan.next());
		num2[i] = j2;
		Sum12[i] = num1[i].add(num2[i]);		
	}
	
	for ( int i=0 ; i<T ; i++ )
	{
		System.out.println("Case "+(i+1)+":");
		System.out.println(num1[i]+" + "+num2[i]+" = "+Sum12[i]);
		if (i+1<T)
		{
					System.out.println();
		}
	}
	
	}
}
