package bai_tap_tren_lop;

import java.util.Scanner;

public class linearEquation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số a: ");
		int a = sc.nextInt();
		System.out.println("Nhập số b: ");
		int b = sc.nextInt();

		if (a == 0) {
			if (b == 0) {
				System.out.println("Phương trình có vô số nghiệm");
			} else {
				System.out.println("Phương trình vô nghiệm");
			}
		} else {
			double x = -b / a;
			System.out.println("Nghiệm của phương trình là: " + x);
		}
	}
}
