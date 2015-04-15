import java.io.*;
import java.util.*;
import java.lang.*;

public class Allocation  {
	
	public static void main(String[] args) throws Exception{
		//Scanners for the HW list, and the TA queries. PrintStream to print to a file.
		Scanner schw = new Scanner(new File("HW_List.txt"));
		PrintStream fout = new PrintStream(new File("HW_Allocation.txt"));
		Scanner scta = new Scanner(new File("TA_Queries.txt"));
		HomeworkQueue homeworkQueue = new HomeworkQueue();
		
		//while loop for HW_List file, will stop when there are no more lines to read in
		while(schw.hasNext()){
			//reading in all the variables in the current line and initializing variables that will be needed later
			Homework tempHomework = null;
			Files tempFile;
			int tempUniqueId = Homework.generateNextUniqueId();
			String tempLast = schw.next();
			String tempFirst = schw.next();
			Name tempName = new Name(tempFirst, tempLast);
			int tempSectionNum = schw.nextInt();
			int tempSubmit = schw.nextInt();
			int tempFileNum = schw.nextInt();
			String[] tempFileArray = new String[tempFileNum];
			
			//if statement creating a homework object if there are no files to read in
			if (tempFileNum == 0) {
				tempFile = new Files();
				tempHomework = new Homework(tempUniqueId, tempName, tempSectionNum, tempFile, tempSubmit);
			}
			
			//if statement reading in the files and then passing that into a Files object to then be passed into a Homework object
			if (tempFileNum != 0) {
				for(int i = 0; i < tempFileNum; i++) {
					tempFileArray[i] = schw.next();
				}
			tempFile = new Files(tempFileArray);
			tempHomework = new Homework(tempUniqueId, tempName, tempSectionNum, tempFile, tempSubmit);
			}
			
			
			boolean tempBool = homeworkQueue.addHomework(tempHomework);
			
			String tempString;
			
			//printing not added if the homework object is already in the queue
			if (tempBool == false) {
				tempString = tempHomework.toString();
				fout.println("Homework " + tempString + " already in queue. Not added.");
			}
			//printing added if it is not already in the queue
			else {
				tempString = tempHomework.toString();
				fout.println("Homework " + tempString + " added to the queue.");
			}
			
			
		}
		
		//printing finished message 
		fout.println("Finished processing homeworks!");
		fout.println();
		
		//while loop for TA_Queries text file, will stop when there are no more lines to go through.
		while (scta.hasNext()) {
			
			//reading in the integers on the current line of the file
			int tempTaId = scta.nextInt();
			int tempTaSection = scta.nextInt();
			int tempNumHw = scta.nextInt();
			boolean tempSectionEmpty = homeworkQueue.sectionIsEmpty(tempTaSection);
			
			//if statement checking if the section is empty, if so, then it prints out nothing found and skips the rest of the loop
				if (tempSectionEmpty == true) {
					fout.println("TA " + tempTaId + " assigned no homeworks. Nothing in the queue for section " + tempTaSection + ".");
					fout.println();
					continue;
				}
				
				//gets to this if the section wasn't empty. Loops through as many times are there are homework assignments requested 
			for (int i = 1; i <= tempNumHw; i++) {
				Homework tempHomework = homeworkQueue.getHomework(tempTaSection);
				
				//prints out what the TA gets assigned during each loop
				fout.println("TA " + tempTaId + " gets assigned homework " +  tempHomework.toString());
				tempSectionEmpty = homeworkQueue.sectionIsEmpty(tempTaSection);
				
				//if the for loop hasn't reached the end and the section is empty it prints how many homeworks were assigned out of how many were requested
					if (i != tempNumHw && tempSectionEmpty == true) {
						fout.println("TA " + tempTaId + " assigned " + i + "/" + tempNumHw + " homework(s) from section " + tempTaSection);
						fout.println();
						break;
					}
					
					//if the for loop has reached the end, it prints out all the number of homeworks were assigned.
					if (i == tempNumHw) {
						fout.println("TA " + tempTaId + " assigned all " + i + " requested homework(s) from section " + tempTaSection);
						fout.println();
						break;
					}
			}
				
				
			
		}
		
		//printing finished message
		fout.println("Finished processing TA Queries! Exiting.");
		
		schw.close();
		scta.close();
		fout.close();
	}

}
