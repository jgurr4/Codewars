package codeWarsJava;

public class MultiDimensionArray {
	public static void make() {
		int[][] array1 = { { 2, 22, 33, 12 }, { 14, 23, 44, 10 } };
		int[][] array2 = { { 88, 77, 56, 89 }, { 70, 79, 91, 95 } };

		System.out.println("Col1\tCol2\tCol3\tCol4");
		display(array1);
		display(array2);
	}

	public static void display(int x[][]) {
		for (int row = 0; row < x.length; row++) {
			for (int column = 0; column < x[row].length; column++) {
				System.out.print(x[row][column] + "\t");
			}
			System.out.println();
		}
	}
}
