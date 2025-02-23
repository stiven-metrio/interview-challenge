package com.challenge.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Order strings by frequency
 */
public class OrderByFrequency {

  /**
   * Orders a String based on the frequency of its characters, placing first the character that repeats the most
   *
   * @param str the string to be ordered
   * @return a frequency order string
   */
  public static String getStringOrderByFrequency(String str) {

    // Count occurrences
    HashMap<Character, Integer> map = new HashMap<>();
    for (char character : str.toCharArray()) {
      var value = map.getOrDefault(character, 0) + 1;
      map.put(character, value);
    }

    // Convert the Map in a List of entries
    List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(map.entrySet());
    // Sort the list
    entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

    // Get result
    StringBuilder result = new StringBuilder();
    for (Map.Entry<Character, Integer> entry: entryList) {
      result.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
    }
    return result.toString();
  }
}
