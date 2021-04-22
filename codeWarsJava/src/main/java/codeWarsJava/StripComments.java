package codeWarsJava;

import java.util.Arrays;
import java.util.regex.Pattern;

// The first method I want to use to solve is CharArray loops, and arithmetic.
// The second method I want to use is multiple methods/function calls, possibly recursion, and functional streams.
// The third method I want to use is regexp.
// The fourth method I want to try is String splitting into array, and then joining into string again. just like javascript method.
// i.e. split at the newlines. remove the markers, remove spaces at end, and join together on newlines again.

//This method below uses regex, and split and join methods. It has been tested and successfullyl works for the kata.
public class StripComments {
  public static String stripComments(String text, String[] cs) {
    System.out.println("INPUT TEXT: " + text + "\nCOMMENT SYMBOLS: " + Arrays.toString(cs));
    if (text.matches("\\h*")) {
      return "";
    }
    String[] strArr = text.split("\\Q\n\\E");
    System.out.println(Arrays.toString(strArr));
    String[] noCommentSymbols = removeCS(strArr, cs);
    String[] noTrailingSpaces = removeSpaces(noCommentSymbols);
    String result = String.join("\n", noTrailingSpaces);
    System.out.println(result);
    return result;
  }

  public static String[] removeCS(String[] strArr, String[] cs) {
    for (int i = 0; i < strArr.length; i++) {
      int cs1 = findCS(strArr[i], cs);        //Find the first illegal symbol inside current string element. Calls findCS for each string element.
      if (cs1 == -1) {                        //If comment symbol was not found in the current element, then skip to the next.
        continue;
      }
      strArr[i] = strArr[i].replace(strArr[i].substring(cs1), "");   //remove everything from comment symbol to end of string element.
    }
    System.out.println("removeCS result: " + Arrays.toString(strArr));
    return strArr;
  }

  // Something is wrong with this method. At the moment, it only returns 0 for the given element if it has a illegal comment symbol even if the position is not at 0. For example "he!llo" would return 0,
  // when it should return 2.  I am satisfied with how it handles a element with no comment symbols however. So that part works ok.
  public static int findCS(String element, String[] cs) {  //checks given element for every single comment symbol. If a comment symbol exists, this will return the index value for that element.
    int result = -1;
    int[] temp = new int[cs.length];
    Boolean foundCS = false;
    for (int e = 0; e < cs.length; e++) {   //loops through each comment symbol that exists.
      for (int i = 0; i < element.length(); i++) {   //loops through each character of each element.
        Pattern commentSymbol = Pattern.compile("\\Q" + cs[e] + "\\E");
        if (commentSymbol.matcher(element).find() && element.indexOf(cs[e]) != -1) {   //If a illegal symbol is never found, then result will stay equal to -1.
          temp[e] = element.indexOf(cs[e]);
          foundCS = true;
          break;    //skip looping through current element searching for the current symbol since it was just found.
        }
      }
    }
    if (foundCS && Arrays.stream(temp).sum() != 0) {        //Checks if a comment symbol was found and the total was not equal to 0. if it is equal to 0 then that means the symbol is located at 0 index.
      result = Arrays.stream(temp).filter(num -> num != 0).min().getAsInt();         //set result equal to whichever comment symbol is the closest to beginning of element. If none exist, return -1.
    } else if (foundCS) {
      result = 0;
    }
    System.out.println("findCS Result: " + result);
    return result;
  }

  // This has an error, it currently remove all characters in the entire String, even if no spaces are found in the string. solution could be to use Pattern and compile and matcher
  // because those only affect the area of the string you want to match, not the entire string.
  public static String[] removeSpaces(String[] strArr) {  //Note, this must remove trailing spaces everywhere, including end of input line. But it cannot remove newlines anywhere.
    String[] result = new String[strArr.length];
    for (int i = 0; i < strArr.length; i++) {
      if (!strArr[i].matches("\\h*")) {   //If a illegal symbol is never found, then result will stay equal to -1.
        result[i] = strArr[i].stripTrailing();
      } else {
        result[i] = strArr[i];
      }
    }

    System.out.println("removeSpaces Result is: " + Arrays.toString(result));
    return result;
  }

}

