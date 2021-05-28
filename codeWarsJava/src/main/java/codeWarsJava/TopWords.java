package codeWarsJava;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//The goal of this kata is to find the top 3 most used words in a string or paragraph. Apostrophes are allowed
// and are their own word even if all letters are the same as another one, all other special characters must be replaced with spaces.
// Ties are broken arbitrarily, and if there are less than 3 possible words in the string, then result should contain
// whatever number of words exist or 0 if no words exist.
// upper and lower case words should match together if they have the same letters, and results must be lower case.
public class TopWords {
  static Map<String, Integer> m1 = new HashMap<String, Integer>();

  public static List<String> top3(String s) {
    System.out.println("String is : " + s);
    List<String> result = new ArrayList<String>();
    s = s.replaceAll("\\n"," ").toLowerCase();
    if (!s.matches(".*[A-Za-z].*")) {
      return Arrays.asList(new String[]{});
    }
    s = s.replaceAll("[^A-Za-z'\\s+]", " ");
    String[] s1 = s.trim().split("\\s+");
    System.out.println("Array is: " + Arrays.toString(s1));
    Stream.of(s1).forEach(e -> countWords(e));
    List<String> maxColl = getNextMax(m1);
    while (maxColl.size() < 3 && m1.size() > 0) {
      maxColl.addAll(getNextMax(m1));
    }
    int i = 0;
    while (maxColl.size() > 0 && i < 3) {
        result.add(maxColl.get(0));
        maxColl.remove(0);
        i++;
      }

    System.out.println("result is : " + result);
    m1.clear();
    return result;
  }

  private static List<String> getNextMax(Map<String, Integer> m1) {
    int max = Collections.max(m1.values());
    List<String> maxColl = m1.entrySet().stream().filter(entry -> entry.getValue() == max)
            .map(entry -> entry.getKey())
            .collect(Collectors.toList());
    for (String element : maxColl) { m1.remove(element); }
    return maxColl;
  }

  private static void countWords(String s) {
    if (m1.containsKey(s)) {
      m1.put(s, m1.get(s) + 1);
    } else {
      m1.put(s,1);
    }

  }
}
