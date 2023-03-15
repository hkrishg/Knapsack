class Main {
// Introduction #
// Given the weights and profits of ‘N’ items, we are asked to put these items in a knapsack which has a capacity ‘C’. The goal is to get the maximum profit out of the items in the knapsack. Each item can only be selected once, as we don’t have multiple quantities of any item.

// Let’s take the example of Merry, who wants to carry some fruits in the knapsack to get maximum profit. Here are the weights and profits of the fruits:

// Items: { Apple, Orange, Banana, Melon }
// Weights: { 2, 3, 1, 4 }
// Profits: { 4, 5, 3, 7 }
// Knapsack capacity: 5

// Let’s try to put various combinations of fruits in the knapsack, such that their total weight is not more than 5:

// Apple + Orange (total weight 5) => 9 profit
// Apple + Banana (total weight 3) => 7 profit
// Orange + Banana (total weight 4) => 8 profit
// Banana + Melon (total weight 5) => 10 profit

// This shows that Banana + Melon is the best combination as it gives us the maximum profit and the total weight does not exceed the capacity.

// Problem Statement #
// Given two integer arrays to represent weights and profits of ‘N’ items, we need to find a subset of these items which will give us maximum profit such that their cumulative weight is not more than a given number ‘C’. Each item can only be selected once, which means either we put an item in the knapsack or we skip it.
  private int solveKnapsack(int[] profits, int[] weights, int capacity) {
    if (profits.length == 0 || capacity <= 0 || weights.length != profits.length)
      return 0;
    int n = profits.length;
    int[] dp = new int[capacity + 1];
// if we have only 1 weight
    for (int c = 0; c <= capacity; c++) {
      if (weights[0] <= c)
        dp[c] = profits[0];
    }

    for (int i = 1; i < n; i++) {
      for (int c = capacity; c >= 0; c--) {
        int profit1 = 0, profit2 = 0;
        if (weights[i] <= c) {
          profit1 = profits[i] + dp[c - weights[i]];
        }
        profit2 = dp[c];
        dp[c] = Math.max(profit1, profit2);
      }
    }
    return dp[capacity];
  }

  public static void main(String[] args) {
    Main main = new Main();
    int[] profits = { 1, 6, 10, 16 };
    int[] wieghts = { 1, 2, 3, 5 };
    int maxProfit = main.solveKnapsack(profits, wieghts, 7);

    System.out.println(maxProfit);
  }
}