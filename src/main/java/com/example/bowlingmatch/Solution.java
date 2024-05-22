package com.example.bowlingmatch;


public class Solution {

  private static final int TEN = 10;

  public int getTotalScore(int[][] rolls) {
    int totalScore = 0;
    for (int i = 0; i < Math.min(10, rolls.length); i++) {
      totalScore += getScoreInOneRound(rolls, i);
    }
    return totalScore;
  }

  private int getScoreInOneRound(int[][] rolls, int i) {
    int first = rolls[i][0];
    int second = rolls[i][1];
    if (isStrike(first, second) || isSpare(first, second)) return TEN + getBonus(rolls, i);
    return first + second;
  }

  private int getBonus(int[][] rolls, int i) {
    int first = rolls[i][0];
    int second = rolls[i][1];
    if (i+1 >= rolls.length) return 0;
    int bonus = 0;
    if (isStrike(first, second)) {
      if (i+2 >=rolls.length) bonus = rolls[i+1][0] == TEN ? rolls[i+1][0] : rolls[i+1][0] + rolls[i+1][1];
      else bonus = isStrike(rolls[i+1][0], rolls[i+1][1]) ? rolls[i+1][0] + rolls[i+2][0] : rolls[i+1][0] + rolls[i+1][1];
    }
    if (isSpare(first, second)) return rolls[i + 1][0];
    return bonus;
  }

  private boolean isSpare(int first, int second) {
    return !isStrike(first, second) && first + second == TEN;
  }

  private boolean isStrike(int first, int second) {
    return first == TEN && second == 0;
  }
}
