package Algoritms;
//121 Easy. Best Time to Buy and Sell Stock https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//Success
//Runtime: 993 ms, faster than 5.04% of Java online submissions for Best Time to Buy and Sell Stock.
//Memory Usage: 39.7 MB, less than 13.27% of Java online submissions for Best Time to Buy and Sell Stock.
import org.junit.Assert;
import org.junit.Test;
import java.util.*;


public class MaxProfit {

    public int maxProfit(int[] prices) { // результат не понравился, переделал ниже в методе maxProfit2
        List<Integer> sortedList = new ArrayList<>();
        for (int i = 0; i < prices.length; i++) {
            sortedList.add(prices[i]);
        }
        Collections.sort(sortedList);

        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int currentPrice = prices[i];
            sortedList.remove((Integer) currentPrice);
            int maxFuturePrice = sortedList.get(sortedList.size() - 1);
            if (maxFuturePrice - currentPrice > maxProfit) {
                maxProfit = maxFuturePrice - currentPrice;
            }
        }
        return maxProfit;
    }

//Runtime: 1 ms, faster than 99.18% of Java online submissions for Best Time to Buy and Sell Stock.
//Memory Usage: 39 MB, less than 26.10% of Java online submissions for Best Time to Buy and Sell Stock.

    public int maxProfit2(int[] prices) {
        int minValue = Integer.MAX_VALUE;
        Integer maxValue = null;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (minValue > prices[i]) {
                maxValue = maxValue != null ? maxValue - (minValue - prices[i]) : null;
                minValue = prices[i];
            }
            if (maxValue != null) {
                if (maxValue < prices[i]) {
                    if (maxValue > minValue) {
                        maxProfit = prices[i] - minValue;
                        maxValue = prices[i];
                    }
                }
            } else {
                if (prices[i] > minValue) {
                    maxProfit = prices[i] - minValue;
                    maxValue = prices[i];
                }
            }
        }
        return maxProfit;
    }

    @Test
    public void testMaxProfit(){
        int[] arr1 = new int[]{3,2,6,5,0,3};
        int[] arr2 = new int[]{3,2,6,5,0,3};
        Assert.assertEquals(new MaxProfit().maxProfit(arr1), 4);
        Assert.assertEquals(new MaxProfit().maxProfit(arr2), 4);
        Assert.assertEquals(new MaxProfit().maxProfit2(arr1), 4);
        Assert.assertEquals(new MaxProfit().maxProfit2(arr2), 4);
    }

    public static void main(String[] args) {
        System.out.println(new MaxProfit().maxProfit2(new int[]{3,2,6,5,0,3}));
    }
}
