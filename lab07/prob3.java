/*
Konstantin Zelmanovich
CS 265
Lab 7
Problem 3
11/12/2017
*/

public class prob3 {
	public static void main(String[] Args) {
		if ( Args.length < 1 ) {
			System.out.print( "No arguments...\n" );
			System.exit(0);
		}

		int year = Integer.parseInt(Args[0]);

		if ((year%4 == 0 && year%100 != 0) || year%400 == 0) {
			System.out.print("Leap year!\n");
		}

		else {
			System.out.print("Not a leap year!\n");
		}
	}
}

