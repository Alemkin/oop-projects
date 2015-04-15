import java.lang.*;
import java.util.*;

public class Name implements Comparable<Name>  {

	public String firstName;
	public String lastName;
	
	//Takes in names first and last and returns them with the first letters capitalized and the rest in lowercase
	Name(String first, String last) {
		String tempString = "";
		String finalFirst = "";
		String finalLast = "";
		
		
		tempString += first.charAt(0);
		String superTemp = tempString.toUpperCase();
		finalFirst += superTemp;
		tempString = "";
		tempString += last.charAt(0);
		superTemp = tempString.toUpperCase();
		finalLast += superTemp;
		tempString = "";
			
		for (int i = 1; i < first.length(); i++) {
			tempString += first.charAt(i);
			
			superTemp = tempString.toLowerCase();
			finalFirst += superTemp;
			tempString = "";
		
		}
		for (int i = 1; i < last.length(); i++) {
			tempString += last.charAt(i);
			
				superTemp = tempString.toLowerCase();
				finalLast += superTemp;
				tempString = "";
			
		}
				
			firstName = finalFirst;
			lastName = finalLast;
	}
	//returns a string in the format of first name space last name
	public String toString() {
		String tempString = firstName + " " + lastName;
		return tempString;
	}
	//compares names starting with last and then first if the last are equal.
	public int compareTo(Name other) {
		int c = lastName.compareTo(other.lastName);
			if(c == 0)	{
				c = firstName.compareTo(other.firstName);
				return c;
			}
		return c;
		}
	
	//checks first and last name and returns true if both match, else returns false
	public boolean equals(Name other) {
		
		if (firstName.equals(other.firstName)) 
			if (lastName.equals(other.lastName)) 
				return true;
			else
				return false;
			
		return false;
		
		
	}
}
