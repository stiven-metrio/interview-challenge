package com.challenge.demo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderByFrequencyShould {

  @ParameterizedTest
  @MethodSource("getValidScenarios")
  void getOrderCharactersByFrequency(String value, String expected) {
    var result = OrderByFrequency.getStringOrderByFrequency(value);
    assertEquals(expected, result);
  }

  public static Stream<Arguments> getValidScenarios() {
    return Stream.of(
      Arguments.of("bbbeeeed", "eeeebbbd"),
      Arguments.of("dssfasdfasdfsdarwe", "sssssddddaaafffrew"),
      Arguments.of("fda54a4fwat4fa454af", "aaaaa44444ffff55dtw")
    );
  }
}
