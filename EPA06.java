import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/*1.	Always put the bigger number as the minuend and the smaller number as the subtrahend.  
 * If they are equal, then their value is the GCD.  If they are both 1, the numbers are coprime.
2.	Subtract to obtain the difference between the two.
3.	Use the subtrahend and the difference as the two numbers in the next iteration.
*/

public class EPA06 {
	public static void euclid(int num1, int num2) {
		if (num1==num2 && num1 == 1) {
			System.out.println(num1+"-"+num2+"=0");
			System.out.println("COPRIME");
		}
		else if (num1 == num2) {
			System.out.println(num1+"-"+num2+"=0");
			System.out.println("NOT COPRIME");
		}
		
		else {
			if (num1 > num2) {
				int difference = num1-num2;
				System.out.println(num1+"-"+num2+"="+difference);
				euclid(num2, difference);
			}
			else {
				int difference = num2-num1;
				System.out.println(num2+"-"+num1+"="+difference);
				euclid(num1, difference);
			}		
		}
	}

	public static void main(String[] args) {
		try {
			File myFile = new File("data.txt");
			Scanner fileReader = new Scanner(myFile);
			String numberOfLines = fileReader.nextLine();
			int n = Integer.parseInt(numberOfLines);
			for (int i = 0; i<n; i++) {
				String newLine = fileReader.nextLine();
				String[] numbers = newLine.split(",");
				euclid(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]));
			}
			fileReader.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
