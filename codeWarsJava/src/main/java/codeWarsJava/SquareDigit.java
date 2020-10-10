package codeWarsJava;



//The goal is to square every digit passed through and concatenate it. 9119 would return 811181
//because 9^2 is 81 and 1^2 is 1.
public class SquareDigit {
	public static int squareDigits(int n) {
		String answer = "";
		String number = String.valueOf(n);
	    for(int i = 0; i < number.length(); i++) {
	    	int num = Integer.parseInt(number.substring(i, i+1));
	    	answer += Integer.toString(num*num);  
	    }
	    
		return Integer.parseInt(answer);
	}
}


