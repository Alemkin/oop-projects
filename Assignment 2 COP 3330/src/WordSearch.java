//Alexander Lemkin
//MWF 2:30 - 3:20PM September 27, 2012
//It's a program, that does a word search from a file.
import java.util.*;
import java.io.*;

public class WordSearch {

	private static int rows;
	private static int columns;
	private static char[][] wordSearch2d;
	private static String searchWord;
	private static boolean flag;
	private static int tempI;
	private static int tempJ;
	
	//method for going through each position around the current letter at i,j 
	public static void wordSearching()  {
		
		for(int i = 0; i < rows; i++) 
            for(int j = 0; j < columns; j++) 
                for(int ij = -1; ij <= 1; ij++) 
                    for(int ji = -1; ji <= 1; ji++) {
                        if(ij != 0 || ji != 0 )
                            directionSolving(i, j, ij, ji);
                    }
		
		
		 
}
		//method to go through the current letter and compare it to the letters of the word we are searching for in each direction
		public static void directionSolving(int i,int j,int ij,int ji)  {
			String searchingWord = "";
			int searchingFind;
			
			 searchingWord += wordSearch2d[i][j];

		        for( int index = i + ij, jdex = j + ji;
		                 index >= 0 && jdex >= 0 && index < rows && jdex < columns;
		                 index += ij, jdex += ji ) {
		        	searchingFind = prefixSearch(searchWord, searchingWord);
		            searchingWord += wordSearch2d[ index ][ jdex ];
		            
		            if(searchingFind == searchWord.length()) {
		            	break;
		            }
		            if(!searchWord.startsWith(searchingWord))	{
		                break;
		        	}

		            if(searchWord.equals(searchingWord)) {
		            	
		            	if( searchWord.length() < 3 )
		                    continue;
		                flag = false;
		                tempI= i;
		                tempJ = j;
		            }
		          		            	
		        }
		        		        
		}
	//method converting prefixSearch from String[], String to String, String
	private static int prefixSearch(String searchWord2,
				String searchingWord) {
			return 0;
		}

	public static void main(String[] args) throws Exception {
		PrintStream fout = new PrintStream(new File("results.txt"));
		Scanner sc = new Scanner(new File("puzzle.txt"));
		//scanning in the rows and columns
		rows = sc.nextInt(); 
		columns = sc.nextInt();
		String[] wordSearch = new String[rows];
		//storing each word into a 1d array
		for(int i=0; i<rows; i++) {
			wordSearch[i] = sc.next();
		}
		//
		wordSearch2d = new char[rows][columns];
		
		int counter = 0;
		//storing each word in the array into a temp word
		for(int i = 0; i< rows; i++) {
			char[] tempWord = new char[columns];
			tempWord = wordSearch[counter].toCharArray();
			
			
		//storing each letter of the temp word into separate spots in a 2d array
			for(int j = 0; j<tempWord.length; j++) {
				wordSearch2d[counter][j] = tempWord[j];
				
			}
				counter++;
		}
		
		int numWords = sc.nextInt();
		//running through the words at the end and storing the word temporarily and calling the wordSearching method to 
		//check the grid for the word and return the position if it was found to be printed out.
		for(int i=0; i < numWords; i++){
			searchWord = sc.next();
			flag = true;
			wordSearching();
			if (flag == false ){
				fout.println(searchWord + " was found at position (" + tempI + "," + tempJ + ")");
			}
			else {
				fout.println(searchWord + " was not found");
			}
		}
		
		sc.close();
		fout.close();
		
		
		
	}
	
}
