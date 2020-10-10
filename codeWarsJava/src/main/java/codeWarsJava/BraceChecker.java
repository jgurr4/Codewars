package codeWarsJava;

public class BraceChecker {
	public static boolean isValid(String braces) {
		String b = braces;
		System.out.println(braces);
		int previousLength = -1;
		while (previousLength != b.length()) {
			previousLength = b.length();
			b = b.replaceAll("\\(\\)", "");
			b = b.replaceAll("\\[\\]", "");
			b = b.replaceAll("\\{\\}", "");
		}
		return b.length() == 0;
	}
}
