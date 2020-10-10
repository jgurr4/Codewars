package codeWarsJava;

import java.util.*;

public class SillyAddition {

	// 248 + 208 should equal 4416. Because our function doesn't like the concept of
	// carrying over numbers.
	// EXAMPLES: 23 + 28 = 411, and 36 + 245 = 2711 and 122 + 81 = 1103
	public static int add(int num1, int num2) {
		int answer = 0;
		String numbers1 = "";
		String numbers2 = "";
		ArrayList<String> result = new ArrayList<String>();
		numbers1 += num1;
		numbers2 += num2;

		int len1 = numbers1.length();
		int len2 = numbers2.length();

		for (int i = 1; i <= len1 && i <= len2; i++) {
			int numRes = Character.getNumericValue(numbers1.charAt(len1 - i))
					+ Character.getNumericValue(numbers2.charAt(len2 - i));
			result.add(String.valueOf(numRes));
		}
		if (len1 > len2) {
			int diff = len1 - len2;
			for (int i = 1; i <= diff; i++) {
				int numres = Character.getNumericValue(numbers1.charAt(diff - i));
				result.add(String.valueOf(numres));
			}
		} else if (len1 < len2) {
			int diff = len2 - len1;
			for (int i = 1; i <= diff; i++) {
				int numres = Character.getNumericValue(numbers2.charAt(diff - i));
				result.add(String.valueOf(numres));
			}
		}

		Collections.reverse(result);
		String strRes = result.toString();
		strRes = strRes.replace("[", "").replace("]", "").replace(",", "").replace(" ", "");
		answer += Integer.parseInt(strRes);
		return answer;
	}
}
