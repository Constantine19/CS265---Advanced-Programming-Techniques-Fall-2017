/**
 * Konstantin Zelmanovich
 * CS 265
 * Assignment 3
 * 28/11/2017
 * java version "1.8.0_144" on tux4.cs.drexel.edu
 */

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;


public class JavaCalc
{

	//Function to take an ArrayList with an infix and translate into postfix
	public static ArrayList<Token> infix2postfix(ArrayList<Token> infix)
	{
		
		ArrayList<Token> postfix = new ArrayList<Token>();
		infix.add(new Operator(opType.RPAR));

		Stack<Token> operators = new Stack<Token>();
		operators.push(new Operator(opType.LPAR));

		for(int i = 0; i<infix.size(); i++)
		{
			Token value = infix.get(i);
			if(value.isOperand())
			{
				postfix.add(value);
			}
			else
			{
				if(((Operator)value).getVal().getName().equals(")"))
				{
					while(!((Operator)operators.peek()).getVal().getName().equals("("))
				  {
						postfix.add(operators.pop());
					}
			      operators.pop();
				}
				else if(((Operator)value).getVal().getName().equals("("))
				{
					operators.push(value);
				}
				else
				{
					while(Operator.compare((Operator)value,(Operator)operators.peek()) <= 0)
					{
							postfix.add(operators.pop());
					}
					operators.push(value);
				}
			}
		}
		
		return postfix;
	}


	// Function to evaluate postfix	
	public static int evalPostfix(ArrayList<Token> pf)
	{
		
		Stack<Token> operators = new Stack<Token>();

		for(int i=0; i<pf.size(); i++)
		{
			Token value = pf.get(i);
			if(value.isOperand())
			{
				operators.push(value);
			}
			else
			{
				Operand a = (Operand)operators.pop();
				Operand b = (Operand)operators.pop();
				operators.push(new Operand(doTrans(a, b, (Operator)value)));
			}
		}
		return ((Operand)operators.pop()).getVal();
	}

	// Function to specify the order of each evaluation	
	public static int doTrans(Operand a, Operand b, Operator value)
	{
		int x = a.getVal();
		
		int y = b.getVal();
		
		String opTag = value.getVal().getName();

		if(opTag.equals("-"))
		{
			return x - y;
		}
		else if(opTag.equals("*"))
		{
			return x * y;
		}
		else if(opTag.equals("/"))
		{
			return x / y;				     
		}
		else if(opTag.equals("%"))
		{
			return x % y;				     
		}
		else if(opTag.equals("-"))
		{
			return x - y;				     
		}
		else
			return 0;
	}
	
	
	// Function to pass infix expression to infix2postfix
	public static ArrayList<Token> createInfix(String read)
	{
		ArrayList<Token> l = new ArrayList<Token>();
		try
		{
			Scanner search = new Scanner(read);
			while(search.hasNext())
			{
				String in = search.next();

				if(in.equals("-"))
				{
					l.add(new Operator(opType.SUB));
				}
				else if(in.equals("+"))
				{
					l.add(new Operator(opType.ADD));
				}
				else if(in.equals("%"))
				{
					l.add(new Operator(opType.MOD));
				}
				else if(in.equals("*"))
				{
					l.add(new Operator(opType.MULT));
				}
				if(in.equals("/"))
				{
					l.add(new Operator(opType.DIV));
				}
				else if(in.equals(")"))
				{
					l.add(new Operator(opType.RPAR));
				}
				else if(in.equals("("))
				{
					l.add(new Operator(opType.LPAR));
				}
				else
				{
					l.add(new Operand(Integer.parseInt(in)));
				}
			}
		}
		catch(Exception e){}
		
		return l;
	}


	// Main function to read the file
	public static void main(String[] args)
	{
		try
		{
			Scanner search = new Scanner(new File(args[0]));
			while(search.hasNextLine())
			{
				String in = search.nextLine();
				System.out.println(evalPostfix(infix2postfix(createInfix(in))));
			}
		}
		catch(Exception e){}
	}
}

