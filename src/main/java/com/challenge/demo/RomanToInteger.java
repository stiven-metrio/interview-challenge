package com.challenge.demo;

/**
 * Convert roman numbers to integers
 */
public class RomanToInteger {

  /**
   * Convert a Roman number string to int
   *
   * @param s the roman number string
   * @return the integer representing the roman number
   */
  public static int romanToInt(String s) {
    StringBuilder strBuilder = new StringBuilder(s);
    int result = 0;
    while (!strBuilder.isEmpty()) {
      int value = switch (String.valueOf(strBuilder.charAt(0))) {
        case "I":
          yield handleEdgeCase(strBuilder, 1, "V", "X");
        case "V":
          yield 5;
        case "X":
          yield handleEdgeCase(strBuilder, 10, "L", "C");
        case "L":
          yield 50;
        case "C":
          yield handleEdgeCase(strBuilder, 100, "D", "M");
        case "D":
          yield 500;
        case "M":
          yield 1000;
        default:
          throw new IllegalStateException("Unexpected value: " + s.charAt(0));
      };
      strBuilder.delete(0, 1);
      result = result + value;
    }
    return result;
  }

  /**
   * Handles special cases where a smaller Roman numeral appears before a larger one,
   * indicating subtraction instead of addition.
   *
   * @param strBuilder the roman number
   * @param defaultValue the default value of the current number
   * @param firstChar the first special case numeral
   * @param secondChar the second special case numeral
   * @return teh adjusted value considering subtractions.
   */
  private static int handleEdgeCase(StringBuilder strBuilder, int defaultValue, String firstChar, String secondChar) {
    if (strBuilder.length() > 1) {
      String nextChart = String.valueOf(strBuilder.charAt(1));
      if (nextChart.equals(firstChar)) {
        strBuilder.delete(1, 2);
        return 4 * defaultValue;
      } else if (nextChart.equals(secondChar)) {
        strBuilder.delete(1, 2);
        return 9 * defaultValue;
      }
    }
    return defaultValue;
  }
}
