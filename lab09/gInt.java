/**
 * Konstantin Zelmanovich
 * CS 265
 * Lab 9
 * 12/03/2017
 * java version "1.8.0_144" on tux4.cs.drexel.edu
 * This program provides the ability to parse, add, multiply and find the normal of gaussian integers
 */

import java.io.*;

public class gInt 
{
	int a=0;
	int b=0;
	
	// real
	public gInt(int r){
		a = r;
	}
	
	// both constructor
	public gInt(int r, int i){
		a = r;
		b = i;
	}
	
	// real Gaussian integer
	public int real(){
		return a;
	}
	
	// imaginary Gaussian integer
	public int imag(){
		return b;
	}
	
	// Add
	public gInt add(gInt rhs) {
		gInt added = new gInt((a + rhs.real()),(b + rhs.imag()));
		return added; 
	}
	
	// Multiply
	public gInt multiply(gInt rhs) {
		
		// (ac-bd)+(ad+bC)i
		gInt multiplied = new gInt((a*rhs.real())-(b*rhs.imag()),(a*rhs.imag())+(b*rhs.real()));
		return multiplied; 
	}
	
	// Calculate normal of Gaussian Integer
	public float norm() {
		return ((a*a)+(b*b));
	}

	public static void main(String arg[]) {
		gInt first = new gInt(2,3);
		gInt second = new gInt(4,5);
		gInt added = null;
		added = first.add(second);
		System.out.print("" + added.real() + " + " + added.imag() + "i\n");
		gInt mul = null;
		mul = first.multiply(second);
		System.out.print("" + mul.real() + " + " + mul.imag() + "i\n");
		gInt normed = new gInt(3,1);
		System.out.print("norm of 3+1i is " + normed.norm() + "\n");
	}
}
