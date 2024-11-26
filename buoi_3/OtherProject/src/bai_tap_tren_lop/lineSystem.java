package bai_tap_tren_lop;

import java.util.Scanner;

public class lineSystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// a11.x + a12.y = b1
		// a21.x + a22.y = b2

		System.out.println("Nhập a11: ");
		double a11 = sc.nextDouble();
		System.out.println("Nhập a12: ");
		double a12 = sc.nextDouble();
		System.out.println("Nhập b1: ");
		double b1 = sc.nextDouble();
		System.out.println("Nhập a21: ");
		double a21 = sc.nextDouble();
		System.out.println("Nhập a22: ");
		double a22 = sc.nextDouble();
		System.out.println("Nhập b2: ");
		double b2 = sc.nextDouble();

		double det = (a11 * a22 - a21 * a12);
		if (det == 0) {
			if (b1 / b2 == a11 / a21) {
				System.out.println("Phương trình vô số nghiệm!");
			} else {
				System.out.println("Phương trình vô nghiệm!");
			}
		} else {
			double x = (b1 * a22 - b2 * a11) / det;
			double y = (a11 * b2 - a21 * b1) / det;

			System.out.println("Nghiệm của hệ phương trình là:");
			System.out.println("x = " + x);
			System.out.println("y = " + y);
		}
	}
}
