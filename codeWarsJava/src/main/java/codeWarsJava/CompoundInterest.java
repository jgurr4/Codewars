package codeWarsJava;

public class CompoundInterest {
	public static double checker(double principal) {
		double amount = 0;
		double rate = .01;
		
		for(int day=1; day<=20; day++) {
			amount = principal*Math.pow(1 + rate, day);
			System.out.println(day + "   " + amount);
		}
		return amount;
	}

}

//Formula for Compound interest: A stands for Amount, 
//P is Principle, R is rate 
//n is number of years. A=P(1+R)^n  