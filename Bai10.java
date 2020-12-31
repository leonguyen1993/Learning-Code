import java.util.Scanner;

public class Bai10 {
	/*
	 * LIỆT KÊ CÁC DÒNG CÓ CHỨA GIÁ TRỊ ÂM TRONG MA TRẬN TỪ -50 TO 50. Loop throgh
	 * each row and col. If a[i][j] < 0 then print out else keep looping until the
	 * end and return false if no negative numbers.
	 */
	public static final int MIN = -50;
	public static final int MAX = 50;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int row = inputRL(scan, true);
		int col = inputRL(scan, false);
		int a[][] = inputAuto(scan, row, col);
		printOutArray(a, row, col);
		isNegativeLine(a, row, col);
	}

	public static int inputRL(Scanner scan, boolean isRow) {
		int n;
		do {
			if (isRow) {
				System.out.println("Please input number of row > 0");
			} else {
				System.out.println("Please input number of column > 0");
			}
			n = Integer.parseInt(scan.nextLine());
		} while (n < 1);
		return n;
	}

	public static int[][] inputAuto(Scanner scan, int row, int col) {
		int a[][] = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				a[i][j] = MIN + (int) (Math.random() * ((MAX - MIN) + 1));
			}
		}
		return a;
	}

	public static int[][] inputManual(Scanner scan, int row, int col) {
		int a[][] = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.println("a[" + i + "][" + j + "]= ");
				a[i][j] = Integer.parseInt(scan.nextLine());
			}
		}
		return a;
	}

	public static void printOutArray(int a[][], int row, int col) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.print("\n");
		}

	}

	public static void printNegativeLine(int a[][], int row, int col) {

		for (int j = 0; j < col; j++) {
			System.out.print(a[row][j] + "\t");
		}
		System.out.print("\n");
	}

	public static void isNegativeLine(int a[][], int row, int col) {
		boolean flag = false;
		System.out.println("Line including negative number :");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (a[i][j] < 0) {
					printNegativeLine(a, i, col);
					flag = true;
					break;
				}
			}
		}
		if (!flag) {
			System.out.println("There Is No Negative Numbers Found");
		}
	}
}
