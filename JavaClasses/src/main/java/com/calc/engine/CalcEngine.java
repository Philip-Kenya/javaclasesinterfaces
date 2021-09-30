package com.calc.engine;

import java.time.LocalDate;
import java.util.Scanner;

public class CalcEngine {

	private static Scanner scanner;

	public static void main(String[] args) {
		double[] leftVals= {
				200.0d, 25.0d,225.0d, 11.0d	
		};
		double[] rightVals= {
				50.0d, 92.0d, 17.0d, 3.0d
		};
		char[] opCodes = {
				'd', 'a', 's','m'
		};
		double [] results = new double[opCodes.length];
		if (args.length==0) {


			for(int i =0 ; i<opCodes.length; i++)
			{
				results[i]= execute(opCodes[i], leftVals[i], rightVals[i]);
			}

			for(double currentResult: results)

				System.out.println(currentResult);}


		else if (args.length==3) {
			handleCommandLine(args);

		}

		else if(args.length==1 && args[0].equals("interactive"))
		{
			executeInteractively();
		}
		else {
			System.out.println("please provide an operation and 2 numeric values");
		}

	}
	static void executeInteractively()
	{ String newLine = System.getProperty("line.separator");
	System.out.println("Enter an opeartion and two numbers"+newLine );
	scanner = new Scanner(System.in);
	String userInput=scanner.nextLine();
	String[] parts = userInput.split(" ");
	System.out.println("part 0 is " +parts[0]);
	System.out.println("part 1 is " +parts[1]);
	System.out.println("part 2 is " +parts[2]);

	performOperation(parts);

	}
	private static void performOperation(String[] parts) {
		char opCode=opCodeFromString(parts[0]);
		if(opCode=='w')
			handleWhen(parts);
		else {
			double leftVal=valueFromWord(parts[1]);
			double rightVal=valueFromWord(parts[2]);
			double result=execute(opCode, leftVal, rightVal);
			displayResult(opCode, leftVal, rightVal, result);
		}






	}
	private static void handleWhen(String[] parts) {
		LocalDate startDate=LocalDate.parse(parts[1]);
		long daysToAdd=(long) valueFromWord(parts[2]);
		LocalDate newDate = startDate.plusDays(daysToAdd);
		String output= String.format("%s plus %d days is %s", startDate, daysToAdd, newDate);
		System.out.println(output);
		
	}
	private static void displayResult(char opCode, double leftVal, double rightVal, double result) {
		char symbol= symbolFromOpCode(opCode);
		/*
		 * StringBuilder builder = new StringBuilder(); builder.append(leftVal);
		 * builder.append(" "); builder.append(symbol); builder.append(" ");
		 * builder.append(rightVal); builder.append(" "); builder.append("= ");
		 * builder.append(result);
		 * 
		 * String output= builder.toString();
		 */
		String output= String.format("%.3f %c %.3f =%.3f",leftVal, symbol, rightVal, result);
		System.out.println(output);

	}
	private static char symbolFromOpCode(char opCode) {
		char[] opCodes= {'a', 's', 'm', 'd'};
		char [] symbols= {'+', '-', '*', '/'};
		char symbol='o';
		for (int index = 0; index < opCodes.length; index++) {
			if(opCode== opCodes[index])
			{
				symbol=symbols[index];
				break;

			}

		}
		return symbol;
	}
	private static void handleCommandLine(String[] args) {
		char opCode=args[0].charAt(0);
		double leftVal= Double.parseDouble(args[1]);
		double rightVal= Double.parseDouble(args[2]);
		double result= execute(opCode, leftVal, rightVal);
		System.out.println(result);

	}
	static double execute(char opCode, double leftVal, double rightVal)
	{
		double result=0;
		switch (opCode) {
		case 'a':
			result =leftVal+rightVal;
			break;
		case 's':
			result=leftVal-rightVal;
			break;	
		case 'm':
			result=leftVal*rightVal;
			break;	
		case 'd':

			if (rightVal!=0.0) {
				result =leftVal/rightVal;
			}
			break;	
		default:
			System.out.println("invalid opCode");
			result=0.0d;
			break;
		}
		return result;
	}
	static char opCodeFromString(String operationName)
	{
		char opCode =operationName.charAt(0);
		return opCode;
	}

	static double valueFromWord(String word) {
		String[] numberWords= {
				"zero","one", "two","three", "four", "five",
				"six", "seven", "eight", "nine "
		};
		double value=-1d;
		for(int index=0; index<numberWords.length; index++)
		{
			if(word.equals(numberWords[index]))
			{
				value=index;
				break;
			}
		}
		if(value==-1d)
		{
			value=Double.parseDouble(word);
		}
		return value;
	}
}



