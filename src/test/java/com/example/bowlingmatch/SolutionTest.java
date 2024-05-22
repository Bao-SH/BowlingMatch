package com.example.bowlingmatch;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SolutionTest {

  @InjectMocks
  private Solution solution;

  @ParameterizedTest
  @MethodSource("rollsAndScores")
  void shouldCalculateScoresBasedOnBottlesWhenNotAllDownGivenOneRound(int[][] rolls, int expected) {
    int actual = solution.score(rolls);
    assertEquals(expected, actual);
  }

  public static Stream<Arguments> rollsAndScores() {
    return Stream.of(
      Arguments.of(new int[][]{{0, 0}}, 0),
      Arguments.of(new int[][]{{6, 0}}, 6),
      Arguments.of(new int[][]{{10, 0}}, 10)
    );
  }
}
