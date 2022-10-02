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
