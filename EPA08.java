import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EPA08 {
	
	public static boolean determiner (int tolerance, int[] foreground, int[] chroma) {
		double value = Math.sqrt(Math.pow((foreground[0]-chroma[0]), 2) + Math.pow((foreground[1]-chroma[1]), 2) + Math.pow((foreground[2]-chroma[2]), 2));
		if (value <= tolerance) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		File inputFile = new File("data.txt");
		try {
			Scanner fileScanner = new Scanner(inputFile);
			int n = Integer.parseInt(fileScanner.nextLine());
			for (int i = 0; i<n; i++) {
				String currentLine = fileScanner.nextLine();
				String[] stringNumberList = currentLine.split(" ");
				int[] numberList = new int[stringNumberList.length];
				for (int j = 0; j<stringNumberList.length; j++) {
					numberList[j] = Integer.parseInt(stringNumberList[j]);
				}
				int[] chromaKey = new int[] {numberList[0], numberList[1], numberList [2]};
				int tolerance = numberList[3];
				int[] foreGround = new int[] {numberList[4], numberList[5], numberList [6]};
				int[] backGround = new int[] {numberList[7], numberList[8], numberList [9]};
				if (determiner(tolerance, foreGround, chromaKey)) {
					for (int k: backGround) {
						System.out.print(k + " ");
					}
				}
				else {
					for (int l: foreGround) {
						System.out.print(l + " ");
					}
				}
				System.out.println("");
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Error, File not found");
			e.printStackTrace();
		}
	}

}
