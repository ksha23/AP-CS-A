/*
EPA02: Pass/Fail
Description/Instructions:
Students stress about their grades. It’s only natural, because grades are important! However, many universities offer the option to take certain classes as pass/fail. Generally speaking, if you get a grade of 70 or above, you pass. Otherwise, you fail.

Your job is to write a program to  read in a list of grades and determine if the student earning that grade passed or failed the class.

Input:
You must read a file titled data.txt will contain one integer on each line denoting a student’s grade.  Each test case will have the following input:
A single integer grade, anywhere between Integer.MIN_VALUE(-2147483648) <= grade <= Integer.MAX_VALUE(2147483647) 
In other words, you must accept all integer values. You don’t have to handle invalid inputs such as doubles, and other junk.

6
0
48
69
70
87
100

Output:
FAIL
FAIL
FAIL
FAIL
PASS
PASS
PASS

*/

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class EPA02 {
	public static void main(String[] args) {
		try {
            //This will try to open the file and if it can't, will go to "catch" if it fails.
			File myObj = new File("data.txt"); // Make file object to open the file
			Scanner myReader = new Scanner(myObj); // Makes a scanner that reads line by line
			while (myReader.hasNextLine()) { // Only run the code between these curly braces if there is a line
				String data = myReader.nextLine(); // Reads a line in as the string, data
				int currentNum = Integer.parseInt(data); // Changes the String data into a int called currentNum.
				if (currentNum<70){
					System.out.println("FAIL");
				}
				else {
					System.out.println("PASS");
				}
			}
			myReader.close(); // Closes the file so it can be used later
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred."); // This is printed if the file was not open.
			e.printStackTrace(); // This helps debug why the file failed to open, if applicable.
		}
	}
}
