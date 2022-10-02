/*
EPA04: Space Station Repair Lights
Description/Instructions:
You’ve been hired to work on a systems diagnostic unit for the International Space Station.  This unit will monitor four critical systems – a Battery, a Heat Exchanger, a Water Pump, and a Temperature Sensor – to determine if they are working or not.  However, space is at a premium on the ISS, and so you will only have room for two LED lights for the astronauts to see!

Your team has come up with a design that will allow the astronauts to determine which systems, if any, are broken based on the colors of the two LED lights.  Each system you’re monitoring is given a numerical value based on how critical it is to the operation and safety of the station:
Battery: 8
Heat Exchanger: 4
Water Pump: 2
Temperature Sensor: 1

Whenever the unit runs, it will add the values of any broken systems together and light up the LEDs to indicate the resulting number.  Each LED has four states, each representing a number – off (0), red (1), green (2), and blue (3).  The astronauts will multiply the left LED’s value by four, then add it to the right LED’s value, in order to determine the correct error code.  For example, if the left LED is red and the right LED is green, the astronauts would calculate the error code as (1 * 4) + 2 = 6.

HINT: You should use modulo division for this assignment to compute the error code lights.

Your task is to write the logic that controls the LEDs.

Input:
You must read a file titled data.txt will contain one word on each line denoting a part’s status as WORKING or BROKEN in all caps with no spaces.

Output:
Your program should output the length of each sequence in the following format:
leftLightStatus rightLightStatus

*/

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
