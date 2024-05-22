package com.example.bowlingmatch;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BowlingMatchApplication {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[][] rolls = new int[][]{{0, 0}};
    int score = solution.getTotalScore(rolls);
    System.out.println(score);
  }
}
