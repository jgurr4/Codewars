package codeWarsJava;

import java.util.Arrays;

//look up what goal of this was on codewars.
public class StringSplit {

	public static void splitter() {
		System.out.println(Arrays.toString(solution("HelloWorld")));
		System.out.println(Arrays.toString(solution("abc")));
		System.out.println(Arrays.toString(solution("My nameis")));
	}

	public static String[] solution(String s) {
		String[] fullArr = addSpace(s).split(",");
		return fullArr;
	}

	public static String addSpace(String s) {
		String subArrSet = "";
		for (int i = 0; i < s.length(); i += 2) {
			String subArr;
			if (i == s.length() - 1) {
				subArr = s.substring(i, i + 1);
			} else {
				subArr = s.substring(i, i + 2);
			}
			if (subArr.length() % 2 == 0) {
				subArrSet += subArr + ",";
			} else {
				subArrSet += subArr + "_";
			}
		}
		return subArrSet;
	}
}
