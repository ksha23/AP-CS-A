import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EPA03 {
	
	public static int collatz(int n) {
        if (n == 1) {
        	return 0;
        }
        else if (n % 2 == 0) {
        	n = n / 2;
        	return n;
        }
        else {
        	n = (3*n + 1);
        	return n;
		}
	}

	public static void main(String[] args) {
		try {
			File inputFile = new File("data.txt");
			Scanner fileReader = new Scanner(inputFile);
			while (fileReader.hasNextLine()) {
				int sequenceLength = 1;
				String data = fileReader.nextLine(); 
				int currentNum = Integer.parseInt(data);
				System.out.print(currentNum + ":");
				while (currentNum != 1) {
					currentNum = collatz(currentNum);
					sequenceLength++;
				}
				System.out.print(sequenceLength);
				System.out.println(" ");
			}
		fileReader.close();	
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
			
	}

}
