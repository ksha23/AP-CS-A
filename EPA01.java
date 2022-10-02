/*
EPA01: How Far Will You Go?
Description/Instructions:
In winter, the fjords of Erindale freeze over and the contestants prepare for the annual ice rocket contest. The goal of the contest is to launch a two-stage model rocket across the ice so that it stops as close as possible to the goal line without touching or passing over it. The winner gets to ride a reindeer in the winter parade. Every year the exact distance from the starting line to the goal is kept a secret until a week before the contest. To win, contestants must do some math to determine the optimal thrust for their rockets. One of the equations they use is a simple distance calculation:

	d = vt + (1/2)(at^2)

Using this formula, a contestant can determine the distance d a rocket will travel for a number of seconds t, given an initial velocity v and acceleration a.

Input:
You must ask the user EXACTLY the following questions with input on the same line:

Enter velocity: 
Enter acceleration: 
Enter time: 

The values must be in the range of -100 to 100, inclusive.

Output:
Below is sample output in your program (note that those numbers were typed and the “enter” key was pressed, thus making a new line):

Enter velocity: 14.46
Enter acceleration: -1.38
Enter time: 8.7
Distance was 73.5759

Note that there is no need to round any numbers.
If the number was too large or too negative, you should print “ERROR” on the last line instead of the number like the example below.

Enter velocity: 101
Enter acceleration: 5
Enter time: 8
ERROR

*/

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
