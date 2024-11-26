package buoi_1;

import java.util.Scanner;

public class array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter array: ");
		String arr = sc.nextLine();
		// arr : 1 2 3 4 5 6 7 8
		String[] arrStr = arr.split(" ");
		int[] arrInt = new int[arrStr.length];

		for (int i = 0; i < arrStr.length; i++) {
			arrInt[i] = Integer.valueOf(arrStr[i]);
		}
		for (int i = 0; i < arrInt.length - 1; i++) {
			for (int j = 0; j < arrInt.length - 1 - i; j++) {
				if (arrInt[j + 1] < arrInt[j]) {
					int tmp = arrInt[j];
					arrInt[j] = arrInt[j + 1];
					arrInt[j + 1] = tmp;
				}
			}
		}
		System.out.println("Array after sort: ");
		for (int i = 0; i < arrInt.length; i++) {
			System.out.print(arrInt[i] + " ");
		}
		System.out.println("\n");
//		System.out.print("\nInteger array : " + Arrays.toString(arrInt));

		int sum_1 = 0;

		for (int i = 0; i < arrInt.length; i++) {
			sum_1 += arrInt[i];
		}
		float average = sum_1 / arrInt.length;
		System.out.println("Tổng mảng: " + sum_1);
		System.out.println("Trung binh mảng: " + average);
	}
}
