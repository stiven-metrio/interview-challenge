package com.challenge.demo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderStringsShould {

  @ParameterizedTest
  @MethodSource("getAlphanumerics")
  void testStringOrdering(String str, String expected) {
    var result = OrderStrings.orderStrings(str);

    assertEquals(expected, result);
  }

  private static Stream<Arguments> getAlphanumerics() {
    return Stream.of(
      Arguments.of("asd5brfa6b7", "ads5abfr6b7"),
      Arguments.of("54frt4g5hts", "54frt4g5hst"),
      Arguments.of("54frt4g5hts5", "54frt4g5hst5"),
      Arguments.of("1111", "1111"),
      Arguments.of("zyxtsr", "rstxyz")
    );
  }
}
