package buoi_1;

import java.util.Scanner;

public class triangle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Nhap n: ");
		int n = sc.nextInt();

		// i = 1 => 4 cach 1 * 4 cach
		// i = 2 => 3 cach 3 * 3 cach
		// i = 3 => 2 cach 5 * 2 cach

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= 2 * i - 1; k++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}
}

//package Ex_Homework;
//import java.util.Scanner;
//public class DisplayTriangle {
//  public static void main(String[] args){
//      Scanner sc = new Scanner(System.in);
//
//      System.out.print("Input n: ");
//      int n = sc.nextInt();
//
//      for (int i=n;i>=1;i--){
//          for (int j=0;j<=i-1;j++){   //Vòng lặp in số khoảng trắng
//              System.out.print(" ");
//          }
//          for (int k=1 ; k<= 2*(n-i) + 1 ; k++){  //Vòng lặp in sao
//              System.out.print("*");
//          }
//          System.out.print("\n"); //Xuống dòng
//      }
//  }
//}