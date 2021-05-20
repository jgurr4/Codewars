package codeWarsJava;

import java.util.ArrayList;
import java.util.Arrays;

//Tip: If you eliminate any directions, then the two outer directions must be compared. Example: [NORTH, EAST, WEST, SOUTH]
// would first become [NORTH, --- , --- , SOUTH]. Which then becomes [].
// Duplicate directions are allowed. For example [WEST, WEST]
public class DirReduction {
  public static String[] dirReduc(String[] arr) {
    Boolean unfinished = true;
    ArrayList<String> result = new ArrayList<String>(Arrays.asList(arr));
    int i = 0;
    while (unfinished) {
      unfinished = false;
      while (i < result.size() - 1) {
        if (opposite(result.get(i), result.get(i+1))) {
          result.remove(i);
          result.remove(i);
          unfinished = true;
        } else {
          i++;
        }
      }
      i = 0;
    }
    if (result.isEmpty()) {
      return new String[]{};
    }
    System.out.println(Arrays.toString((String[]) result.toArray(new String[result.size()])));
    return (String[]) result.toArray(new String[result.size()]);
  }

  private static boolean opposite(Object s1, Object s2) {
    if (s1 == "NORTH" && s2 == "SOUTH" || s1 == "SOUTH" && s2 == "NORTH") {
      return true;
    } else if (s1 == "EAST" && s2 == "WEST" || s1 == "WEST" && s2 == "EAST") {
      return true;
    }
    return false;
  }

}
