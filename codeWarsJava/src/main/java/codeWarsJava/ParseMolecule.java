package codeWarsJava;

import java.util.*;

//The goal of this kata is to count the number of each atom that appears in a chemical formula, and return an object that maps
//each number to each atom that it coincides with. For example: H2O should return: [H: 2, O: 1]
//but also K4[ON(SO3)2]2 should return return ["K": 4, "O": 14, "N": 2, "S": 4]
public class ParseMolecule {
  public static Map<String,Integer> getAtoms(String formula) {
    HashMap<String, Integer> answer = new HashMap<String,Integer>();
    for(int i=0; i < formula.length(); i++){

//      answer.put(String.valueOf(i-1), i);

      }

    return answer;
  }
}
