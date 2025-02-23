package com.challenge.demo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidParenthesesShould {

  @ParameterizedTest
  @MethodSource("getParenthesesCombinations")
  void validate(String parenthesesCombination, boolean expected) {
    var result = ValidParentheses.isValid(parenthesesCombination);
    assertEquals(expected, result);
  }

  @ParameterizedTest
  @MethodSource("getParenthesesCombinations")
  void validateBest(String parenthesesCombination, boolean expected) {
    var result = ValidParentheses.isValidBestSolution(parenthesesCombination);
    assertEquals(expected, result);
  }

  private static Stream<Arguments> getParenthesesCombinations() {
    return Stream.of(
      Arguments.of("()", true),
      Arguments.of("()[]{}", true),
      Arguments.of("(]", false),
      Arguments.of("([])", true),
      Arguments.of("((", false)
    );
  }
}
