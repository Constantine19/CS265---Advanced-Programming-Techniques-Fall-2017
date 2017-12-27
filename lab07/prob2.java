/*
Konstantin Zelmanovich
CS 265
Lab 7
Problem 2
11/12/2017
*/

public class prob2 {
	public static void main( String[] Arg ) {
		if ( Arg.length < 1 ) {
			System.out.print("No arguments...\n");
			System.exit(0);
		}

		int num = Integer.parseInt( Arg[0] );

		if (num % 2 == 0) {
			System.out.print("Even\n");
		}
		else {
			System.out.print("Odd\n");
		}
	}
}

