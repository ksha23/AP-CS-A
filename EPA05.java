import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class EPA04 {

	public static void main(String[] args) {
		String[] inputArr = new String[4];
		String[] lightArr = new String[]{ "off", "off" };
		String[] colorArr = new String[4];
		
		colorArr[0] = "off";
		colorArr[1] = "red";
		colorArr[2] = "green";
		colorArr[3] = "blue";
		
		try {
			File inputFile = new File("data.txt");
			Scanner fileReader = new Scanner(inputFile);
			int index = 0;
			while (fileReader.hasNextLine()) {
				String data = fileReader.nextLine();
				data.trim();
				inputArr[index] = data;
				index++;
			}
		fileReader.close();	
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		int errorCode = 0;

		if (inputArr[0].equals("BROKEN")) {
			errorCode += 8;
		}
		if (inputArr[1].equals("BROKEN")) {
			errorCode += 4;
		}
		if (inputArr[2].equals("BROKEN")) {
			errorCode += 2;
		}
		if (inputArr[3].equals("BROKEN")) {
			errorCode += 1;
		}
								
		if (errorCode != 0) {
			for (int i = 0; i<colorArr.length; i++) {
				for (int j = 0; j<colorArr.length; j++) {
					if (((i)*4 + (j)) == errorCode) {
						lightArr[0] = colorArr[i];
						lightArr[1] = colorArr[j];
					}
				}
			}
		}
		System.out.println(lightArr[0]+" "+lightArr[1]);

	}

}
