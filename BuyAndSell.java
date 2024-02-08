/* geeksforgeeks - Top 50 Array Coding Problems for Interviews
 * Hard - Stock buy and sell Problem - Stock Buy Sell to Maximize Profit
 * The cost of a stock on each day is given in an array. Find the maximum profit that you can make by buying and selling on those days. If the given array of prices is sorted in decreasing order, then profit cannot be earned at all.
 * Ekta Agrawal
 */

public class Main {
    public static int maxProfit (int[] arr) {
        int profit = 0;
        for (int i=1; i<arr.length; i++) {
            if (arr[i] > arr[i-1]) {
                profit = profit + arr[i] - arr[i-1];
            }
        }
        return profit;
    }
    public static void main(String[] args) {
        int[] arr = {100, 180, 260, 310, 40, 535, 695};
        System.out.print(maxProfit(arr));
    }
}
