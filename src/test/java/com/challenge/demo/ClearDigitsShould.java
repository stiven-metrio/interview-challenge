package com.challenge.demo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClearDigitsShould {

  @ParameterizedTest
  @MethodSource("validStrings")
  void validScenarios(String s, String response) {
    var responseOne = ClearDigits.clearDigits(s);
    var responseTwo = ClearDigits.clearDigits2(s);

    assertEquals(responseOne, responseTwo);
    assertEquals(responseOne, response);
  }

  private static Stream<Arguments> validStrings() {
    return Stream.of(
      Arguments.of("abc34", "a"),
      Arguments.of("abc", "abc"),
      Arguments.of("abc34def45", "ad"),
      Arguments.of("abc", "abc"),
      Arguments.of("cb34", "")
    );
  }
}
