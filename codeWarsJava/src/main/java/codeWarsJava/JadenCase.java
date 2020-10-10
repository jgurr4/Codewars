package codeWarsJava;

public class JadenCase {
	public static String toJadenCase(String phrase) {
		if (phrase == null || phrase.equals(""))
			return null;

		char[] array = phrase.toCharArray();

		for (int i = 0; i < array.length; i++) {
			if (i == 0 || array[i - 1] == ' ') {
				array[i] = Character.toUpperCase(array[i]);
			}
		}

		return new String(array);
	}
	// You can use string.charAt() or string.substring() for simple things like
	// capitalizing first letter of string.
}
