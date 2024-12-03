package bai_tap_tren_lop;

import java.util.Scanner;

public class secondDegreeEquation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Nhập a: ");
		double a = sc.nextDouble();
		System.out.println("Nhập b: ");
		double b = sc.nextDouble();
		System.out.println("Nhập c: ");
		double c = sc.nextDouble();

		double dt = b * b - 4 * a * c;

		if (dt > 0) {
			double x1 = (-b + Math.sqrt(dt)) / (2 * a);
			double x2 = (-b - Math.sqrt(dt)) / (2 * a);
			System.out.println("Nghiệm của phương trình là:");
			System.out.println("x1 = " + x1);
			System.out.println("x2 = " + x2);
		} else if (dt == 0) {
			double x = -b / (2 * a);
			System.out.println("Phương trình có nghiệm kép:");
			System.out.println("x = " + x);
		} else {
			double thuc = -b / (2 * a);
			double i = Math.sqrt(-dt) / (2 * a);
			System.out.println("Phương trình có nghiệm phức:");
			System.out.println("x1 = " + thuc + " + " + i + "i");
			System.out.println("x2 = " + thuc + " - " + i + "i");
		}

	}
}
