package com.example.bowlingmatch;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
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
  @MethodSource("rollsInSingleRoundAndScores")
  void shouldCalculateScoresBasedOnBottlesWhenNotAllDownGivenOneRound(int[][] rolls, int expected) {
    int actual = solution.getTotalScore(rolls);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("rollsInMultiRoundsAndScores")
  void shouldCalculateBonusWhenSpareOrStrikeGivenMultiRounds(int[][] rolls, int expected) {
    int actual = solution.getTotalScore(rolls);
    assertEquals(expected, actual);
  }

  @Test
  void shouldCalculateBonusWhenStrikeTwiceGivenMultiRounds() {
    int[][] rolls = new int[][]{{10, 0}, {10, 0}, {2, 3}};
    int expected = 10+10+2+10+2+3+2+3;
    int actual = solution.getTotalScore(rolls);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("rollsInFullRoundsAndScores")
  void shouldAddAnotherRoundWhenStrikeInRoundTenGivenFullRounds(int[][] rolls, int expected) {
    int actual = solution.getTotalScore(rolls);
    assertEquals(expected, actual);
  }

  public static Stream<Arguments> rollsInSingleRoundAndScores() {
    return Stream.of(
      Arguments.of(new int[][]{{0, 0}}, 0),
      Arguments.of(new int[][]{{6, 0}}, 6),
      Arguments.of(new int[][]{{10, 0}}, 10)
    );
  }

  public static Stream<Arguments> rollsInMultiRoundsAndScores() {
    return Stream.of(
      Arguments.of(new int[][]{{10, 0}, {8, 1}}, 10+8+1+8+1),
      Arguments.of(new int[][]{{8, 2}, {8, 1}}, 8+2+8+8+1),
      Arguments.of(new int[][]{{8, 1}, {8, 1}}, 8+1+8+1)
    );
  }

  public static Stream<Arguments> rollsInFullRoundsAndScores() {
    int[] strikeInRoundTen = new int[]{10, 0};
    int[] spareInRoundTen = new int[]{2, 8};
    int[] normalInRoundTen = new int[]{3, 1};
    int scoresBeforeRoundTen = 8 + 1 + 8 + 1 + 2 + 3 + 4 + 2 + 8 + 1 + 2 + 3 + 4 + 2 + 3 + 6 + 8 + 1;
    return Stream.of(
      Arguments.of(new int[][]{{8, 1}, {8, 1}, {2, 3}, {4, 2}, {8, 1}, {2, 3}, {4, 2}, {3,6}, {8, 1}, strikeInRoundTen, {2, 7}},
        scoresBeforeRoundTen + 10 + 2 + 7),
      Arguments.of(new int[][]{{8, 1}, {8, 1}, {2, 3}, {4, 2}, {8, 1}, {2, 3}, {4, 2}, {3,6}, {8, 1}, spareInRoundTen, {2, 7}},
        scoresBeforeRoundTen + 10 + 2),
      Arguments.of(new int[][]{{8, 1}, {8, 1}, {2, 3}, {4, 2}, {8, 1}, {2, 3}, {4, 2}, {3,6}, {8, 1}, normalInRoundTen, {2, 7}},
        scoresBeforeRoundTen + 3 + 1),
      Arguments.of(new int[][]{{10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}},
        300));
  }
}
