package buoi_1;

import java.util.Scanner;

public class DisplayDaysOfMonth {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int month = 0;

		while (month == 0) {
			System.out.println("Nhập vào tháng: ");
			String monthInput = sc.nextLine();

			switch (monthInput) {
			case "Jan":
			case "Jan.":
			case "January":
			case "1":
				month = 1;
				break;
			case "Feb":
			case "Feb.":
			case "February":
			case "2":
				month = 2;
				break;
			case "Mar":
			case "Mar.":
			case "March":
			case "3":
				month = 3;
				break;
			case "Apr":
			case "Apr.":
			case "April":
			case "4":
				month = 4;
				break;
			case "May":
			case "May.":
			case "5":
				month = 5;
				break;
			case "Jun":
			case "Jun.":
			case "June":
			case "6":
				month = 6;
				break;
			case "Jul":
			case "Jul.":
			case "July":
			case "7":
				month = 7;
				break;
			case "Aug":
			case "Aug.":
			case "August":
			case "8":
				month = 8;
				break;
			case "Sep":
			case "Sep.":
			case "September":
			case "9":
				month = 9;
				break;
			case "Oct":
			case "Oct.":
			case "October":
			case "10":
				month = 10;
				break;
			case "Nov":
			case "Nov.":
			case "November":
			case "11":
				month = 11;
				break;
			case "Dec":
			case "Dec.":
			case "December":
			case "12":
				month = 12;
				break;
			default:
				System.out.println("Tháng không hợp lệ, vui lòng nhập lại.");
			}
		}

		System.out.println("Nhập vào năm: ");
		int year = sc.nextInt();
		int day;

		if (year % 4 == 0) {
			day = (month == 2) ? 29 : ((month == 4 || month == 6 || month == 9 || month == 11) ? 30 : 31);
		} else {
			day = (month == 2) ? 28 : ((month == 4 || month == 6 || month == 9 || month == 11) ? 30 : 31);
		}

		System.out.println("Số ngày trong tháng " + month + " là: " + day);
		sc.close();
	}
}