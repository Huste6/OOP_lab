package buoi_1;

import java.util.Scanner;

public class Add2Matrix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số hàng của ma trận: ");
		int r = sc.nextInt();
		System.out.println("Nhập số cột của ma trận: ");
		int c = sc.nextInt();
		int[][] mtrx1 = new int[r][c];
		int[][] mtrx2 = new int[r][c];
		int[][] tmp = new int[r][c];

		System.out.println("Nhập ma trận 1: ");
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				mtrx1[i][j] = sc.nextInt();
			}
		}

		System.out.println("Nhập ma trận 2: ");
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				mtrx2[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				tmp[i][j] = mtrx1[i][j] + mtrx2[i][j];
			}
		}

		System.out.println("Kết quả của phép cộng 2 ma trận: ");
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(tmp[i][j] + " ");
			}
			System.out.println();
		}
		sc.close();
	}
}
