package com.challenge.demo;

import java.util.HashMap;
import java.util.Stack;

/**
 * Validates if the Parenthesis are properly organized
 */
public class ValidParentheses {

  /**
   * Validates if parentheses are properly organized
   *
   * @param parenthesesCombination the string with parentheses combination to validate
   * @return {@code true} if parentheses are organized and closed properly, {@code false} otherwise
   */
  public static boolean isValid(String parenthesesCombination) {
    StringBuilder sbParenthesesCombination = new StringBuilder(parenthesesCombination);
    var stringLength = sbParenthesesCombination.length();
    int closeCount = 0;
    if (sbParenthesesCombination.length() % 2 != 0) {
      return false;
    }
    for (int i = 0; i < stringLength; i++) {
      switch (sbParenthesesCombination.charAt(i)) {
        case ')':
          if (i == 0 || sbParenthesesCombination.charAt(i - 1) != '(')
            return false;
          sbParenthesesCombination.deleteCharAt(i).deleteCharAt(i - 1);
          i = 0;
          stringLength = sbParenthesesCombination.length();
          closeCount++;
          break;
        case ']':
          if (i == 0 || sbParenthesesCombination.charAt(i - 1) != '[')
            return false;
          sbParenthesesCombination.deleteCharAt(i).deleteCharAt(i - 1);
          i = 0;
          stringLength = sbParenthesesCombination.length();
          closeCount++;
          break;
        case '}':
          if (i == 0 || sbParenthesesCombination.charAt(i - 1) != '{')
            return false;
          sbParenthesesCombination.deleteCharAt(i).deleteCharAt(i - 1);
          i = 0;
          stringLength = sbParenthesesCombination.length();
          closeCount++;
          break;
      }
    }
    return closeCount >= parenthesesCombination.length() / 2;
  }

  /**
   * Validates if parentheses are properly organized
   *
   * @param parenthesesCombination the string with parentheses combination to validate
   * @return {@code true} if parentheses are organized and closed properly, {@code false} otherwise
   */
  public static boolean isValidBestSolution(String parenthesesCombination) {
    Stack<Character> stack = new Stack<>();
    HashMap<Character, Character> parenthesesMap = new HashMap<>();
    parenthesesMap.put(')', '(');
    parenthesesMap.put(']', '[');
    parenthesesMap.put('}', '{');
    for (char c : parenthesesCombination.toCharArray()) {
      if (parenthesesMap.containsValue(c)) {
        stack.add(c);
      } else if (parenthesesMap.containsKey(c)) {
        if (stack.isEmpty() || parenthesesMap.get(c) != stack.pop()) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}
