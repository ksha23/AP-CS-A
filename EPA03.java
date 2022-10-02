/*
EPA03: Collatz Conjecture
Description/Instructions:
Can you believe that there are some math problems that still remain unsolved today?  The Collatz Conjecture is one such problem.

To create a Collatz Sequence, start with any positive integer n.  Each term in the sequence is derived from the previous term using the following rules: if the previous term is even, then the next term is one half the previous term.  Otherwise, the next term is 3 times the previous term plus 1.  The Collatz Conjecture states that no matter what value you pick for n, the series will eventually reach the number 1.

For example, if we start with the number 12, it is even, so the next term is 6.  That is also even, so the next term is 3.  Three is odd, so the term after that would be 10 and so on.  The full sequence is:

12, 6, 3, 10, 5, 16, 8, 4, 2, 1

So, starting with 12, the sequence length is 10.  Your task is to write a program that will provide the length of a Collatz Sequence starting from a given number.

Input:
You must read a file titled data.txt will contain one integer on each line denoting a student’s grade.  Each test case will have the following input:
A single integer, anywhere between 1 <= grade <= Integer.MAX_VALUE(2147483647) 
In other words, you must accept all integer values greater than or equal to 1. You don’t have to handle invalid inputs such as doubles, and other junk.

Output:
Your program should output the length of each sequence in the following format:
<Start Number>:<Sequence Length>
*/

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