/*
// below is a method which uses .format and split and regex replaceAll and streams all in one method. I found this method posted by another user who completed the kata. It has proven to work.
// There are other similar methods on the solutions page you should check out.
import java.util.Arrays;
import java.util.stream.Collectors;
public class StripComments {
  public static String stripComments(String text, String[] commentSymbols) {
    String pattern = String.format(
            "[ ]*([%s].*)?$",
            Arrays.stream( commentSymbols ).collect( Collectors.joining() )
    );
    return Arrays.stream( text.split( "\n" ) )
            .map( x -> x.replaceAll( pattern, "" ) )
            .collect( Collectors.joining( "\n" ) );
  }
}
*/


/*
    int[] csLocations = findEachCS(strArr, cs);
    String[] noCommentSymbols = removeCS(strArr, csLocations);
*/

/*  public static int[] findEachCS(String[] strArr, String[] cs) {
    System.out.println("findEachCS received input: " + Arrays.toString(strArr));
 //I'm going to try a different method, this one seems to be too complex.
    int[] result = new int[strArr.length];
    int index = 0;
      for (int e = 0; e < strArr.length; e++) {   // loop through each string in strArr.
        for (int c = 0; c < cs.length; c++) {         // loop through each symbol
        String section = strArr[e];
        for (int i = 0; i < section.length(); i++) {   // loop through each character inside each string in strArr.
          char myChar = cs[c].charAt(0);        //charAt can be 0 because there is only ever one symbol per element in cs.
          if (myChar == section.charAt(i)) {    // use current symbol to check if it matches any characters inside each String element in strArr.
            index = section.indexOf(cs[c]);   //Checks if index of one comment symbol is smaller than another. The smaller the number, the sooner it occurs in the string.
            break;                              //break out of loop through the element string inside strArr, because the first illegal symbol was already found.
          }
        }
        if (section.indexOf(cs[c]) != -1) {
          index = section.indexOf(cs[c]) < index ? section.indexOf(cs[c]) : index;   //Checks if index of one comment symbol appears sooner than another. For example, # may appear before $, so this makes sure to choose the correct one.
        } else {
          result[e] = section.indexOf(cs[c]);
        }
      }
    }
    System.out.println("findEachCS produced output: " + Arrays.toString(result));
    return result;
  }
*/

/*
  public static String[] removeCS(String[] strArr, int[] csLocations) {

    return new String[0];
  }
*/


