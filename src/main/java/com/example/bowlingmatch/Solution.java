package com.example.bowlingmatch;


public class Solution {
  public int score(int[][] rolls) {
    int totalScore = 0;
    for (int i = 0; i < rolls.length; i++) {
      totalScore += getScore(rolls, i);
    }
    return totalScore;
  }

  private int getScore(int[][] rolls, int i) {
    int first = rolls[i][0];
    int second = rolls[i][1];
    int rollsCounts = first + second;
    if (rollsCounts < 10) return rollsCounts;
    if (rollsCounts == 10) return 10 + getBonus();
    return 0;
  }

  private int getBonus() {
    return 0;
  }
}
