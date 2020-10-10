package codeWarsJava;

/*
The goal of this kata is to make spaces between each camelCase word. Example: "camelCase" = "camel Case"
 */
public class CamelCaseWithSpace {
  public static String camelCase(String s) {
    if (!s.matches(".*[A-Z].*")) {
      return s;
    } //Makes sure that no time is wasted on words without caps.

    for (int i = 0; i < s.length(); i++) {
      if (Character.isUpperCase(s.charAt(i))) {
        String addSpace = " " + s.charAt(i);
        s = s.substring(0, i)
            + addSpace
            + s.substring(i + 1);
        i++;
      }
    }

    return s;
  }

}

//This method works just as well, but requires less code, and might perform slightly better too.
//  return s.replaceAll("([A-Z])", " $1");

//figure out what this does:
//  s.replace("", " ").trim();




//here was just experimental method I was trying to do with streams.
//  Stream<String> arr = Arrays.stream(s.split(""));
//    arr.map(e -> e.matches("[A-Z]")).forEach(e -> s.replace("" + e + "", " " + e + ""));
//
//        String newStr1 = String.valueOf(s.join(", "));
//        newStr1.replace("[", "").replace("]", "");
