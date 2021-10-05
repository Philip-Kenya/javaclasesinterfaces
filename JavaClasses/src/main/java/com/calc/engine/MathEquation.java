package com.calc.engine;

public class MathEquation {
	
	double leftVal;
	double rightVal;
	char opCode;
	double result;
	
	void execute()
	{
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
	}
}
