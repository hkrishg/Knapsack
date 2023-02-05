class Main {

  private int solveKnapsack(int[] profits, int[] weights, int capacity) {
    if (profits.length == 0 || capacity <= 0 || weights.length != profits.length)
      return 0;
    int n = profits.length;
    int[] dp = new int[capacity + 1];
//if we have only 1 weight
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