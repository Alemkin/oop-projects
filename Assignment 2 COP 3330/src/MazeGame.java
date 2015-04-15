//Alexander Lemkin
//MWF 2:30-3:20PM September 27, 2012
//It is a game, of going through a maze.

import java.util.*;
import java.io.*;

public class MazeGame {
	
	
	public static void main(String[] args) throws Exception{
		//scanners for user input and file input
		Scanner scui = new Scanner(System.in);
		Scanner sc = new Scanner(new File("maze.txt"));
		boolean flag = true;
		//scanning the the first two ints for rows and columns in the file
		int rows = sc.nextInt(); 
		int columns = sc.nextInt();
		String[] singleWords = new String[rows];
		//storing all the lines into a 1d array
		for(int i=0; i<rows; i++) {
			singleWords[i] = sc.next();
		}
		
		char[][] mazeWord2d = new char[rows][columns];
		
		int counter = 0;
		int tempRow = 0;
		int tempColumn = 0;
		
		//storing each words in the array into a temporary char array using toCharArray
		for(int i = 0; i< rows; i++) {
			char[] tempWord = new char[columns];
			tempWord = singleWords[counter].toCharArray();
			//nested for loop to store the string I saved as an array into the 2d array I made
			for(int j = 0; j<tempWord.length; j++) {
				mazeWord2d[counter][j] = tempWord[j];
				String tempString = "";
				tempString += mazeWord2d[counter][j];
				String p = "P";
				if(tempString.compareTo(p) == 0) {
					tempRow = counter;
					tempColumn = j;
				}
					
			}
				
				counter++;
		}
		//while loop starting by printing the maze
		while (flag) {
			for (int i=0; i < rows; i++){
				for (int j = 0; j<columns; j++){
					System.out.print(mazeWord2d[i][j]);
				}
				System.out.println();
			}
			//printing the menu
			System.out.println("You may: \n1) Move up\n2) Move down\n3) Move left\n4) Move right\n0) Quit");
			System.out.printf("Your choice (0-4):");
			int userInput = scui.nextInt();
			//switch statement for each menu choice
			switch (userInput) {
				case 0:
					System.exit(0);
				case 1:
					if(tempRow-1 < 0 ){
						System.out.println("Cannot move past cave boundary! Try something else.");
						break;
					}
					if(mazeWord2d[tempRow-1][tempColumn] == 'X' ) {
						System.out.println("Cannot move into cave-in! Try something else.");
						break;
					}
					if(mazeWord2d[tempRow-1][tempColumn] == '.'){
						mazeWord2d[tempRow-1][tempColumn] = 'P';
						mazeWord2d[tempRow][tempColumn] = '.';
						tempRow = tempRow-1;
						break;
					}
					else {
						System.out.println("Congratulations, you found the treasure!");
						System.exit(0);
					}
						break;
				case 2:
					if(tempRow+1 >= rows ){
						System.out.println("Cannot move past cave boundary! Try something else.");
						break;
					}
					if(mazeWord2d[tempRow+1][tempColumn] == 'X' ) {
						System.out.println("Cannot move into cave-in! Try something else.");
						break;
					}
					if(mazeWord2d[tempRow+1][tempColumn] == '.'){
						mazeWord2d[tempRow+1][tempColumn] = 'P';
						mazeWord2d[tempRow][tempColumn] = '.';
						tempRow = tempRow+1;
						break;
					}
					else {
						System.out.println("Congratulations, you found the treasure!");
						System.exit(0);
					}
						break;
				case 3:
					if(tempColumn-1 < 0 ){
						System.out.println("Cannot move past cave boundary! Try something else.");
						break;
					}
					if(mazeWord2d[tempRow][tempColumn-1] == 'X' ) {
						System.out.println("Cannot move into cave-in! Try something else.");
						break;
					}
					if(mazeWord2d[tempRow][tempColumn-1] == '.'){
						mazeWord2d[tempRow][tempColumn-1] = 'P';
						mazeWord2d[tempRow][tempColumn] = '.';
						tempColumn = tempColumn-1;
						break;
					}
					else {
						System.out.println("Congratulations, you found the treasure!");
						System.exit(0);
					}
						break;
				case 4:
					if(tempColumn+1 >= columns ){
						System.out.println("Cannot move past cave boundary! Try something else.");
						break;
					}
					if(mazeWord2d[tempRow][tempColumn+1] == 'X' ) {
						System.out.println("Cannot move into cave-in! Try something else.");
						break;
					}
					if(mazeWord2d[tempRow][tempColumn+1] == '.'){
						mazeWord2d[tempRow][tempColumn+1] = 'P';
						mazeWord2d[tempRow][tempColumn] = '.';
						tempColumn = tempColumn+1;
						break;
					}
					else {
						System.out.println("Congratulations, you found the treasure!");
						System.exit(0);
					}
						break;
			}
		}
		scui.close();
		sc.close();

	}

}
