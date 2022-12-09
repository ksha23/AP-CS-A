import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class EPA07 {
	
	public static char[][] createBoard(int R, int C) {
		char[][] board = new char[R][C];
		for(int h = 0; h<C; h+=2) {
			board[0][h] = 'X';
		}
		for(int i = 1; i<R; i++) {
			for (int j = 0; j<C; j+=2) {
				if (board[i-1][j]=='X') {
					board[i][j+1]='X';
					j++;
				}
				else {
					board[i][j] = 'X';
				}
			}
		}
		return board;
	}
	
	public static void printBoard(char[][] board) {
		for (int i = 0; i<board.length; i++) {
			for (int j = 0; j<board[0].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println("");
		}
	}
	
	public static boolean validMove(int R, int C, int initialX, int initialY, int finalX, int finalY, char[][] board) {
		if (board[initialX][initialY]==board[finalX][finalY]) {
			return true;
		}
			
		return false;
	}
	
	public static void main(String[] args) {
		File inputFile = new File ("data.txt");
		Scanner fileScanner;
		try {
			fileScanner = new Scanner(inputFile);
			String n = fileScanner.nextLine();
			for (int i = 0; i<Integer.parseInt(n); i++) {
				String[] line = fileScanner.nextLine().split(",");				
				int R = Integer.parseInt(line[0]), C = Integer.parseInt(line[1]);
				
				String[] secondLine = fileScanner.nextLine().split(",");				
				int initialX = Integer.parseInt(secondLine[0])-1, initialY = Integer.parseInt(secondLine[1])-1;
				
				String[] thirdLine = fileScanner.nextLine().split(",");				
				int finalX = Integer.parseInt(thirdLine[0])-1, finalY = Integer.parseInt(thirdLine[1])-1;
				
				char[][] board = createBoard(R, C);
				
				if(validMove(R, C, initialX, initialY, finalX, finalY, board)) {
					System.out.println("Yes");
				}
				
				else {
					System.out.println("No");
				}
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
