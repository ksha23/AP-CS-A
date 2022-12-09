import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EPA05 {

	public static void main(String[] args) {
		try {
			File inputFile = new File("data.txt");
			Scanner fileReader = new Scanner(inputFile);
			int number = Integer.parseInt(fileReader.nextLine());
			double currentNum;
			for (int i=0;i<number;i++) {
				String data = fileReader.nextLine();
				String numArr[] = data.split(" ", 0);
				for (int j = 0; j<numArr.length; j++) {
					currentNum = Double.parseDouble(numArr[j]);
					currentNum = currentNum+180;
					if (currentNum>360){
						currentNum = currentNum%360;
						
					}
					System.out.print(String.format("%06.2f",currentNum)+" ");
				}
				System.out.println("");
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

}
