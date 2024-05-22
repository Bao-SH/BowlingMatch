package com.example.bowlingmatch;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BowlingMatchApplication {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[][] rolls = new int[][]{{0, 0}};
    int score = solution.score(rolls);
    System.out.println(score);
  }
  // please design a method to calculate the score of the bowling game by using tdd, which needs to create test first. using junit5

}