/*
public class StripComments {
  public static String stripComments(String text, String[] cs) {
    System.out.println("INPUT TEXT: " + text + "\nCOMMENT SYMBOLS: " + Arrays.toString(cs));
    String result = "";
    int sectionLength = findNextCS(text, cs);
    int index = sectionLength;
    String curSection = text.substring(index, sectionLength);
    int ws = checkWhiteSpace(curSection);   //Tells how much of the current section should be added to the result based on how much whitespace from end needs to be removed.
    result += curSection.substring(0, ws);
    String.join("\n", cs);

    return result;
  }

  public static int findNextCS(String section, String[] cs) {
    int index = 0;
    for (int i = 0; i < cs.length; i++) {
      index = section.indexOf(cs[i]) < index ? section.indexOf(cs[i]) : index;   //Checks if index of one comment symbol is smaller than another. The smaller the number, the sooner it occurs in the string.
    }
    return index;
  }

  public static int checkWhiteSpace(String curSection) {
    int wsNumber = 0;
    for (int i = 0; i < curSection.length(); i++) {
      if (curSection.charAt(i) == ' ') {

      }
    }
    return 0;
  }

}
*/
/*
//Char Array method.
//Fix these two problems then resubmit:
// #1: Right now this code only works if the comment symbols is always constant at two values. It doesn't work if the number of comment symbols is variable. So I need to reformat my code to work with that.
// Example: ['$','!'] needs to work just as well as ['#','!','%','$'].
// #2: Another problem is that it preserves trailing whitespace at the end. Example: "a\n b\nc " in my program returns "a\n b\nc ". When it should be "a\n b\nc".
public class StripComments {
  public static String stripComments(String text, String[] cs) {
    System.out.println("INPUT TEXT: " + text + "\nCOMMENT SYMBOLS: " + Arrays.toString(cs));
    char[] cArr = text.toCharArray();
    String result = "";
    int index = 0;
    for (int c = 0; c < cs.length; c++) {
      for (int i = 0; i < cArr.length; i++) {
        if (cs[c].equals(Character.toString(cArr[i]))) {    //run code block if any character in loop equals either of the comment symbols.
          if (cArr[i - 1] == ' ') {
            result += new String(Arrays.copyOfRange(cArr, index, i - 1));                     //adds valid section minus the single trailing whitespace.
            // FIXME: Currently this fails because sometimes index is set higher than i - 1. you cannot use copyOfRange from a higher index to lower index number.
          } else {
            result += new String(Arrays.copyOfRange(cArr, index, i));                     //adds valid section that doesn't have any trailing whitespace.
          }
          for (int e = 0; e < Arrays.copyOfRange(cArr, i, cArr.length).length; e++) {             // Runs through each character following the comment symbol that was found.
            if (cArr[i + e] == '\n') {               // Stops the loop once it finds the next newline character.
              index = i + e;                       //sets index equal to the location of the next newline character.
              break;                               //breaks out of the inner loop so outer loop can continue.
            }
          }
        }
      }
      if (new String(Arrays.copyOfRange(cArr, index, cArr.length)).indexOf(cs[c]) == -1) {   //Checks if the last range of values that were not added have any illegal symbols inside. If not it adds them to result.
        result += new String(Arrays.copyOfRange(cArr, index, cArr.length));                     //adds valid section after the last commentSymbol if there is anything after that.
      }
    }
    return result;
  }
}
*/

// the problems with using char[] method:
// -> First, the original array cannot be altered to take characters out, you can update characters in a char array  or search through them only. This means I won't be able to remove characters in original array.
// solution is to make a new array which accepts characters from original array, but that only works if you know how long the end array result will be. So instead, perhaps you could use add the array items to a string,
// and then add use the length of that string to create the end result array. Or just simply keep it a String because the end result must be a string anyways.

/*
// Streams/functional programming method.
    String[] splitArr = text.split("\\n");
    for (int i = 0; i < cs.length; i++) {
      Arrays.stream(splitArr).filter(cs[i]::contains).map();
    }
    return text;

   // Stream.of(strArr).map(s -> s.chars().mapToObj(item -> (char) item).collect(Collectors.toList()));

// This method below relies on regex and Patterns classes.
// I need to save the newlines but remove whitespaces at the ends. I'm still somehow not able to do that with
// this code:
import java.util.regex.Pattern;

public class StripComments {
  public static String stripComments(String text, String[] commentSymbols) {
    for (int i = 0; i < commentSymbols.length; i++) {
      Pattern n = Pattern.compile("\\Q" + commentSymbols[i] + "\\E.*" + "\\Q\n\\E");
      Pattern p = Pattern.compile("\\Q" + commentSymbols[i] + "\\E.*$");
      if (n.matcher(text).find()) {
        for (int e = 0; e < n.matcher(text).results().count(); e++) {
          String removal = "\\Q" + commentSymbols[i] + "\\E.*" + "\\Q\n\\E";
          text = text.replaceAll(removal, "\n");
        }
      }
      if (p.matcher(text).find()) {
        for (int e = 0; e < p.matcher(text).results().count(); e++) {
          String removal = "\\Q" + commentSymbols[i] + "\\E" + ".*";
          text = text.replaceAll(removal, "").stripTrailing();
        }
      }
    }
    // remove all trailing spaces.
    text = text.replaceAll("\\h\n","\n");
    return text;
  }
}

 */