package codeWarsJava;

public class ToCamelCase {

	public static String toCamelCase(String s) {
		for (int i = 0; i < s.length(); i += 2) {
			if (s.substring(i, i + 3).contains("_") || (s.substring(i, i + 3).contains("-"))) {
				s.substring(i, i + 3).toUpperCase().replace("_", "").replace("-", "");
			} else {
				continue;
			}
		}
		return s;
	}
}
