import java.lang.*;
import java.util.*;

public class Homework implements Comparable<Homework>{
	
	//variables to be used in the whole class Homework
	public static int nextAvailableUid = 1;
	public int identification;
	public Name newName;
	public int sectionNum;
	public Files newFile;
	public int submitDate;
	public String firstName;
	public String lastName;
	public final int DUE_DATE = 15;
	
	//constructor that I am using
	public Homework(int id,
            Name name,
            int section,
            Files files,
            int dateSubmitted) {
		identification = id;
		newName = name;
		sectionNum = section;
		newFile = files;
		submitDate = dateSubmitted;
		
	}
	//another constructor
	public Homework(int id,
            Name name,
            int section,
            int dateSubmitted) {
		identification = id;
		newName = name;
		sectionNum = section; 
		submitDate = dateSubmitted;
		Files newFile = new Files();
	}
	//another constructor
	public Homework(String first,
            String last,
            int section,
            int dateSubmitted) {
		sectionNum = section;
		submitDate = dateSubmitted;
		newName = new Name(first, last);
		Files newFile = new Files();
		identification = generateNextUniqueId();
	}
	//implemented compareTo method checking submit date, files and student name to see if the homeworks are different or not.
	public int compareTo(Homework other) {
		int c = submitDate - other.submitDate;
		int c2 = newFile.compareTo(other.newFile);
		int c3 = newName.compareTo(other.newName);

		if (c == 0 && c2 == 0 && c3 != 0)
			return c3;
		else if (c == 0 && c2 != 0 && c3 == 0)
			return c2;
		else if (c != 0 && c2 == 0 && c3 == 0)
			return c;
		else if (c == 0 && c2 != 0 && c3 != 0)
			return c2;
		else if (c !=0 && c2 != 0 && c3 == 0)
			return c;
		else if (c != 0 && c2 == 0 && c3 != 0)
			return c;
		else if (c != 0 && c2 != 0 && c3 != 0)
			return c;
		else
			return c3;
		
	
	}
	//generating the next unique ids for the homework assignments
	public static int generateNextUniqueId() {
		int tempInt2 = nextAvailableUid;
		nextAvailableUid++;
		return tempInt2;
	}
	
	public int getDaysLate() {
		int tempInt = DUE_DATE - submitDate;
		
		return tempInt;
	}
	
	public Files getFiles() {
		return newFile;
	}
	
	public int getId() {
		return identification;
	}
	
	public Name getName() {
		return newName;
	}
	
	public int getSection() {
		return sectionNum;
	}
	//returns a string including everything in the homework
	public String toString() {
		int tempInt = newFile.getNumberOfFile();
		int lateDays = getDaysLate();
		String daysLateString;
		String tempString;
		//returns days late plus the integer unmodified if turned in after due date
		if (lateDays < 0) {
			daysLateString = "day(s) late";
			tempString = getId() + ": " + tempInt + " file(s) " + newFile.toString() + " submitted by " + newName.toString() + " " + getDaysLate()*-1
			+ " " + daysLateString + " for section " + getSection();
			return tempString;
		}
		//returns days early with integer made positive if turned in before due date
			else if(lateDays > 0) {
			daysLateString = "day(s) early";
			tempString = getId() + ": " + tempInt + " file(s) " + newFile.toString() + " submitted by " + newName.toString() + " " + getDaysLate() + " "
			+ daysLateString + " for section " + getSection();
			return tempString;
		}
		//returns on time if turned in on due date
			else {
				daysLateString = "on time";
				tempString = getId() + ": " + tempInt + " file(s) " + newFile.toString() + " submitted by " + newName.toString() + " " + daysLateString
				+ " for section " + getSection(); 
				return tempString;
			}
			
	
	}
}
