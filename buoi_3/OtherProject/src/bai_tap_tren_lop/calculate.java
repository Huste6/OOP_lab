package bai_tap_tren_lop;

import java.util.Scanner;

public class calculate {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số đầu tiên: ");
		double num1 = sc.nextDouble();
		System.out.println("Nhập số thứ 2: ");
		double num2 = sc.nextDouble();

		System.out.println("Tổng của 2 số: " + (num1 + num2));
		System.out.println("Hiệu của 2 số: " + Math.abs(num1 - num2));
		System.out.println("Tích của 2 số: " + (num1 * num2));
		System.out.println("Thương của 2 số: " + (num1 / num2));
	}
}
