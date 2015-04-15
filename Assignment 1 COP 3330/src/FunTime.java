//Alexander Lemkin
//September 7, 2012
//Making integers do different things from a file.

import java.util.*;
import java.io.*;

public class FunTime {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("funtime.txt"));
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		
		if (num1 < num2 && num1 < num3){
			System.out.println(num1);
			if (num2 < num3) {
				System.out.printf("%d ",num2);
				System.out.println(num3);
			}
			else {
				System.out.printf("%d ", num3);
				System.out.println(num2);
			}
		}
		
		else if(num2 < num1 && num2 < num3) {
			System.out.printf("%d ", num2);
			
			if (num1 < num3) {
				System.out.printf("%d ",num1);
				System.out.println(num3);
			}
			else {
				System.out.printf("%d ", num3);
				System.out.println(num1);
			}
		}
		else {
			System.out.printf("%d ", num3);
			
			if (num1 < num2) {
				System.out.printf("%d ",num1);
				System.out.println(num2);
			}
			else {
				System.out.printf("%d ", num2);
				System.out.println(num1);
			}
		}
		
		int plusnum = sc.nextInt();
		int finalnum = sc.nextInt();
		int addnum = 0;
		
		for(int i = plusnum; i<finalnum; i = i+3)
			addnum += i;

		System.out.println(addnum);
		
		int numint = sc.nextInt();
		int evenorodd = 0;
		int in = 0;
		int counteven = 0;
		int countodd = 0;
			for(in=0; in<numint; in++) {
				evenorodd = sc.nextInt();
					if(evenorodd % 2 == 0)
						counteven++;
					else 
						countodd++;
			}
		
		System.out.printf("%d %d\n", counteven, countodd);
		
		int trinum = sc.nextInt();
		int ind = 1;
		int jind = 1;
		int outputtrinum = 0;
		
		for(ind = 1; ind <= trinum; ind++)	{
			for(jind = 1; jind <= ind; jind++)	{
				outputtrinum = outputtrinum + 1;
				System.out.print(outputtrinum);
				System.out.print(" ");
			}
		System.out.println("");
		
		}
		
		int fizzbuzz = sc.nextInt();
		int index = 1;
		
		for(index = 1; index<=fizzbuzz; index++) {
			if(index % 3 == 0 && index % 5 == 0)
				System.out.println("FizzBuzz");
			else if (index % 5 == 0)
				System.out.println("Buzz");
			else if (index % 3 == 0)
				System.out.println("Fizz");
			else
				System.out.printf("%d\n", index);
		}

	}

		
}
