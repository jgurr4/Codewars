package codeWarsJava;

import java.util.ArrayList;
import java.util.Collections;

/*goal of this project, was to convert numbers to their binary representation, and then to
count the numbers of 1's that appear in that result. However, I like the utility of having 
the binary shown to me. So I'll put my original code in codewars as my answer, but for this
I'll leave just the code that gets me the binary result itself only.*/

//To convert a integer into binary do this: divide the number by 2 and save the remainder in a list, keep doing this 
//until the quotient equals 0. Then reverse the list, and it will equal the binary representation of the number.

public class BitCounting {
	public static String countBits(int n) {
		int q = 1;
		int r;
		ArrayList<Integer> nArr = new ArrayList<Integer>();
		
		while(q != 0) {
			r = n % 2;
			q = Math.floorDiv(n, 2);
			n = q;
			nArr.add(r);
		}
		Collections.reverse(nArr);
		StringBuilder builder = new StringBuilder();
		for (Integer value : nArr) {
		    builder.append(value);
		}
		String text = builder.toString();
		
		return text;
		
	}

	public static void addBits() {
		byte currentVal = (byte) 0b100;
		System.out.println(Integer.toBinaryString(currentVal));
		System.out.println(Integer.toBinaryString(currentVal + 0b010));
	}
}
