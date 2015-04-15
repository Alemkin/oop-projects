//Alexander Lemkin
//Septemper 7, 2012
//Making strings do different things.
import java.util.Scanner;

public class StringFun {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		String word1 = sc.next();
		System.out.println(word1.length());
		
		String word2 = sc.next();
		char word22[] = word2.toCharArray();
		int w2len = word2.length();
		
		int i = 0;
		for(i = 0; i<w2len; i++) {
			if (i % 2 == 0) {
				System.out.printf("%c", word22[i]);
			}
		}
		
		System.out.printf(" ");
		
		for(i = 0; i<w2len; i++) {
			if (i % 2 != 0) {
				System.out.printf("%c", word22[i]);
			}
				
		}
		System.out.printf("\n");
		
		String word3 = sc.next();
		int w3len = word3.length();
		
		for(i = 0; i<w3len; i++) {
			System.out.printf(word3.substring(i,w3len));
			System.out.printf(" ");
		}
		System.out.printf("\n");
		
		String word4 = sc.next();
		String char1 = sc.next();
		String char2 = sc.next();
		
		String word44 = word4.replace(char1, char2);
		System.out.println(word44);
		
		String word5 = sc.next();
		String word55 = sc.next();
		
		   int occurence = 0;
		   int in = 0;

		     while ((in = word5.indexOf(word55, in)) != -1)
		     {
		        in++;
		        occurence++;
		     }

		     System.out.println(occurence);
		     
		int numwrd = sc.nextInt();
		String word6 = sc.next();
		int lex = 0;
			for(i = 0;i < (numwrd-1); i++) {
				String word7 = sc.next();
				lex = word6.compareTo(word7);
					if(lex > 0)
						word6 = word7;
			}
			
			System.out.println(word6);
			
			sc.close();
			
	}
		
		
}

