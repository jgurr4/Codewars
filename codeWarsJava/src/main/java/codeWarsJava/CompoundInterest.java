package codeWarsJava;

public class CompoundInterest {
	public static void checker() {
		double amount;
		double principal = 10000;
		double rate = .01;
		
		for(int day=1; day<=20; day++) {
			amount = principal*Math.pow(1 + rate, day);
			System.out.println(day + "   " + amount);
		}
	}

}

//Formula for Compound interest: A stands for Amount, 
//P is Principle, R is rate 
//n is number of years. A=P(1+R)^n  