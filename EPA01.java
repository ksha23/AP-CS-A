import java.util.Scanner;

public class EPA01 {
	static double[] getResult() {
		Scanner velocityScanner = new Scanner(System.in);
		System.out.print("Enter velocity: ");
		double velocity = velocityScanner.nextDouble();
		
		Scanner accelerationScanner = new Scanner(System.in);
		System.out.print("Enter acceleration: ");
		double acceleration = accelerationScanner.nextDouble();

		Scanner timeScanner = new Scanner(System.in);
		System.out.print("Enter time: ");
		double time = timeScanner.nextDouble();

		double output = velocity*time + 0.5*(acceleration*(time*time));
		
		double[] result = {velocity, acceleration, time, output};
		return result;
		}
	
	static boolean validInput(double[] arr) {
		boolean validInput = false;
		for (int i = 0; i < (arr.length)-1; i++) {
			if (arr[i] >= -100 && arr[i]<=100) {
				validInput = true;
			}
			else {
				validInput = false;
				break;
			}
		}
		return validInput;
	}

	public static void main(String[] args) {
		boolean validInput;
		double[] output = getResult();
		validInput = validInput(output);
		if (validInput) {
			System.out.println("Distance was " + output[3]);
		}	
		else {
			System.out.println("ERROR");
		}
		
	}

}
