package com.soft;

import java.util.Scanner;

public class BankController {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		RBI rbi = new SBI();
		boolean flag = true;
		while (flag) {
			System.out.println("SBI_ONLINE_NETBANKING");
			System.out.println("======================================");
			System.out.println("1.For Create Account");
			System.out.println("2.For Delete Customer");
			System.out.println("3.For Update Customer");
			System.out.println("4.For Check Balance");
			System.out.println("5.For Customer Read All Account Record View");
			System.out.println("6.Exit");
			
			System.out.println("======================================");
			System.out.println("Please choose option from Menu");
			int key = sc.nextInt();
			switch (key) {
			case 1:
				rbi.createAccount();
				break;
			case 2:
				rbi.DeleteCustomer();
				break;
			case 3:
				rbi.UpdateCustomer();
				break;
			case 4:
				rbi.checkBalance();
				break;
				
			case 5:
				rbi.ReadAll_Record();
				break;
			default:
				System.out.println("Thank You For Using SBI Online Banking, Vist Again....!!!");
				System.out.println("==============================================================");
				flag=false;
				
			}
		}
	}
}